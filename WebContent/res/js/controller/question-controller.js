app.controller('questionCtrl', ['$http', '$scope', function ($http, $scope) {
    $http.post('commonProblem.do').then(function (response) {
        if (response.status !== 200) {
            $('.sa-question-item').after('' +
                '<div class="connect-error">网络异常，请检查网络链接。</div>'
            )
        } else {
            var problemData = response.data;
            if (problemData.status === 1) {
                var commonProblem = problemData.data;
                var content = '';
                $.each(commonProblem, function (index, item) {
                    content +=
                        '<div class="sa-question-item">' +
                        '<div class="item-title">Q：' + item.cPquestion + '</div>' +
                        '<div class="item-content">' + item.cPanswer + '</div>';
                    if (item.cPWebLinks === 'javascript:') {
                        content += '</div>';
                    } else {
                        content += '<div class="item-link"><a href=' + item.cPWebLinks + '>查看详情</a></div>' +
                            '</div>';
                    }
                });
                $('.sa-question-title').after(content);
            } else {
                $('.sa-question-item').after('' +
                    '<div class="connect-error">数据库异常，请联系管理员</div>'
                )
            }
        }
    });

}]);