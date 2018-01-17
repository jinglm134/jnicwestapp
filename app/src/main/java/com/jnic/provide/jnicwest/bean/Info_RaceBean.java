package com.jnic.provide.jnicwest.bean;

import java.util.List;

/**
 * Created by ${jaylm}
 * on 2018/1/16.
 */

public class Info_RaceBean {

    /**
     * code : 200
     * race : [{"day":1518537600000,"dayStr":"2018-02-14","datas":[{"homeName":"尤文图斯","guestName":"热刺","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":166,"guestId":33,"homePic":"http://pic.13322.com/icons/teams/100/166.png","guestPic":"http://pic.13322.com/icons/teams/100/33.png"},{"homeName":"巴塞尔","guestName":"曼城","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":451,"guestId":26,"homePic":"http://pic.13322.com/icons/teams/100/451.png","guestPic":"http://pic.13322.com/icons/teams/100/26.png"}]},{"day":1518624000000,"dayStr":"2018-02-15","datas":[{"homeName":"波尔图","guestName":"利物浦","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":468,"guestId":25,"homePic":"http://pic.13322.com/icons/teams/100/468.png","guestPic":"http://pic.13322.com/icons/teams/100/25.png"},{"homeName":"皇家马德里","guestName":"巴黎圣日尔曼","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":82,"guestId":271,"homePic":"http://pic.13322.com/icons/teams/100/82.png","guestPic":"http://pic.13322.com/icons/teams/100/271.png"}]},{"day":1519142400000,"dayStr":"2018-02-21","datas":[{"homeName":"切尔西","guestName":"巴塞罗那","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":24,"guestId":84,"homePic":"http://pic.13322.com/icons/teams/100/24.png","guestPic":"http://pic.13322.com/icons/teams/100/84.png"},{"homeName":"拜仁慕尼黑","guestName":"贝西克塔斯","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":88,"guestId":529,"homePic":"http://pic.13322.com/icons/teams/100/88.png","guestPic":"http://pic.13322.com/icons/teams/100/529.png"}]},{"day":1519228800000,"dayStr":"2018-02-22","datas":[{"homeName":"顿涅茨克矿","guestName":"罗马","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":716,"guestId":174,"homePic":"http://pic.13322.com/icons/teams/100/716.png","guestPic":"http://pic.13322.com/icons/teams/100/174.png"},{"homeName":"塞维利亚","guestName":"曼联","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":86,"guestId":27,"homePic":"http://pic.13322.com/icons/teams/100/86.png","guestPic":"http://pic.13322.com/icons/teams/100/27.png"}]},{"day":1520352000000,"dayStr":"2018-03-07","datas":[{"homeName":"利物浦","guestName":"波尔图","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":25,"guestId":468,"homePic":"http://pic.13322.com/icons/teams/100/25.png","guestPic":"http://pic.13322.com/icons/teams/100/468.png"},{"homeName":"巴黎圣日尔曼","guestName":"皇家马德里","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":271,"guestId":82,"homePic":"http://pic.13322.com/icons/teams/100/271.png","guestPic":"http://pic.13322.com/icons/teams/100/82.png"}]},{"day":1520438400000,"dayStr":"2018-03-08","datas":[{"homeName":"热刺","guestName":"尤文图斯","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":33,"guestId":166,"homePic":"http://pic.13322.com/icons/teams/100/33.png","guestPic":"http://pic.13322.com/icons/teams/100/166.png"},{"homeName":"曼城","guestName":"巴塞尔","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":26,"guestId":451,"homePic":"http://pic.13322.com/icons/teams/100/26.png","guestPic":"http://pic.13322.com/icons/teams/100/451.png"}]},{"day":1520956800000,"dayStr":"2018-03-14","datas":[{"homeName":"罗马","guestName":"顿涅茨克矿","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":174,"guestId":716,"homePic":"http://pic.13322.com/icons/teams/100/174.png","guestPic":"http://pic.13322.com/icons/teams/100/716.png"},{"homeName":"曼联","guestName":"塞维利亚","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":27,"guestId":86,"homePic":"http://pic.13322.com/icons/teams/100/27.png","guestPic":"http://pic.13322.com/icons/teams/100/86.png"}]},{"day":1521043200000,"dayStr":"2018-03-15","datas":[{"homeName":"贝西克塔斯","guestName":"拜仁慕尼黑","matchResult":"01:00","matchId":-1,"matchState":0,"homeId":529,"guestId":88,"homePic":"http://pic.13322.com/icons/teams/100/529.png","guestPic":"http://pic.13322.com/icons/teams/100/88.png"},{"homeName":"巴塞罗那","guestName":"切尔西","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":84,"guestId":24,"homePic":"http://pic.13322.com/icons/teams/100/84.png","guestPic":"http://pic.13322.com/icons/teams/100/24.png"}]}]
     */

    private int code;
    private List<RaceBean> race;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<RaceBean> getRace() {
        return race;
    }

    public void setRace(List<RaceBean> race) {
        this.race = race;
    }

    public static class RaceBean {
        /**
         * day : 1518537600000
         * dayStr : 2018-02-14
         * datas : [{"homeName":"尤文图斯","guestName":"热刺","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":166,"guestId":33,"homePic":"http://pic.13322.com/icons/teams/100/166.png","guestPic":"http://pic.13322.com/icons/teams/100/33.png"},{"homeName":"巴塞尔","guestName":"曼城","matchResult":"03:45","matchId":-1,"matchState":0,"homeId":451,"guestId":26,"homePic":"http://pic.13322.com/icons/teams/100/451.png","guestPic":"http://pic.13322.com/icons/teams/100/26.png"}]
         */

        private long day;
        private String dayStr;
        private List<DatasBean> datas;

        public long getDay() {
            return day;
        }

        public void setDay(long day) {
            this.day = day;
        }

        public String getDayStr() {
            return dayStr;
        }

        public void setDayStr(String dayStr) {
            this.dayStr = dayStr;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * homeName : 尤文图斯
             * guestName : 热刺
             * matchResult : 03:45
             * matchId : -1
             * matchState : 0
             * homeId : 166
             * guestId : 33
             * homePic : http://pic.13322.com/icons/teams/100/166.png
             * guestPic : http://pic.13322.com/icons/teams/100/33.png
             */

            private String homeName;
            private String guestName;
            private String matchResult;
            private int matchId;
            private int matchState;
            private int homeId;
            private int guestId;
            private String homePic;
            private String guestPic;

            public String getHomeName() {
                return homeName;
            }

            public void setHomeName(String homeName) {
                this.homeName = homeName;
            }

            public String getGuestName() {
                return guestName;
            }

            public void setGuestName(String guestName) {
                this.guestName = guestName;
            }

            public String getMatchResult() {
                return matchResult;
            }

            public void setMatchResult(String matchResult) {
                this.matchResult = matchResult;
            }

            public int getMatchId() {
                return matchId;
            }

            public void setMatchId(int matchId) {
                this.matchId = matchId;
            }

            public int getMatchState() {
                return matchState;
            }

            public void setMatchState(int matchState) {
                this.matchState = matchState;
            }

            public int getHomeId() {
                return homeId;
            }

            public void setHomeId(int homeId) {
                this.homeId = homeId;
            }

            public int getGuestId() {
                return guestId;
            }

            public void setGuestId(int guestId) {
                this.guestId = guestId;
            }

            public String getHomePic() {
                return homePic;
            }

            public void setHomePic(String homePic) {
                this.homePic = homePic;
            }

            public String getGuestPic() {
                return guestPic;
            }

            public void setGuestPic(String guestPic) {
                this.guestPic = guestPic;
            }
        }
    }
}
