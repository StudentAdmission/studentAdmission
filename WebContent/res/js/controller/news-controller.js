app.controller('newsCtrl', ['$http', '$scope', function ($http, $scope) {
    $scope.setNews = function (item) {
        sessionStorage.newsTitle = item.itemTitle;
        sessionStorage.newsTime = item.itemTime;
        sessionStorage.newsContent = item.itemContent;
    };
    $http.post('news/item.do').then(function (response) {
        var content = '';
        if (response.status !== 200) {
            content += '<div class="connect-error">网络异常，请检查网络连接</div>';
        } else {
            var newsData = response.data;
            if (newsData.status !== 1) {
                content += '<div class="connect-error">数据库连接失败，请联系管理员</div>';
            } else {
                $scope.news = newsData.data;
            }
        }
        if (content !== '') {
            $('.sa-news-main').find('.sa-news-item').find('div.col-sm-12.sa-col').empty().after(content);
        }
    });
    $(function () {
        $('.news-intro').dotdotdot({
            truncate: 'letter'
        });

    });
}]);