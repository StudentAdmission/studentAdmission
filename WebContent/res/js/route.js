app.config(['$routeProvider', '$locationProvider',
    function ($routeProvider, $locationProvider) {
        $locationProvider.html5Mode(true);
        $locationProvider.hashPrefix('');
        $routeProvider
        //首页路由
            .when('/', {
                controller: 'indexCtrl'
            })
            //学生手册页面路由
            .when('/manual', {
                templateUrl: 'sa_manual.html',
                controller: 'manualCtrl'
            }).when('/test', {
            templateUrl: 'test.html',
            controller: 'testCtrl'
        }).otherwise({
            redirectTo: '/'
        });
    }]);
