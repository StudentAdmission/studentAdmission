app.controller('indexCtrl', ['$http', '$scope', '$location', function ($http, $scope, $location) {
    $scope.saLogin = function (login) {
        $scope.login = {
            "login_num": "",
            "login_pwd": ""
        };
        login.login_pwd = md5(login.login_pwd);
        $http.post('login.do', login).then(function (response) {
            var responseData = response.data;
            console.log(responseData);
        }, function (response) {
            console.log(response);
        })
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