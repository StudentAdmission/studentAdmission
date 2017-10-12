app.controller('manualCtrl', ['$http', '$scope', function ($http, $scope) {
    $scope.currentYear = 2015;
    $http.get('data/manualData.json').then(function (response) {
        console.log(response);
    })
}]);