app.controller('indexCtrl', [ '$http', '$scope', function($http, $scope) {
	$scope.checkEdit = function(user) {
		console.log(user);
		$http.post('login.do',user).then(function(response) {
			console.log(response);
		}, function(response) {
			console.log('error');
		})
	}
} ]);
app.controller('mainCtrl', [ '$http', '$scope', '$route',
		function($http, $scope, $route) {
			
		} ]);
app.controller('testCtrl', [ '$http', '$scope', function($http, $scope) {
	$scope.test = "test页面";
} ]);