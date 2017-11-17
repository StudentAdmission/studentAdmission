app.controller('newsDetailCtrl', ['$http', '$scope', function ($http, $scope) {
    $scope.newsTitle = sessionStorage.newsTitle;
    $scope.newsTime = sessionStorage.newsTime;
    $scope.newsContent = sessionStorage.newsContent.split('<br>');
}]);