$.fn.showDetail = function (option) {

    //显示内容入口
    var entry = this;

    //显示内容
    var detail = $(entry).find('.vin-detail');

    //默认参数
    entry.option = {
        opacity: 1,
        showSpeed: 1500,
        hideSpeed: 1500
    };

    //扩展默认参数
    $.extend(entry.option, option);

    //存放显示效果起点
    detail.start = {
        height: 0,
        opacity: 0,
        zIndex: 900,
        backgroundColor: 'white',
        cursor: 'auto'
    };

    //存放显示效果终点
    detail.end = {
        height: detail.height(),
        opacity: detail.css('opacity') ? detail.css('opacity') : entry.option.opacity
    };

    //显示内容样式的初始化
    initDetail();

    //点击入口开启显示内容
    $(entry).on('click', function () {
        if ($(detail).hasClass('vin-hide')) {
            show(detail);
            animateIn(detail);
        }
    });

    //点击文档中其他地方关闭显示内容
    $(document).on('click', function (event) {
        if (!$(event.target).closest(entry).length) {
            if ($(detail).hasClass('vin-show')) {
                hide(detail);
                animateOut(detail);
            }
        }
    });

    /**
     * 初始化显示内容的样式
     */
    function initDetail() {

        //显示内容的隐藏
        hide(detail);

        //显示内容样式的初始化，样式设置为动画起点
        $(detail).css(detail.start);

        $(entry).css('cursor', 'pointer');
    }

    /**
     * 显示目标对象
     * @param target DOM对象
     */
    function show(target) {
        $(target).css('display', 'block').removeClass('vin-hide').addClass('vin-show');
    }

    /**
     * 隐藏目标对象
     * @param target DOM对象
     */
    function hide(target) {
        $(target).removeClass('vin-show').addClass('vin-hide');
    }

    /**
     * 动画效果显示
     * @param target DOM对象
     */
    function animateIn(target) {
        $(target)

        //先停止正在进行的动画
            .stop()

            //再进行动画显示，宽、高、透明度变化至显示效果终点
            .animate({
                height: detail.end.height + 'px',
                opacity: detail.end.opacity
            }, entry.option.showSpeed);
    }

    /**
     * 动画效果隐藏
     * @param target
     */
    function animateOut(target) {
        $(target)

        //先停止正在进行的动画
            .stop()

            //再进行动画隐藏，宽、高、透明度变化至0
            .animate({
                    height: detail.start.height,
                    opacity: detail.start.opacity
                }, entry.option.hideSpeed, function () {
                    $(target).css('display', 'none');
                }
            );
    }
};