app.controller('indexCtrl', ['$http', '$scope', function ($http, $scope) {
    $scope.test = "123123123";
}]);
app.controller('mainCtrl', ['$http', '$scope', '$route', function ($http, $scope, $route) {
    $scope.checkEdit = function (user) {
        console.log(user);
        $http.post('login', user).then(function (response) {
            console.log(response);
        }, function (response) {
            console.log('error');
        })
    }
}]);
app.controller('testCtrl', ['$http', '$scope', function ($http, $scope) {
    $scope.test = "test页面";
}]);