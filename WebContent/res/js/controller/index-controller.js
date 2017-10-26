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

app.controller('indexCtrl', ['$http', '$scope', '$location', 'introduceService', function ($http, $scope, $location, introduceService) {
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
            toastr.info($scope.login.loginPwd);
            console.log($scope.login);
            $http.post('login.do', $scope.login).then(function (response) {
                $scope.login.loginPwd = "";
                var responseData = response.data;
                if (responseData.status === 0) {
                    toastr.error('该用户不存在，请联系管理员');
                } else if (responseData.status === 1) {
                    toastr.success('登录成功');
                    $('#loginForm').hide();
                    $('#personalCenter').show();
                }
            }, function (response) {
                $scope.login.loginPwd = "";
                toastr.error('登录验证失败，请联系管理员');
                console.log(response);
            })
        }

    };
    $scope.setIntroducePage = function (current) {
        introduceService.setCurrentPage(current);
    };

    $(function () {

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
            'logo': 'show'
        });


    });
}]);