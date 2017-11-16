app.service('loginService', [function () {
    this.setLoginSession = function (session) {
        localStorage.saLogin = session;
    };
    this.getLoginSession = function () {
        return localStorage.saLogin;
    };
    this.logout = function () {
        this.setLoginSession('');
    }
}]);