app.config([ '$routeProvider', '$locationProvider', '$httpProvider',
		function($routeProvider, $locationProvider, $httpProvider) {
			$locationProvider.html5Mode(true);
			$locationProvider.hashPrefix('');
			$routeProvider.when('/', {
				controller : 'indexCtrl'
			}).when('/main', {
				templateUrl : 'main.html',
				controller : 'mainCtrl'
			}).when('/test', {
				templateUrl : 'test.html',
				controller : 'testCtrl'
			}).otherwise({
				redirectTo : '/'
			});
		} ]);
