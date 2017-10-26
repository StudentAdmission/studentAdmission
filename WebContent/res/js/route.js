app.config(['$routeProvider', '$locationProvider',
    function ($routeProvider, $locationProvider) {
        $locationProvider.html5Mode(true);
        $locationProvider.hashPrefix('');
        $routeProvider
        //首页路由
            .when('/', {
                templateUrl:'sa-main.html',
                controller: 'indexCtrl'
            })
            //学生手册页面路由
            .when('/manual', {
                templateUrl: 'sa-handbook.html',
                controller: 'handbookCtrl'
            })
            //学校简介页面路由
            .when('/introduce', {
            templateUrl: 'sa-introduce.html',
            controller: 'introduceCtrl'
        }).otherwise({
            redirectTo: '/'
        });
    }]);
