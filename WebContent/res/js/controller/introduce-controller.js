app.controller('introduceCtrl', ['$scope', '$http', 'introduceService', function ($scope, $http, introduceService) {


    $(function () {

        //左侧导航添加固定方法
        $('#jquery-accordion-menu').smint({
            'marginTop': 50,
            'top': 50
        });

        //左侧导航点击事件
        $('#jquery-accordion-menu').jqueryAccordionMenu();

        //根据id显示页面
        function showPage(id) {
            $('#' + id).fadeIn();
        }

        //根据id隐藏页面
        function hidePage(id) {
            $('#' + id).fadeOut();
        }

        function setDefaultPage(id) {

            //根据introduceService中currentPage的值，设置对应的active类
            $("#demo-list li[data-show-page=" + id + "]").addClass('active');

            //设置默认显示页面
            showPage(id);
        }

        //从introduceService中获取currentPage的值，并传入setDefaultPage方法中
        setDefaultPage(introduceService.getCurrentPage());

        //左侧导航项点击后添加active类
        $("#demo-list li").click(function () {

            //添加判断方法，当前点击项是当前显示项时，跳过该方法
            if ($("#demo-list li.active").data('show-page') !== $(this).data('show-page')) {
                hidePage($("#demo-list li.active").data('show-page'));
                $("#demo-list li.active").removeClass("active");
                $(this).addClass("active");
                showPage($(this).data('show-page'));
            }
        });

        /**
         * 给item项添加current类，并移除兄弟节点的current类
         * @param item
         */
        function addCurrent(item) {
            $(item).siblings().removeClass('current');
            $(item).addClass('current');
        }

        /**
         * 带有current类的坐标按钮移除btn-default类，添加btn-info类，兄弟结点反之
         */
        function setCurretLoactionButton() {
            $('.school-location-button.current').siblings().removeClass('btn-info').addClass('btn-default');
            $('.school-location-button.current').removeClass('btn-default').addClass('btn-info');
        }

        /**
         * 设置学校地图中心点以及标注点文字说明
         * @param option
         */
        function setSchoolMap(option) {
            var map = new AMap.Map('schoolMap', {
                //可缩放
                resizeEnable: true,
                //放大级别
                zoom: 16,
                //中心点
                center: option.center
                //健翔桥[116.382408, 39.988895]
            });

            //点标注
            var marker = new AMap.Marker({

                //标注位置：地图中心点
                position: map.getCenter(),

                //不可拖拽
                draggable: false,

                // 设置点标记的动画效果，此处为掉落效果
                animation: "AMAP_ANIMATION_DROP",
                content: "<i class='fa fa-3x fa-map-marker' style='color: red;'></i>"
            });
            marker.setMap(map);

            //label默认蓝框白底左上角显示，样式className为：amap-marker-label
            marker.setLabel({

                //修改label相对于maker的位置
                offset: new AMap.Pixel(30, 10),

                //label文本内容
                content: option.content
                // "健翔桥校区"
            });

            /**
             * 给地图添加工具栏
             */
            map.plugin(["AMap.ToolBar"], function () {
                map.addControl(new AMap.ToolBar());
            });
            if (location.href.indexOf('&guide=1') !== -1) {
                map.setStatus({scrollWheel: false})
            }
        }

        /**
         * 设置地址和邮编
         * @param option
         */
        function setAddress(option) {
            $('.address').html("地址：" + option.address);
            $('.zip-code').html("邮编：" + option.zipCode);
        }

        /**
         * 学校坐标按钮绑定点击事件，点击后当前项设置current类以及btn-info类
         */
        $('.school-location-button').bind('click', function () {
            addCurrent(this);
            setCurretLoactionButton();
            var self = this;
            var flag = false;
            //从缓存中获取校区地址数据
            $http.post('res/data/campusAddressData.json').then(function (response) {
                //遍历得到的数据
                $.each(response.data, function (index, item) {
                    //如果键与被点击项的campus值相同，则将值送给setSchoolMap和setAdress方法
                    if (index === $(self).data('campus')) {
                        setSchoolMap(item);
                        setAddress(item);
                        flag = true;
                    }
                });
                if (!flag) {
                    toastr.warning($(self).data('campus') + "地图数据有误，请联系管理员。");
                }
            }, function () {
                toastr.error('暂无数据');
            })
        });

    })
}]);