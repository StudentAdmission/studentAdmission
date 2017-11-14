app.controller('newsDetailCtrl', ['$http', '$scope', function ($http, $scope) {
    $scope.newsTitle = sessionStorage.newsTitle;
    $scope.newsTime = sessionStorage.newsTime;
    $scope.newsContent = sessionStorage.newsContent;
    var newsContent = $scope.newsContent.split('<br>');
    $(function () {
        var content = '';
        $.each(newsContent, function (index, item) {
            content += '<p>' + item + '</p>';
        });
        $('.sa-news-detail-main').find('.news-content').append(content);
    })
}]);