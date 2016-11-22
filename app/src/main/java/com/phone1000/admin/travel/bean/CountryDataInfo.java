package com.phone1000.admin.travel.bean;

import java.util.List;

/**
 * Created by admin on 2016/11/22.
 */

public class CountryDataInfo {


    /**
     * lastModified : 1479814024
     * result : [{"id":"5492bd27e721e717174511ba","zhName":"菲律宾","enName":"Philippines","commoditiesCnt":2,"images":[{"url":"http://images.taozilvxing.com/aa31ebd7048b9d2cc331fb22ec39dc8b?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/aa31ebd7048b9d2cc331fb22ec39dc8b?imageView2/2/w/200","full":"http://images.taozilvxing.com/aa31ebd7048b9d2cc331fb22ec39dc8b?imageView2/2/w/1200","caption":"","width":640,"height":215}]},{"id":"547aec00b8ce043deccfedbf","zhName":"马尼拉","enName":"","commoditiesCnt":0,"images":[{"url":"http://images.taozilvxing.com/9a3f451bbe4a9ad4ca478ad3be23e6a7?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/9a3f451bbe4a9ad4ca478ad3be23e6a7?imageView2/2/w/200","full":"http://images.taozilvxing.com/9a3f451bbe4a9ad4ca478ad3be23e6a7?imageView2/2/w/1200","caption":"","width":640,"height":426}]}]
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
         * id : 5492bd27e721e717174511ba
         * zhName : 菲律宾
         * enName : Philippines
         * commoditiesCnt : 2
         * images : [{"url":"http://images.taozilvxing.com/aa31ebd7048b9d2cc331fb22ec39dc8b?imageView2/2/w/640","thumb":"http://images.taozilvxing.com/aa31ebd7048b9d2cc331fb22ec39dc8b?imageView2/2/w/200","full":"http://images.taozilvxing.com/aa31ebd7048b9d2cc331fb22ec39dc8b?imageView2/2/w/1200","caption":"","width":640,"height":215}]
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
             * url : http://images.taozilvxing.com/aa31ebd7048b9d2cc331fb22ec39dc8b?imageView2/2/w/640
             * thumb : http://images.taozilvxing.com/aa31ebd7048b9d2cc331fb22ec39dc8b?imageView2/2/w/200
             * full : http://images.taozilvxing.com/aa31ebd7048b9d2cc331fb22ec39dc8b?imageView2/2/w/1200
             * caption :
             * width : 640
             * height : 215
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
