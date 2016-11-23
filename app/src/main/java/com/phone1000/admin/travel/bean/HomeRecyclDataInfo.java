package com.phone1000.admin.travel.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */

public class HomeRecyclDataInfo {

    /**
     * timestamp : 1479536422372
     * code : 0
     * result : [{"columnType":"slide","columns":[{"title":"清迈国际义工旅行","images":[{"url":"http://images.taozilvxing.com/taiguo.png"}],"link":"lvxingpai://marketplace/commodities/103286?userId=221596"},{"title":"斯里兰卡义工","images":[{"url":"http://images.taozilvxing.com/sllka.png"}],"link":"lvxingpai://marketplace/commodities/103254?userId=221596"},{"title":"免费出国游活动","images":[{"url":"http://images.taozilvxing.com/cglbanner.jpg"}],"link":"http://h5.lvxingpai.com/market/cglx.html?userId=221596"},{"title":"毕业旅行","images":[{"url":"http://images.taozilvxing.com/column/3/xjhd.png"}],"link":"http://h5.lvxingpai.com/biye/graduation.html?userId=221596"}]},{"columnType":"special","columns":[{"title":"女生专区","images":[{"url":"http://images.taozilvxing.com/column2016_1.jpg"}],"link":"http://h5.taozilvxing.com/market/girlzq.html?title=女生专区&userId=221596"},{"title":"男士专区","images":[{"url":"http://images.taozilvxing.com/column2016_2.jpg"}],"link":"http://h5.taozilvxing.com/market/nszq.html?title=男士专区&userId=221596"},{"title":"情侣专区","images":[{"url":"http://images.taozilvxing.com/column2016_3.jpg"}],"link":"http://h5.taozilvxing.com/market/qlzq.html?title=情侣专区&userId=221596"},{"title":"住宿专区","images":[{"url":"http://images.taozilvxing.com/column2016_4.jpg"}],"link":"http://h5.taozilvxing.com/market/zszq.html?title=住宿专区&userId=221596"},{"title":"亲子专区","images":[{"url":"http://images.taozilvxing.com/column2016_5.jpg"}],"link":"http://h5.taozilvxing.com/market/qzzq.html?title=亲子专区&userId=221596"},{"title":"滑雪专区","images":[{"url":"http://images.taozilvxing.com/column2016_6.jpg"}],"link":"http://h5.taozilvxing.com/market/hxzq.html?title=滑雪专区&userId=221596"},{"title":"潜水专区","images":[{"url":"http://images.taozilvxing.com/column2016_7.jpg"}],"link":"http://h5.taozilvxing.com/market/qszq.html?title=潜水专区&userId=221596"}]}]
     */

    private long timestamp;
    private int code;
    private List<ResultBean> result;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * columnType : slide
         * columns : [{"title":"清迈国际义工旅行","images":[{"url":"http://images.taozilvxing.com/taiguo.png"}],"link":"lvxingpai://marketplace/commodities/103286?userId=221596"},{"title":"斯里兰卡义工","images":[{"url":"http://images.taozilvxing.com/sllka.png"}],"link":"lvxingpai://marketplace/commodities/103254?userId=221596"},{"title":"免费出国游活动","images":[{"url":"http://images.taozilvxing.com/cglbanner.jpg"}],"link":"http://h5.lvxingpai.com/market/cglx.html?userId=221596"},{"title":"毕业旅行","images":[{"url":"http://images.taozilvxing.com/column/3/xjhd.png"}],"link":"http://h5.lvxingpai.com/biye/graduation.html?userId=221596"}]
         */

        private String columnType;
        private List<ColumnsBean> columns;

        public String getColumnType() {
            return columnType;
        }

        public void setColumnType(String columnType) {
            this.columnType = columnType;
        }

        public List<ColumnsBean> getColumns() {
            return columns;
        }

        public void setColumns(List<ColumnsBean> columns) {
            this.columns = columns;
        }

        public static class ColumnsBean {
            /**
             * title : 清迈国际义工旅行
             * images : [{"url":"http://images.taozilvxing.com/taiguo.png"}]
             * link : lvxingpai://marketplace/commodities/103286?userId=221596
             */

            private String title;
            private String link;
            private List<ImagesBean> images;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public static class ImagesBean {
                /**
                 * url : http://images.taozilvxing.com/taiguo.png
                 */

                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
