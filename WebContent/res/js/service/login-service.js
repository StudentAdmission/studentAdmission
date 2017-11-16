app.service('loginService', [function () {
    this.setLoginSession = function (session) {
        localStorage.saLogin = session;
    };
    this.setLoginSessionTag = function (tag) {
        localStorage.saTag = tag;
    };
    this.setLoginSessionPortrait = function (portrait) {
        localStorage.saPortrait = portrait;
    };
    this.getLoginSession = function () {
        return localStorage.saLogin;
    };
    this.getLoginSessionPortrait = function () {
        return localStorage.saPortrait;
    };
    this.logout = function () {
        this.setLoginSession('');
        this.setLoginSessionTag('');
        this.setLoginSessionPortrait('avatar.jpg');
    }
}]);