app.controller('manualCtrl', ['$http', '$scope', function ($http, $scope) {
    //获取当前时间
    var currentTime = new Date();

    //得到现在年份，默认显示今年的学生手册
    $scope.currentYear = currentTime.getFullYear();

    //预存后台获取的学生手册信息
    $scope.manuals = [];

    /**
     * 设置当前显示的学生手册文件名
     * @param {String} item 学生手册文件名（带后缀）
     * */
    $scope.setManualName = function (item) {
        $scope.manualName = item;
    };

    /**
     * 设置当前显示的学生手册路径
     * @param {String} item 学生手册文件名（带后缀）
     * */
    $scope.setManualPath = function (item) {
        //对预存手册信息数组进行遍历，找到与文件名相同的对象，取出对应路径，存放在manualPath中
        for (var i = 0; i < $scope.manuals.length; i++) {
            if ($scope.manuals[i].manualName === item) {
                $scope.manualPath = $scope.manuals[i].manualPath;
                $scope.name = $scope.manuals[i].name;
            }
        }
    };

    /**
     * 设置当前显示的学生手册
     * @param {String} item 学生手册文件名（带后缀）
     * */
    $scope.setManual = function (item) {
        $scope.setManualName(item);
        $scope.setManualPath(item);
        //学生手册路径和文件名整合后，将文件嵌入id为pdf的标签内
        PDFObject.embed($scope.manualPath + $scope.manualName, '#pdf');
    };

    /**
     * 下载学生手册
     * TODO 未实现，需要后台接口
     * @param {String} item 学生手册文件名（带后缀）
     * @returns {Window}
     */
    $scope.mannualDownload = function (item) {
        /*console.log('download');
        return $window.open($scope.manualPath + item);*/
    };

    /**
     * 通过angualrJS内置http方法，实现异步请求学生手册信息，并对信息进行简单处理
     * TODO 后台接口未开发，暂时手写json文件来模拟后台传参
     */
    $http.get('res/data/manualData.json').then(function (response) {
        console.log(response.data);

        //获取数据正常
        //TODO 暂时指定获取正常状态码为200，待协商
        if (response.data.status === 200) {

            //将学生手册数据在缓存持久化
            $scope.manuals = response.data.data;

            //对成功获取数据进行遍历
            $.each(response.data.data, function (index, item) {

                //找到今年的学生手册，将默认的学生手册文件名以及路径存放在缓存里
                if (item.year === $scope.currentYear) {
                    $scope.manualPath = item.manualPath;
                    $scope.manualName = item.manualName;
                }
            })
        }
        console.log($scope.manuals);

        //根据缓存中的手册名设置默认显示的学生手册
        $scope.setManual($scope.manualName);
    });

    /**
     * jquery操作
     */
    $(function () {

        /**
         * 对学生手册下拉菜单的click事件处理
         */
        $('.select').on('click', '.placeholder', function (e) {

            //找到placeholder的.select父节点
            var parent = $(this).closest('.select');

            //如果父节点没有is-open类
            if (!parent.hasClass('is-open')) {

                //给父节点添加is-open类
                parent.addClass('is-open');

                //如果添加了is-open的.select节点不是父节点，则移除is-open类
                $('.select.is-open').not(parent).removeClass('is-open');
            } else {

                //父节点有is-open类则移除
                parent.removeClass('is-open');
            }

            //阻止该事件继续分派到别的结点
            e.stopPropagation();

            /**
             * 对下拉菜单选项的click事件处理
             */
        }).on('click', 'ul>li', function () {

            //找到ul>li的.select父节点
            var parent = $(this).closest('.select');

            //父节点移除is-open类并且将自己结点里的文本写到父节点下的.placeholder结点中
            parent.removeClass('is-open').find('.placeholder').text($(this).text());
        });

        /**
         * 对body的click事件处理
         */
        $('body').on('click', function () {

            //移除带有is-open类的.select节点的is-open类
            $('.select.is-open').removeClass('is-open');
        });
    });
}]);

