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

app.controller('indexCtrl', ['$http', '$scope', 'loginService', 'introduceService', function ($http, $scope, loginService, introduceService) {

    $http.post('homepageNews.do').then(function (response) {
        var content = '';
        if (response.status !== 200) {
            content += '<div class="connect-error">网络异常，请检查网络连接</div>';
        } else {
            var homepageNews = response.data;
            if (homepageNews.status !== 1) {
                content += '<div class="connect-error">数据库连接失败，请联系管理员</div>';
            } else {
                $.each(homepageNews.data, function (index, item) {
                    content +=
                        '<div class="sa-list">' +
                        '<div class="sa-item">' +
                        '<p><a href=' + item.homepageNewsLink + '>' + item.homepageNewsTitle + '</a>' + item.homepageNewsTime + '</p>' +
                        '</div></div>';
                })
            }
        }
        $('.sa-home-info .sa-news-content').after(content);
    });

    $http.post('homepageReportingProcess.do').then(function (response) {
        console.log(response);
        var content='';
        if(response.status!==200){
            content += '<div class="connect-error">网络异常，请检查网络连接</div>';
        }else{
            var homepageReportingProcess=response.data;
            if(homepageReportingProcess.status!==1){
                content += '<div class="connect-error">数据库连接失败，请联系管理员</div>';
            }else{
                $.each(homepageReportingProcess.data, function (index, item) {
                    content +=
                        '<div class="sa-list">' +
                        '<div class="sa-item">' +
                        '<p><a href=' + item.processLink + '>' + item.processItem + '</a>' + item.processTime + '</p>' +
                        '</div></div>';
                })
            }
        }
        $('.sa-home-info .sa-reporting-content').after(content);
    });

    $scope.login = {
        loginNum: "",
        loginPwd: ""
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
    $scope.setIntroducePage = function (current) {
        introduceService.setCurrentPage(current);
    };
    $scope.getLoginSession = function () {
        return loginService.getLoginSession() ? loginService.getLoginSession : '';
    };
    $scope.logout = function () {
        loginService.logout();
        $scope.login.loginNum = '';
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

        function goTop() {
            $("html,body").animate({scrollTop: 0}, 500);
        }

        $('a').click(goTop);
        //启动轮播图
        $("#carousel").easyFader({
            sliderDur: 3000
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
    });
}]);