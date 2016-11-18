package com.phone1000.admin.travel.bean;

import java.util.List;

/**
 * Created by admin on 2016/11/19.
 */

public class SevenDataInfo {

    /**
     * lastModified : 1479490073
     * result : [{"id":"5434d71310114e684bb1b515","images":[{"url":"http://images.taozilvxing.com/countries/mx/covers/cfd829977bfdcf584c242af4fe7415645cd2b316?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/countries/mx/covers/cfd829977bfdcf584c242af4fe7415645cd2b316?imageView2/2/w/200","full":"http://images.taozilvxing.com/countries/mx/covers/cfd829977bfdcf584c242af4fe7415645cd2b316?imageView2/2/w/1200","caption":""}],"zhName":"墨西哥","enName":"Mexico","code":"MX","rank":100,"commoditiesCnt":0},{"id":"5434d71210114e684bb1b512","images":[{"url":"http://images.taozilvxing.com/countries/ca/covers/b7fac7eda2c5ec8a64d4af41e4c371972292debd?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/countries/ca/covers/b7fac7eda2c5ec8a64d4af41e4c371972292debd?imageView2/2/w/200","full":"http://images.taozilvxing.com/countries/ca/covers/b7fac7eda2c5ec8a64d4af41e4c371972292debd?imageView2/2/w/1200","caption":""}],"zhName":"加拿大","enName":"Canada","code":"CA","rank":100,"commoditiesCnt":0},{"id":"5434d71310114e684bb1b513","images":[{"url":"http://images.taozilvxing.com/30bfe95b940225751d539158dbf1a63d?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/30bfe95b940225751d539158dbf1a63d?imageView2/2/w/200","full":"http://images.taozilvxing.com/30bfe95b940225751d539158dbf1a63d?imageView2/2/w/1200","caption":""}],"zhName":"美国","enName":"USA","code":"US","rank":12,"commoditiesCnt":10}]
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
         * id : 5434d71310114e684bb1b515
         * images : [{"url":"http://images.taozilvxing.com/countries/mx/covers/cfd829977bfdcf584c242af4fe7415645cd2b316?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/countries/mx/covers/cfd829977bfdcf584c242af4fe7415645cd2b316?imageView2/2/w/200","full":"http://images.taozilvxing.com/countries/mx/covers/cfd829977bfdcf584c242af4fe7415645cd2b316?imageView2/2/w/1200","caption":""}]
         * zhName : 墨西哥
         * enName : Mexico
         * code : MX
         * rank : 100
         * commoditiesCnt : 0
         */

        private String id;
        private String zhName;
        private String enName;
        private String code;
        private int rank;
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

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
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
             * url : http://images.taozilvxing.com/countries/mx/covers/cfd829977bfdcf584c242af4fe7415645cd2b316?imageView2/2/w/640
             * thumb : http://images.taozilvxing.com/countries/mx/covers/cfd829977bfdcf584c242af4fe7415645cd2b316?imageView2/2/w/200
             * full : http://images.taozilvxing.com/countries/mx/covers/cfd829977bfdcf584c242af4fe7415645cd2b316?imageView2/2/w/1200
             * caption :
             */

            private String url;
            private String thumb;
            private String full;
            private String caption;

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
        }
    }
}
