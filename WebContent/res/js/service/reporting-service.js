app.service('reportingService', [function () {
    var currentPage = 'sa-reporting-route';
    this.setCurrentPage = function (current) {
        currentPage = current;
    };
    this.getCurrentPage = function () {
        return currentPage;
    }
}]);