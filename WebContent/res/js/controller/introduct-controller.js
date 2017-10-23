app.controller('introductCtrl', ['$scope', '$http', function ($scope, $http) {


    $(function () {
        var map = new AMap.Map('schoolMap', {

            //可缩放
            resizeEnable: true,

            //放大级别
            zoom: 16,

            //中心点
            center: [116.382408, 39.988895]
        });

        //点标注
        var marker = new AMap.Marker({

            //标注位置：地图中心点
            position: map.getCenter(),

            //不可拖拽
            draggable: false,

            // 设置点标记的动画效果，此处为掉落效果
            animation: "AMAP_ANIMATION_DROP",
            content: "<i class='fa fa-3x fa-map-marker' aria-hidden='true' style='color: red;'></i>"
        });
        marker.setMap(map);

        //label默认蓝框白底左上角显示，样式className为：amap-marker-label
        marker.setLabel({

            //修改label相对于maker的位置
            offset: new AMap.Pixel(30, 10),

            //label文本内容
            content: "健翔桥校区"
        });

        /**
         * 给地图添加工具栏
         */
        map.plugin(["AMap.ToolBar"], function() {
            map.addControl(new AMap.ToolBar());
        });
        if(location.href.indexOf('&guide=1')!==-1){
            map.setStatus({scrollWheel:false})
        }
    })
}]);