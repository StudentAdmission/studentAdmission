toastr.options = {
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-top-right",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
};

/**
 * 设置延迟时间
 * @param delay 分钟为单位
 * @returns {number} 当前时间减去delay时间的毫秒数
 */
function setTime(delay) {
    var date = new Date();
    return date.getTime() + delay * 60000;
}

app.controller('indexCtrl', ['$http', '$scope', 'loginService', 'introduceService', 'reportingService', function ($http, $scope, loginService, introduceService, reportingService) {

    $scope.login = {
        loginNum: "",
        loginPwd: ""
    };
    $scope.forgetTag = {
        loginNum: true,
        loginEmail: true,
        loginCode: true,
        loginPwd: true
    };
    $scope.forgotten = {
        num: '',
        email: '',
        validate: '',
        pwd: '',
        newPwd: ''
    };
    $scope.saLogin = function () {
        if ($scope.login.loginNum === "") {
            toastr.error('请输入用户名');
            $scope.login.loginPwd = "";
        } else if ($scope.login.loginPwd === "") {
            toastr.error('请输入密码');
            $scope.login.loginPwd = "";
        } else {
            $scope.login.loginPwd = md5($scope.login.loginPwd);
            $http.post('login.do', $scope.login).then(function (response) {
                $scope.login.loginPwd = "";
                var responseData = response.data;
                if (responseData.status === 0) {
                    toastr.error('该用户不存在，请联系管理员');
                } else if (responseData.status === 1) {
                    var validateTime = setTime(20);
                    $http.post('login/time.do', {
                        loginNum: $scope.login.loginNum,
                        loginTime: validateTime
                    }).then(function (response) {
                        if (response.data.status === 1) {
                            loginService.setLoginSession(responseData.data.loginNum);
                            loginService.setLoginSessionTag(responseData.data.loginTag);
                            loginService.setLoginSessionPortrait(responseData.data.loginPortrait);
                            loginService.setLoginSessionNickname(responseData.data.loginNickname);
                            toastr.success('登录成功');
                        }
                    }, function () {
                        toastr.error('设置登录时间失败，请联系管理员');
                    });
                }
            }, function () {
                $scope.login.loginPwd = "";
                toastr.error('登录验证失败，请联系管理员');
            })
        }
    };
    $scope.getCode = function () {
        if (!$scope.forgetTag.loginEmail || $scope.forgotten.email !== '') {
            $('#forgottenEmail').addClass('forgetError');
            toastr.remove();
            toastr.error('请输入正确邮箱');
        } else {
            var validateTime = 30;
            $('#forgottenCode').parent().addClass('gettingValidate');
            var interval = setInterval(function () {
                $('#forgottenCode').siblings('button').attr('disabled', 'disabled').html(validateTime + 's后重试');
                validateTime--;
            }, 1000);
            setTimeout(function () {
                clearInterval(interval);
                $('#forgottenCode').siblings('button').removeAttr('disabled').html('获取验证码');
                $('#forgottenCode').parent().removeClass('gettingValidate');
            }, 31000);

            $http.post('mail.do', "'" + $scope.forgotten.email + "'").then(function (response) {
                if (response.status !== 200) {
                    toastr.remove();
                    toastr.error('网络连接失败');
                } else {
                    var codeData = response.data;
                    if (codeData.status !== 1) {
                        toastr.remove();
                        toastr.error('服务器异常，请联系管理员');
                    } else {
                        $scope.personalCode = codeData.data.code;
                    }
                }
            })
        }
    };
    $scope.submitNewPwd = function () {

        var forgetTag = $scope.forgetTag;
        if (forgetTag.loginNum && forgetTag.loginEmail && forgetTag.loginCode && forgetTag.loginPwd) {
            var forgotten = $scope.forgotten;
            if (forgotten.num === '') {
                $scope.forgetTag.loginNum = false;
            } else if (forgotten.email === '') {
                $scope.forgetTag.loginEmail = false;
            } else if (forgotten.validate === '') {
                $scope.forgetTag.code = false;
            } else if (forgotten.pwd === '' || forgotten.newPwd === '') {
                $scope.forgetTag.loginPwd = false;
            } else {
                forgotten.newPwd = md5(forgotten.newPwd);
                forgotten.pwd = md5(forgotten.pwd);
                $http.post('forget/pwd.do', "{loginNum:'" + forgotten.num + "',loginEmail:'" + forgotten.email + "',loginPwd:'" + forgotten.newPwd + "'}").then(function (response) {
                    if (response.data.status === 1) {
                        toastr.remove();
                        toastr.success('密码修改成功');

                        $('.forgotten-dialogue.vin-show').removeClass('vin-show').addClass('vin-hide')

                        //先停止正在进行的动画
                            .stop()

                            //再进行动画隐藏，宽、高、透明度变化至0
                            .animate({
                                    height: 0,
                                    opacity: 0
                                }, 1000, function () {
                                    $('.forgotten-dialogue.vin-show').css('display', 'none');
                                }
                            );
                        $scope.forgotten = {
                            num: '',
                            email: '',
                            validate: '',
                            pwd: '',
                            newPwd: ''
                        };
                    } else {
                        toastr.remove();
                        toastr.error('密码修改失败，请联系管理员')
                    }
                })
            }
        }
    };
    $scope.setIntroducePage = function (current) {
        introduceService.setCurrentPage(current);
    };
    $scope.setReportingPage = function (current) {
        reportingService.setCurrentPage(current);
    };
    $scope.getLoginSession = function () {
        return loginService.getLoginSession() ? loginService.getLoginSession : '';
    };
    $scope.logout = function () {
        loginService.logout();
        $scope.login.loginNum = '';
        toastr.remove();
        toastr.info("注销成功");
    };

    $(function () {
        if (localStorage.saLogin) {
            $http.post('login/gettime.do', {loginNum: localStorage.saLogin}).then(function (response) {
                var currentTime = setTime(0);
                if (currentTime >= response.data.data.loginTime) {
                    loginService.logout();
                }
            });
        }
        if (loginService.getLoginSessionPortrait()) {
            $('#personalCenter>img').attr('src', 'res/img/' + loginService.getLoginSessionPortrait());
        }

        function goTop() {
            $("html,body").animate({scrollTop: 0}, 500);
        }

        $(window).on('scroll', function () {
            var scrollTop = $(this).scrollTop();
            if (scrollTop > 0) {
                $('.go-top').fadeIn();
            } else {
                $('.go-top').fadeOut();
            }
        });
        $('.go-top').on('click', function () {
            goTop();
        });
        $(".sa-tip").tipso({
            useTitle: false
        });
        $('.supreme-head-background').smint({
            'marginTop': 0,
            'top': 0,
            'logo': 'show',
            'width': '100%'
        });
        $('#forgotten').showDetail({
            opacity: 1,
            showSpeed: 1500,
            hideSpeed: 1500
        });
        $('#forgottenNum').on({
            'blur': function () {
                if (!$scope.forgotten.num.match(/^[0-9]*$/g)) {
                    toastr.remove();
                    toastr.error('用户名只允许输入数字');
                    $scope.forgetTag.loginNum = false;
                    $('#forgottenNum').addClass('forgetError');
                } else {
                    $('#forgottenNum').removeClass('forgetError');
                    $http.post('forgetPwd.do', "'" + $scope.forgotten.num + "'").then(function (response) {
                        $scope.personalEmail = response.data.data.login_email ? response.data.data.login_email : '';
                    })
                }
            },
            'focus': function () {
                $('#forgottenNum').removeClass('forgetError');
            }
        });
        $('#forgottenEmail').on({
            'blur': function () {
                if ($scope.forgotten.email !== '') {
                    if (!$scope.forgotten.email.match(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/g)) {
                        $scope.forgetTag.loginEmail = false;
                        $('#forgottenEmail').addClass('forgetError');
                        toastr.remove();
                        toastr.error('请检查邮箱格式');
                    } else {
                        if ($scope.forgotten.email !== $scope.personalEmail) {
                            $scope.forgetTag.loginEmail = false;
                            $('#forgottenEmail').addClass('forgetError');
                            toastr.remove();
                            toastr.error('邮箱输入有误');
                        } else {
                            $scope.forgetTag.loginEmail = true;
                            $('#forgottenEmail').removeClass('forgetError');
                        }
                    }
                }
            },
            'mouseleave': function () {
                if ($scope.forgotten.email !== '') {
                    if (!$scope.forgotten.email.match(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/g)) {
                        $scope.forgetTag.loginEmail = false;
                        $('#forgottenEmail').addClass('forgetError');
                        toastr.remove();
                        toastr.error('请检查邮箱格式');
                    } else {
                        if ($scope.forgotten.email !== $scope.personalEmail) {
                            $scope.forgetTag.loginEmail = false;
                            $('#forgottenEmail').addClass('forgetError');
                            toastr.remove();
                            toastr.error('邮箱输入有误');
                        } else {
                            $scope.forgetTag.loginEmail = true;
                            $('#forgottenEmail').removeClass('forgetError');
                        }
                    }
                }
            },
            'focus': function () {
                $('#forgottenEmail').removeClass('forgetError');
            }
        });
        $('#forgottenCode').parent().on({
            'mouseenter': function () {
                if (!$(this).hasClass('gettingValidate')) {
                    $scope.forgetTag.loginEmail = !!($scope.forgotten.email && $scope.forgotten.email === $scope.personalEmail);
                }
            }
        });
        $('#forgottenCode').on({
            'blur': function () {
                if ($scope.forgotten.validate && $scope.forgotten.validate !== $scope.personalCode) {
                    $(this).addClass('forgetError');
                    toastr.remove();
                    toastr.error('验证码输入有误');
                } else {
                    $(this).removeClass('forgetError');
                }
            },
            'focus': function () {
                $(this).removeClass('forgetError');
            }
        });

        $('.sa-forgotten-pwd-input').on({
            'blur': function () {
                if ($scope.forgotten.pwd !== '' && $scope.forgotten.newPwd !== '') {
                    if ($scope.forgotten.pwd !== $scope.forgotten.newPwd) {
                        toastr.remove();
                        toastr.error('两次输入的密码不一致');
                        $scope.forgetTag.loginPwd = false;
                        $(this).addClass('forgetError');
                    } else {
                        $('.sa-forgotten-pwd-input').removeClass('forgetError');
                        $scope.forgetTag.loginPwd = true;
                    }
                }
            },
            'mouseleave': function () {
                if ($scope.forgotten.pwd !== '' && $scope.forgotten.newPwd !== '') {
                    if ($scope.forgotten.pwd !== $scope.forgotten.newPwd) {
                        toastr.remove();
                        toastr.error('两次输入的密码不一致');
                        $scope.forgetTag.loginPwd = false;
                        $(this).addClass('forgetError');
                    } else {
                        $('.sa-forgotten-pwd-input').removeClass('forgetError');
                        $scope.forgetTag.loginPwd = true;
                    }
                }
            },
            'focus': function () {
                $(this).removeClass('forgetError');
            }
        });

    });
}]);