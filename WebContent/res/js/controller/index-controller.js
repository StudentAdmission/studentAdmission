app.controller('indexCtrl', ['$http', '$scope', function ($http, $scope) {
    $scope.test = "123123123";
    console.log($scope);
}]);
app.controller('mainCtrl', ['$http', '$scope', '$route', function ($http, $scope, $route) {
    $scope.test="main页面";
    console.log($scope);
}]);
app.controller('testCtrl', ['$http', '$scope', function ($http, $scope) {
    $scope.test = "test页面";
    console.log($scope);
}]);