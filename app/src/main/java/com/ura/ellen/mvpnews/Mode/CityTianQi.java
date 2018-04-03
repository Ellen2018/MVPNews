package com.ura.ellen.mvpnews.Mode;

import java.util.List;

public class CityTianQi {

    /**
     * date : 20180329
     * message : Success !
     * status : 200
     * city : 武汉
     * count : 1143
     * data : {"shidu":"85%","pm25":60,"pm10":166,"quality":"轻度污染","wendu":"16","ganmao":"
     * 儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼","yesterday":{"date":"28日星期三",
     * "sunrise":"06:19","high":"高温 27.0℃","low":"低温 15.0℃","sunset":"18:39","aqi":62,"fx":"东南风",
     * "fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},"forecast":[{"date":"29日星期四","sunrise":"06:18",
     * "high":"高温 25.0℃","low":"低温 13.0℃","sunset":"18:39","aqi":92,"fx":"东北风","fl":"<3级","type":"多云",
     * "notice":"阴晴之间，谨防紫外线侵扰"},{"date":"30日星期五","sunrise":"06:17","high":"高温 25.0℃","low":"低温 14.0℃","
     * sunset":"18:40","aqi":77,"fx":"东风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"31日星期六",
     * "sunrise":"06:15","high":"高温 26.0℃","low":"低温 15.0℃","sunset":"18:41","aqi":95,"fx":"西南风","fl":"<3级",
     * "type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"01日星期日","sunrise":"06:14","high":"高温 27.0℃",
     * "low":"低温 15.0℃","sunset":"18:41","aqi":96,"fx":"西风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},
     * {"date":"02日星期一","sunrise":"06:13","high":"高温 28.0℃","low":"低温 16.0℃","sunset":"18:42","aqi":75,"fx":
     * "西北风","fl":"5-6级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}]}
     */

    private String date;
    private String message;
    private int status;
    private String city;
    private int count;
    private DataBean data;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * shidu : 85%
         * pm25 : 60.0
         * pm10 : 166.0
         * quality : 轻度污染
         * wendu : 16
         * ganmao : 儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼
         * yesterday : {"date":"28日星期三","sunrise":"06:19","high":"高温 27.0℃","low":"低温 15.0℃","sunset":"18:39","aqi":62,"fx":"东南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}
         * forecast : [{"date":"29日星期四","sunrise":"06:18","high":"高温 25.0℃","low":"低温 13.0℃","sunset":"18:39","aqi":92,"fx":"东北风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"30日星期五","sunrise":"06:17","high":"高温 25.0℃","low":"低温 14.0℃","sunset":"18:40","aqi":77,"fx":"东风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"31日星期六","sunrise":"06:15","high":"高温 26.0℃","low":"低温 15.0℃","sunset":"18:41","aqi":95,"fx":"西南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"01日星期日","sunrise":"06:14","high":"高温 27.0℃","low":"低温 15.0℃","sunset":"18:41","aqi":96,"fx":"西风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"02日星期一","sunrise":"06:13","high":"高温 28.0℃","low":"低温 16.0℃","sunset":"18:42","aqi":75,"fx":"西北风","fl":"5-6级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}]
         */

        private String shidu;
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 28日星期三
             * sunrise : 06:19
             * high : 高温 27.0℃
             * low : 低温 15.0℃
             * sunset : 18:39
             * aqi : 62.0
             * fx : 东南风
             * fl : <3级
             * type : 多云
             * notice : 阴晴之间，谨防紫外线侵扰
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            /**
             * date : 29日星期四
             * sunrise : 06:18
             * high : 高温 25.0℃
             * low : 低温 13.0℃
             * sunset : 18:39
             * aqi : 92.0
             * fx : 东北风
             * fl : <3级
             * type : 多云
             * notice : 阴晴之间，谨防紫外线侵扰
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
