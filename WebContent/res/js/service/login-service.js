app.service('loginService',[function () {
    this.setLoginSession=function (session) {
        localStorage.login=session;
    };
    this.getLoginSession=function () {
        return localStorage.login;
    };
    this.logout=function () {
        this.setLoginSession('');
    }
}]);