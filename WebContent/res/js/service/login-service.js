app.service('loginService', [function () {
    this.setLoginSession = function (session) {
        localStorage.saLogin = session;
    };
    this.setLoginSessionTag = function (tag) {
        localStorage.saTag = tag;
    };
    this.getLoginSession = function () {
        return localStorage.saLogin;
    };
    this.logout = function () {
        this.setLoginSession('');
        this.setLoginSessionTag('');
    }
}]);