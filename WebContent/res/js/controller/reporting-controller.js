app.controller('reportingCtrl', ['$http', '$scope', 'reportingService', function ($http, $scope, reportingService) {
    $scope.from = 'west';
    $scope.to = '小营';
    $scope.campusTele = '小营';
    $scope.setMapStart = function (from) {
        $scope.from = from;
    };
    $scope.setMapEnd = function (to) {
        $scope.to = to;
    };
    $scope.currentPage = reportingService.getCurrentPage();
    $scope.setProcessImg = function (img) {
        $('.reporting-process-img').children('img').attr('src', 'res/img/reporting/' + img + '.png');
    };
    $scope.setTele = function (campus) {
        $scope.campusTele = campus;
    };
    $(function () {


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
            $("#reporting-submenu-list li[data-show-page=" + id + "]").addClass('active');

            //设置默认显示页面
            showPage(id);
        }

        setDefaultPage($scope.currentPage);

        $('#reporting-submenu').jqueryAccordionMenu();
        $('#reporting-submenu-list li').click(function () {
            //添加判断方法，当前点击项是当前显示项时，跳过该方法

            if ($("#reporting-submenu-list li.active").data('show-page') !== $(this).data('show-page')) {
                hidePage($("#reporting-submenu-list li.active").data('show-page'));
                $("#reporting-submenu-list li.active").removeClass("active");
                $(this).addClass("active");
                showPage($(this).data('show-page'));
            }
        });

        function setRouteMap(from, to) {
            switch (from) {
                case 'west':
                    from = '北京西站';
                    break;
                case 'south':
                    from = '北京南站';
                    break;
                case 'north':
                    from = '北京北站';
                    break;
                case 'beijing':
                    from = '北京站';
                    break;
                case 'nanyuanAirport':
                    from = '北京南苑机场';
                    break;
                case 'internationalAirport':
                    from = '北京首都国际机场';
                    break;
                default:
                    from = '北京西站';
                    break;
            }
            switch (to) {
                case '小营':
                    to = '北京信息科技大学小营校区';
                    break;
                case '健翔桥':
                    to = '北京信息科技大学健翔桥校区';
                    break;
                case '清河':
                    to = '北京信息科技大学清河校区';
                    break;
                default:
                    to = '北京信息科技大学小营校区';
                    break;
            }

            var map = new AMap.Map("reporting-route-map", {
                resizeEnable: true,
                center: [116.40, 39.91],
                zoom: 13
            });
            var transOptions = {
                map: map,
                city: '北京市',
                panel: 'reporting-route-panel',
                policy: AMap.TransferPolicy.LEAST_TIME //乘车策略
            };
            //构造公交换乘类
            var transfer = new AMap.Transfer(transOptions);
            //根据起、终点名称查询公交换乘路线
            transfer.search([
                {keyword: from, city: '北京'},
                //第一个元素city缺省时取transOptions的city属性
                {keyword: to, city: '北京'}
                //第二个元素city缺省时取transOptions的cityd属性,
                //没有cityd属性时取city属性
            ], function (status, result) {
                var content = '';
                for (var i = 0; i < result.plans.length; i++) {
                    content += result.originName + ' → ';
                    for (var j = 0; j < result.plans[i].segments.length; j++) {
                        content += result.plans[i].segments[j].instruction + ' → ';
                    }
                    content += result.end.name + '<br><br>';
                }
                $('.reporting-route-note').html(content);
            });
            map.plugin(["AMap.ToolBar"], function () {
                map.addControl(new AMap.ToolBar());
            });
            if (location.href.indexOf('&guide=1') !== -1) {
                map.setStatus({scrollWheel: false})
            }
        }

        setRouteMap($scope.from, $scope.to);
        $('#reporting-route-search').find('ul.submenu').children('li').on('click', function () {
            $('#reporting-route-panel').empty();
            setRouteMap($scope.from, $scope.to);
        });

        $('.campus-select-button').on('click', function () {
            $(this).siblings('.campus-select-button').removeClass('current btn-info').addClass('btn-default');
            $(this).removeClass('btn-default').addClass('current btn-info');
            $('#reporting-route-panel').empty();
            setRouteMap($scope.from, $scope.to);
        });

        $('#reporting-route-panel').hover(function () {
            $(this).css('zIndex', 21);
        }, function () {
            $(this).css('zIndex', 0);
        })
    });
}]);