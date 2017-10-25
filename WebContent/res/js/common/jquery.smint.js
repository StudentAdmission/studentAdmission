$.fn.smint = function (option) {
    $(this).addClass('smint');
    // get initial top offset for the menu
    var stickyTop = $(this).offset().top;
    var stickyLeft = $(this).offset().left;
    var stickyWidth = $(this).width();
    var self = this;

    // check position and make sticky if needed
    var stickyMenu = function () {

        // current distance top
        var scrollTop = $(window).scrollTop();
        // if we scroll more than the navigation, change its position to fixed and add class 'fxd', otherwise change it back to absolute and remove the class
        if (scrollTop > stickyTop - option.top) {
            $(self).css({
                'position': 'fixed',
                'left': stickyLeft,
                'top': 0,
                'width': stickyWidth,
                'zIndex': 10,
                'marginTop': option.marginTop
            });
            if (option.logo === 'show') {
                $('.logo-small').fadeIn();
            }
        } else {
            $(self).removeAttr('style');
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

};

