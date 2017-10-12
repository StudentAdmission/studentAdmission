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