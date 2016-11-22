package com.phone1000.admin.travel.bean;

import java.util.List;

/**
 * Created by admin on 2016/11/19.
 */

public class ItemDataInfo {

    /**
     * timestamp : 1479638417383
     * code : 0
     * result : [{"id":"de903d1dbd1e9b79e7418950","commodityId":103289,"title":"轻走旅行丨日本东京市内包车自由行一日游","marketPrice":1850,"price":1800,"salesVolume":0,"rating":0,"commodityType":null,"seller":{"sellerId":220164,"name":"轻走旅行","rating":0,"user":{"userId":220164,"nickname":"","avatar":{"url":"http://7sbm17.com1.z0.glb.clouddn.com/avatar/38e421dc29d674510d6aa7be56aec94c"}},"lang":[],"qualifications":[],"services":[],"serviceZones":[],"cover":{}},"locality":{"id":"546f2da8b8ce0440eddb28e0","zhName":"东京","enName":"Tokyo"},"cover":{"url":"http://7sbm17.com1.z0.glb.clouddn.com/commodity/images/950115a6ded2330b66952b892f4a0ba6"},"expire":true,"status":"pub","createTime":0,"updateTime":0},{"id":"ddfa1d37603c35f032fc3151","commodityId":103259,"title":"香港/泰国/东京/首尔/巴厘岛自由行暑期优惠价","marketPrice":2999,"price":1999,"salesVolume":0,"rating":0,"commodityType":null,"seller":{"sellerId":100031,"name":"旅行派自营","rating":0,"user":{"userId":100031,"nickname":"","avatar":{"url":"http://7sbm17.com1.z0.glb.clouddn.com/avatar/da64cab162c9e1f5978ad45fed3fa697"}},"lang":[],"qualifications":[],"services":[],"serviceZones":[],"cover":{}},"locality":{"id":"546f2da8b8ce0440eddb28e0","zhName":"东京","enName":"Tokyo"},"cover":{"url":"http://7sbm17.com1.z0.glb.clouddn.com/commodity/images/4e31972f4d2b882054de6e5d71dc6da4"},"expire":true,"status":"pub","createTime":0,"updateTime":0},{"id":"0e554469f426bc9dea975b18","commodityId":103093,"title":"日本自由行包车/成田机场/羽田机场接机/东京包车一日游","marketPrice":900,"price":600,"salesVolume":26,"rating":0,"commodityType":null,"seller":{"sellerId":219480,"name":"日本旅行车务行","rating":0,"user":{"userId":219480,"nickname":"","avatar":null},"lang":[],"qualifications":[],"services":[],"serviceZones":[],"cover":{}},"locality":{"id":"546f2da8b8ce0440eddb28e0","zhName":"东京","enName":"Tokyo"},"cover":{"url":"http://7sbm17.com1.z0.glb.clouddn.com/commodity/images/635203f0c9abceca223e9cbd55e9c489"},"expire":true,"status":"pub","createTime":0,"updateTime":0}]
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
         * id : de903d1dbd1e9b79e7418950
         * commodityId : 103289
         * title : 轻走旅行丨日本东京市内包车自由行一日游
         * marketPrice : 1850
         * price : 1800
         * salesVolume : 0
         * rating : 0
         * commodityType : null
         * seller : {"sellerId":220164,"name":"轻走旅行","rating":0,"user":{"userId":220164,"nickname":"","avatar":{"url":"http://7sbm17.com1.z0.glb.clouddn.com/avatar/38e421dc29d674510d6aa7be56aec94c"}},"lang":[],"qualifications":[],"services":[],"serviceZones":[],"cover":{}}
         * locality : {"id":"546f2da8b8ce0440eddb28e0","zhName":"东京","enName":"Tokyo"}
         * cover : {"url":"http://7sbm17.com1.z0.glb.clouddn.com/commodity/images/950115a6ded2330b66952b892f4a0ba6"}
         * expire : true
         * status : pub
         * createTime : 0
         * updateTime : 0
         */

        private String id;
        private int commodityId;
        private String title;
        private float marketPrice;
        private float price;
        private int salesVolume;
        private float rating;
        private Object commodityType;
        private SellerBean seller;
        private LocalityBean locality;
        private CoverBeanX cover;
        private boolean expire;
        private String status;
        private int createTime;
        private int updateTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public float getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(float marketPrice) {
            this.marketPrice = marketPrice;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public int getSalesVolume() {
            return salesVolume;
        }

        public void setSalesVolume(int salesVolume) {
            this.salesVolume = salesVolume;
        }

        public float getRating() {
            return rating;
        }

        public void setRating(float rating) {
            this.rating = rating;
        }

        public Object getCommodityType() {
            return commodityType;
        }

        public void setCommodityType(Object commodityType) {
            this.commodityType = commodityType;
        }

        public SellerBean getSeller() {
            return seller;
        }

        public void setSeller(SellerBean seller) {
            this.seller = seller;
        }

        public LocalityBean getLocality() {
            return locality;
        }

        public void setLocality(LocalityBean locality) {
            this.locality = locality;
        }

        public CoverBeanX getCover() {
            return cover;
        }

        public void setCover(CoverBeanX cover) {
            this.cover = cover;
        }

        public boolean isExpire() {
            return expire;
        }

        public void setExpire(boolean expire) {
            this.expire = expire;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public int getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(int updateTime) {
            this.updateTime = updateTime;
        }

        public static class SellerBean {
            /**
             * sellerId : 220164
             * name : 轻走旅行
             * rating : 0
             * user : {"userId":220164,"nickname":"","avatar":{"url":"http://7sbm17.com1.z0.glb.clouddn.com/avatar/38e421dc29d674510d6aa7be56aec94c"}}
             * lang : []
             * qualifications : []
             * services : []
             * serviceZones : []
             * cover : {}
             */

            private int sellerId;
            private String name;
            private int rating;
            private UserBean user;
            private CoverBean cover;
            private List<?> lang;
            private List<?> qualifications;
            private List<?> services;
            private List<?> serviceZones;

            public int getSellerId() {
                return sellerId;
            }

            public void setSellerId(int sellerId) {
                this.sellerId = sellerId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getRating() {
                return rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public CoverBean getCover() {
                return cover;
            }

            public void setCover(CoverBean cover) {
                this.cover = cover;
            }

            public List<?> getLang() {
                return lang;
            }

            public void setLang(List<?> lang) {
                this.lang = lang;
            }

            public List<?> getQualifications() {
                return qualifications;
            }

            public void setQualifications(List<?> qualifications) {
                this.qualifications = qualifications;
            }

            public List<?> getServices() {
                return services;
            }

            public void setServices(List<?> services) {
                this.services = services;
            }

            public List<?> getServiceZones() {
                return serviceZones;
            }

            public void setServiceZones(List<?> serviceZones) {
                this.serviceZones = serviceZones;
            }

            public static class UserBean {
                public static class AvatarBean {
                }
            }

            public static class CoverBean {
            }
        }

        public static class LocalityBean {
            /**
             * id : 546f2da8b8ce0440eddb28e0
             * zhName : 东京
             * enName : Tokyo
             */

            private String id;
            private String zhName;
            private String enName;

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
        }

        public static class CoverBeanX {
            /**
             * url : http://7sbm17.com1.z0.glb.clouddn.com/commodity/images/950115a6ded2330b66952b892f4a0ba6
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
