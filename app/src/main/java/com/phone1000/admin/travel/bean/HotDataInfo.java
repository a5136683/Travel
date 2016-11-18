package com.phone1000.admin.travel.bean;

import java.util.List;

/**
 * Created by admin on 2016/11/18.
 */

public class HotDataInfo {

    /**
     * lastModified : 1479472916
     * result : [{"id":"546f2da8b8ce0440eddb28e0","zhName":"东京","enName":"Tokyo","images":[{"url":"http://images.taozilvxing.com/d42dfcd90bcbbb1ebb0598031eda45fc?imageMogr2/auto-orient/strip/gravity/NorthWest/crop/!1982x1238a54a80/thumbnail/640","thumb":"http://images.taozilvxing.com/d42dfcd90bcbbb1ebb0598031eda45fc?imageMogr2/auto-orient/strip/gravity/NorthWest/crop/!1982x1238a54a80/thumbnail/200","full":"http://images.taozilvxing.com/d42dfcd90bcbbb1ebb0598031eda45fc?imageMogr2/auto-orient/strip/gravity/NorthWest/crop/!1982x1238a54a80/thumbnail/1200","caption":"","width":1982,"height":1238}],"commoditiesCnt":62},{"id":"546f2da8b8ce0440eddb2897","zhName":"首尔","enName":"Seoul","images":[{"url":"http://images.taozilvxing.com/20160119se1.jpg?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/20160119se1.jpg?imageView2/2/w/200","full":"http://images.taozilvxing.com/20160119se1.jpg?imageView2/2/w/1200","caption":""}],"commoditiesCnt":45},{"id":"5492bd35e721e71717451679","zhName":"新加坡","enName":"Singapore","images":[{"url":"http://images.taozilvxing.com/20160119xjp1.jpg?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/20160119xjp1.jpg?imageView2/2/w/200","full":"http://images.taozilvxing.com/20160119xjp1.jpg?imageView2/2/w/1200","caption":""}],"commoditiesCnt":43},{"id":"546f2da8b8ce0440eddb28c7","zhName":"曼谷","enName":"Bangkok","images":[{"url":"http://images.taozilvxing.com/20160119mg1.png?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/20160119mg1.png?imageView2/2/w/200","full":"http://images.taozilvxing.com/20160119mg1.png?imageView2/2/w/1200","caption":""}],"commoditiesCnt":12},{"id":"546f2daab8ce0440eddb2acc","zhName":"巴厘岛","enName":"Bali Island","images":[{"url":"http://images.taozilvxing.com/20160119bld1.jpg?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/20160119bld1.jpg?imageView2/2/w/200","full":"http://images.taozilvxing.com/20160119bld1.jpg?imageView2/2/w/1200","caption":""}],"commoditiesCnt":27},{"id":"547aec00b8ce043deccfedce","zhName":"芽庄","enName":" Nha Trang","images":[{"url":"http://images.taozilvxing.com/599509c05f0fca1bbd0080896bb7bcf8?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/599509c05f0fca1bbd0080896bb7bcf8?imageView2/2/w/200","full":"http://images.taozilvxing.com/599509c05f0fca1bbd0080896bb7bcf8?imageView2/2/w/1200","caption":""}],"commoditiesCnt":14},{"id":"546f2da8b8ce0440eddb287e","zhName":"清迈","enName":"Chiengmai","images":[{"url":"http://images.taozilvxing.com/20160119qm1.jpg?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/20160119qm1.jpg?imageView2/2/w/200","full":"http://images.taozilvxing.com/20160119qm1.jpg?imageView2/2/w/1200","caption":""}],"commoditiesCnt":32},{"id":"5492bd2fe721e71717451473","zhName":"马尔代夫","enName":"Maldives","images":[{"url":"http://images.taozilvxing.com/20160119medf1.jpg?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/20160119medf1.jpg?imageView2/2/w/200","full":"http://images.taozilvxing.com/20160119medf1.jpg?imageView2/2/w/1200","caption":""}],"commoditiesCnt":15},{"id":"5473ccd8b8ce043a64108c5a","zhName":"台湾","enName":"","images":[{"url":"http://images.taozilvxing.com/20160121154139.jpg?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/20160121154139.jpg?imageView2/2/w/200","full":"http://images.taozilvxing.com/20160121154139.jpg?imageView2/2/w/1200","caption":""}],"commoditiesCnt":18}]
     * code : 0
     */

    private int lastModified;
    private int code;
    private List<ResultBean> result;

    public int getLastModified() {
        return lastModified;
    }

    public void setLastModified(int lastModified) {
        this.lastModified = lastModified;
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
         * id : 546f2da8b8ce0440eddb28e0
         * zhName : 东京
         * enName : Tokyo
         * images : [{"url":"http://images.taozilvxing.com/d42dfcd90bcbbb1ebb0598031eda45fc?imageMogr2/auto-orient/strip/gravity/NorthWest/crop/!1982x1238a54a80/thumbnail/640","thumb":"http://images.taozilvxing.com/d42dfcd90bcbbb1ebb0598031eda45fc?imageMogr2/auto-orient/strip/gravity/NorthWest/crop/!1982x1238a54a80/thumbnail/200","full":"http://images.taozilvxing.com/d42dfcd90bcbbb1ebb0598031eda45fc?imageMogr2/auto-orient/strip/gravity/NorthWest/crop/!1982x1238a54a80/thumbnail/1200","caption":"","width":1982,"height":1238}]
         * commoditiesCnt : 62
         */

        private String id;
        private String zhName;
        private String enName;
        private int commoditiesCnt;
        private List<ImagesBean> images;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getZhName() {
            return zhName;
        }

        public void setZhName(String zhName) {
            this.zhName = zhName;
        }

        public String getEnName() {
            return enName;
        }

        public void setEnName(String enName) {
            this.enName = enName;
        }

        public int getCommoditiesCnt() {
            return commoditiesCnt;
        }

        public void setCommoditiesCnt(int commoditiesCnt) {
            this.commoditiesCnt = commoditiesCnt;
        }

        public List<ImagesBean> getImages() {
            return images;
        }

        public void setImages(List<ImagesBean> images) {
            this.images = images;
        }

        public static class ImagesBean {
            /**
             * url : http://images.taozilvxing.com/d42dfcd90bcbbb1ebb0598031eda45fc?imageMogr2/auto-orient/strip/gravity/NorthWest/crop/!1982x1238a54a80/thumbnail/640
             * thumb : http://images.taozilvxing.com/d42dfcd90bcbbb1ebb0598031eda45fc?imageMogr2/auto-orient/strip/gravity/NorthWest/crop/!1982x1238a54a80/thumbnail/200
             * full : http://images.taozilvxing.com/d42dfcd90bcbbb1ebb0598031eda45fc?imageMogr2/auto-orient/strip/gravity/NorthWest/crop/!1982x1238a54a80/thumbnail/1200
             * caption :
             * width : 1982
             * height : 1238
             */

            private String url;
            private String thumb;
            private String full;
            private String caption;
            private int width;
            private int height;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getFull() {
                return full;
            }

            public void setFull(String full) {
                this.full = full;
            }

            public String getCaption() {
                return caption;
            }

            public void setCaption(String caption) {
                this.caption = caption;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }
}
