$.fn.smint = function (option) {
    $(this).addClass('smint');
    // get initial top offset for the menu
    var stickyTop = $(this).offset().top;
    var stickyLeft = $(this).offset().left;
    var clone = $(this).clone(true).css({
        'position': 'fixed',
        'left': stickyLeft,
        'top': 0,
        'width': option.width,
        'zIndex': 9999,
        'marginTop': option.marginTop,
        'display': 'none'
    });
    $(clone).appendTo($(this).parent());
    var ua = navigator.userAgent;
    var firefox = "Firefox";
    if (ua.indexOf(firefox) > -1 && option.logo !== 'show') {
        $(clone).css('left', stickyLeft - 8.5);
    }
    var self = this;
    // check position and make sticky if needed
    var stickyMenu = function () {

        // current distance top
        var scrollTop = $(window).scrollTop();
        // if we scroll more than the navigation, change its position to fixed and add class 'fxd', otherwise change it back to absolute and remove the class
        if (scrollTop > stickyTop - option.top) {
            $(clone).show();
            if (option.logo === 'show') {
                $('.logo-small').fadeIn();
            }
        } else {
            $(clone).hide();
            if (option.logo === 'show') {
                $('.logo-small').fadeOut('fast');
            }
        }
    };

    // run function
    stickyMenu();

    // run function every time you scroll
    $(window).scroll(function () {
        stickyMenu();
    });

    $(window).resize(function () {
        stickyLeft = $(self).offset().left;
        $(clone).css('left', stickyLeft);
    })

};

