app.controller('newsCtrl', ['$http', '$scope', function ($http, $scope) {
    $(function () {
        $('.news-intro').dotdotdot({
            truncate: 'letter'
        });
    });
}]);