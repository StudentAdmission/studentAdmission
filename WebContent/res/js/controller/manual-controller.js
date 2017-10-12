app.controller('manualCtrl', ['$http', '$scope', function ($http, $scope) {
    $scope.currentYear = 2015;
    $http.get('res/data/manualData.json').then(function (response) {
        console.log(response.data);
        if (response.data.status === 200) {
            $.each(response.data.data, function (index, item) {
                if (item.year === $scope.currentYear) {
                    $scope.manualUrl = item.filePath + item.fileName;
                }
            })
        }
        PDFObject.embed($scope.manualUrl, '#pdf');
    })
}]);