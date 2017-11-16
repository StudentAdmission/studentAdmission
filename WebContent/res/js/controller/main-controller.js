app.controller('mainCtrl', ['$http', '$scope', function ($http, $scope) {
    $scope.setNewsItem = function (item) {
        $http.post('news/item/one.do', item.homepageNewsId).then(function (response) {
            console.log(response);
            sessionStorage.newsTitle = response.data.data.itemTitle;
            sessionStorage.newsTime = response.data.data.itemTime;
            sessionStorage.newsContent = response.data.data.itemContent;
        });
    };

    $http.post('homepageNews.do').then(function (response) {
        var content = '';
        if (response.status !== 200) {
            content += '<div class="connect-error">网络异常，请检查网络连接</div>';
        } else {
            var homepageNews = response.data;
            if (homepageNews.status !== 1) {
                content += '<div class="connect-error">数据库连接失败，请联系管理员</div>';
            } else {
                $scope.homepageNews = homepageNews.data;
            }
        }
        if (content !== '') {
            $('.sa-home-info .sa-title .sa-list').remove();
            $('.sa-home-info .sa-homepage-news-content').after(content);
        }
    });

    $http.post('homepageReportingProcess.do').then(function (response) {
        var content = '';
        if (response.status !== 200) {
            content += '<div class="connect-error">网络异常，请检查网络连接</div>';
        } else {
            var homepageReportingProcess = response.data;
            if (homepageReportingProcess.status !== 1) {
                content += '<div class="connect-error">数据库连接失败，请联系管理员</div>';
            } else {
                $.each(homepageReportingProcess.data, function (index, item) {
                    content +=
                        '<div class="sa-list">' +
                        '<div class="sa-item">' +
                        '<p><a href=' + item.processLink + '>' + item.processItem + '</a>' + item.processTime + '</p>' +
                        '</div></div>';
                })
            }
        }
        $('.sa-home-info .sa-homepage-reporting-content').after(content);
    });

    $(function () {
        //启动轮播图
        $("#carousel").easyFader({
            sliderDur: 3000
        });
        $('.sa-news-content .sa-item a').dotdotdot({
            truncate: 'letter'
        });

    })
}])
;