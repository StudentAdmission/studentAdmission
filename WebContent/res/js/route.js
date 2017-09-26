app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('');
    $routeProvider.when('/main', {
        templateUrl: 'main.html',
        controller: 'mainCtrl'
    }).when('/test', {
        templateUrl: 'test.html',
        controller: 'testCtrl'
    }).otherwise({
        redirectTo: '/main'
    });
}]);
