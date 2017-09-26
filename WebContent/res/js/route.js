app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('');
    $routeProvider.when('/test', {
        templateUrl: 'test.html',
        controller: 'testCtrl'
    })
}]);