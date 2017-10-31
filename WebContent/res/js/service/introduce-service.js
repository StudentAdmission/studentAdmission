app.service('introduceService', [function () {
    var currentPage = 'sa-school-intro';
    this.setCurrentPage = function (current) {
        currentPage = current;
    };
    this.getCurrentPage = function () {
        return currentPage;
    }
}]);