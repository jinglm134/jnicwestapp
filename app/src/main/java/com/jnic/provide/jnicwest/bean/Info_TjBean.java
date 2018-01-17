package com.jnic.provide.jnicwest.bean;

import java.util.List;

/**
 * Created by ${jaylm}
 * on 2018/1/16.
 */

public class Info_TjBean {

    /**
     * code : 200
     * statics : {"matchCount":190,"homeWinCount":88,"equalCount":42,"awayWinCount":60,"homeWinPer":"46.32%","equalPer":"22.11%","awayWinPer":"31.58%","goalCount":547,"homeCount":0,"awayCount":0,"goalAvg":2.88,"homeAvg":1.62,"awayAvg":1.26,"moreZero":179,"moreOne":152,"moreTwo":106,"moreThree":57,"moreZeroPer":"94.21%","moreOnePer":"80%","moreTwoPer":"55.79%","moreThreePer":"30%"}
     * top : {"defTop":[{"teamId":19695,"teamName":"拉科奥里塔","icon":"http://pic.13322.com/icons/teams/100/19695.png","total":"1","per":"0.5"},{"teamId":11232,"teamName":"维托鲁","icon":"http://pic.13322.com/icons/teams/100/11232.png","total":"0","per":"0"},{"teamId":9,"teamName":"萨尔茨堡","icon":"http://pic.13322.com/icons/teams/100/9.png","total":"0","per":"0"}],"atkTop":[{"teamId":25,"teamName":"利物浦","icon":"http://pic.13322.com/icons/teams/100/25.png","total":"29","per":"3.62"},{"teamId":25,"teamName":"利物浦","icon":"http://pic.13322.com/icons/teams/100/25.png","total":"16","per":"4"},{"teamId":25,"teamName":"利物浦","icon":"http://pic.13322.com/icons/teams/100/25.png","total":"13","per":"3.25"}],"winTop":[{"teamId":407,"teamName":"莫斯科中央","icon":"http://pic.13322.com/icons/teams/100/407.png","total":"7","per":"70%","matchCount":"10"},{"teamId":86,"teamName":"塞维利亚","icon":"http://pic.13322.com/icons/teams/100/86.png","total":"4","per":"50%","matchCount":"8"},{"teamId":70,"teamName":"凯尔特人","icon":"http://pic.13322.com/icons/teams/100/70.png","total":"6","per":"50%","matchCount":"12"}],"atkWeak":[{"teamId":10932,"teamName":"森特尔迪亚","icon":"http://pic.13322.com/icons/teams/100/10932.png","total":"0","per":"0"},{"teamId":19695,"teamName":"拉科奥里塔","icon":"http://pic.13322.com/icons/teams/100/19695.png","total":"0","per":"0"},{"teamId":712,"teamName":"基辅迪纳摩","icon":"http://pic.13322.com/icons/teams/100/712.png","total":"0","per":"0"}],"defWeak":[{"teamId":70,"teamName":"凯尔特人","icon":"http://pic.13322.com/icons/teams/100/70.png","total":"22","per":"1.83"},{"teamId":725,"teamName":"马里博尔","icon":"http://pic.13322.com/icons/teams/100/725.png","total":"10","per":"1.67"},{"teamId":70,"teamName":"凯尔特人","icon":"http://pic.13322.com/icons/teams/100/70.png","total":"14","per":"2.33"}]}
     */

    private int code;
    private StaticsBean statics;
    private TopBean top;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public StaticsBean getStatics() {
        return statics;
    }

    public void setStatics(StaticsBean statics) {
        this.statics = statics;
    }

    public TopBean getTop() {
        return top;
    }

    public void setTop(TopBean top) {
        this.top = top;
    }

    public static class StaticsBean {
        /**
         * matchCount : 190
         * homeWinCount : 88
         * equalCount : 42
         * awayWinCount : 60
         * homeWinPer : 46.32%
         * equalPer : 22.11%
         * awayWinPer : 31.58%
         * goalCount : 547
         * homeCount : 0
         * awayCount : 0
         * goalAvg : 2.88
         * homeAvg : 1.62
         * awayAvg : 1.26
         * moreZero : 179
         * moreOne : 152
         * moreTwo : 106
         * moreThree : 57
         * moreZeroPer : 94.21%
         * moreOnePer : 80%
         * moreTwoPer : 55.79%
         * moreThreePer : 30%
         */

        private int matchCount;
        private int homeWinCount;
        private int equalCount;
        private int awayWinCount;
        private String homeWinPer;
        private String equalPer;
        private String awayWinPer;
        private int goalCount;
        private int homeCount;
        private int awayCount;
        private double goalAvg;
        private double homeAvg;
        private double awayAvg;
        private int moreZero;
        private int moreOne;
        private int moreTwo;
        private int moreThree;
        private String moreZeroPer;
        private String moreOnePer;
        private String moreTwoPer;
        private String moreThreePer;

        public int getMatchCount() {
            return matchCount;
        }

        public void setMatchCount(int matchCount) {
            this.matchCount = matchCount;
        }

        public int getHomeWinCount() {
            return homeWinCount;
        }

        public void setHomeWinCount(int homeWinCount) {
            this.homeWinCount = homeWinCount;
        }

        public int getEqualCount() {
            return equalCount;
        }

        public void setEqualCount(int equalCount) {
            this.equalCount = equalCount;
        }

        public int getAwayWinCount() {
            return awayWinCount;
        }

        public void setAwayWinCount(int awayWinCount) {
            this.awayWinCount = awayWinCount;
        }

        public String getHomeWinPer() {
            return homeWinPer;
        }

        public void setHomeWinPer(String homeWinPer) {
            this.homeWinPer = homeWinPer;
        }

        public String getEqualPer() {
            return equalPer;
        }

        public void setEqualPer(String equalPer) {
            this.equalPer = equalPer;
        }

        public String getAwayWinPer() {
            return awayWinPer;
        }

        public void setAwayWinPer(String awayWinPer) {
            this.awayWinPer = awayWinPer;
        }

        public int getGoalCount() {
            return goalCount;
        }

        public void setGoalCount(int goalCount) {
            this.goalCount = goalCount;
        }

        public int getHomeCount() {
            return homeCount;
        }

        public void setHomeCount(int homeCount) {
            this.homeCount = homeCount;
        }

        public int getAwayCount() {
            return awayCount;
        }

        public void setAwayCount(int awayCount) {
            this.awayCount = awayCount;
        }

        public double getGoalAvg() {
            return goalAvg;
        }

        public void setGoalAvg(double goalAvg) {
            this.goalAvg = goalAvg;
        }

        public double getHomeAvg() {
            return homeAvg;
        }

        public void setHomeAvg(double homeAvg) {
            this.homeAvg = homeAvg;
        }

        public double getAwayAvg() {
            return awayAvg;
        }

        public void setAwayAvg(double awayAvg) {
            this.awayAvg = awayAvg;
        }

        public int getMoreZero() {
            return moreZero;
        }

        public void setMoreZero(int moreZero) {
            this.moreZero = moreZero;
        }

        public int getMoreOne() {
            return moreOne;
        }

        public void setMoreOne(int moreOne) {
            this.moreOne = moreOne;
        }

        public int getMoreTwo() {
            return moreTwo;
        }

        public void setMoreTwo(int moreTwo) {
            this.moreTwo = moreTwo;
        }

        public int getMoreThree() {
            return moreThree;
        }

        public void setMoreThree(int moreThree) {
            this.moreThree = moreThree;
        }

        public String getMoreZeroPer() {
            return moreZeroPer;
        }

        public void setMoreZeroPer(String moreZeroPer) {
            this.moreZeroPer = moreZeroPer;
        }

        public String getMoreOnePer() {
            return moreOnePer;
        }

        public void setMoreOnePer(String moreOnePer) {
            this.moreOnePer = moreOnePer;
        }

        public String getMoreTwoPer() {
            return moreTwoPer;
        }

        public void setMoreTwoPer(String moreTwoPer) {
            this.moreTwoPer = moreTwoPer;
        }

        public String getMoreThreePer() {
            return moreThreePer;
        }

        public void setMoreThreePer(String moreThreePer) {
            this.moreThreePer = moreThreePer;
        }
    }

    public static class TopBean {
        private List<DefTopBean> defTop;
        private List<AtkTopBean> atkTop;
        private List<WinTopBean> winTop;
        private List<AtkWeakBean> atkWeak;
        private List<DefWeakBean> defWeak;

        public List<DefTopBean> getDefTop() {
            return defTop;
        }

        public void setDefTop(List<DefTopBean> defTop) {
            this.defTop = defTop;
        }

        public List<AtkTopBean> getAtkTop() {
            return atkTop;
        }

        public void setAtkTop(List<AtkTopBean> atkTop) {
            this.atkTop = atkTop;
        }

        public List<WinTopBean> getWinTop() {
            return winTop;
        }

        public void setWinTop(List<WinTopBean> winTop) {
            this.winTop = winTop;
        }

        public List<AtkWeakBean> getAtkWeak() {
            return atkWeak;
        }

        public void setAtkWeak(List<AtkWeakBean> atkWeak) {
            this.atkWeak = atkWeak;
        }

        public List<DefWeakBean> getDefWeak() {
            return defWeak;
        }

        public void setDefWeak(List<DefWeakBean> defWeak) {
            this.defWeak = defWeak;
        }

        public static class DefTopBean {
            /**
             * teamId : 19695
             * teamName : 拉科奥里塔
             * icon : http://pic.13322.com/icons/teams/100/19695.png
             * total : 1
             * per : 0.5
             */

            private int teamId;
            private String teamName;
            private String icon;
            private String total;
            private String per;

            public int getTeamId() {
                return teamId;
            }

            public void setTeamId(int teamId) {
                this.teamId = teamId;
            }

            public String getTeamName() {
                return teamName;
            }

            public void setTeamName(String teamName) {
                this.teamName = teamName;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getPer() {
                return per;
            }

            public void setPer(String per) {
                this.per = per;
            }
        }

        public static class AtkTopBean {
            /**
             * teamId : 25
             * teamName : 利物浦
             * icon : http://pic.13322.com/icons/teams/100/25.png
             * total : 29
             * per : 3.62
             */

            private int teamId;
            private String teamName;
            private String icon;
            private String total;
            private String per;

            public int getTeamId() {
                return teamId;
            }

            public void setTeamId(int teamId) {
                this.teamId = teamId;
            }

            public String getTeamName() {
                return teamName;
            }

            public void setTeamName(String teamName) {
                this.teamName = teamName;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getPer() {
                return per;
            }

            public void setPer(String per) {
                this.per = per;
            }
        }

        public static class WinTopBean {
            /**
             * teamId : 407
             * teamName : 莫斯科中央
             * icon : http://pic.13322.com/icons/teams/100/407.png
             * total : 7
             * per : 70%
             * matchCount : 10
             */

            private int teamId;
            private String teamName;
            private String icon;
            private String total;
            private String per;
            private String matchCount;

            public int getTeamId() {
                return teamId;
            }

            public void setTeamId(int teamId) {
                this.teamId = teamId;
            }

            public String getTeamName() {
                return teamName;
            }

            public void setTeamName(String teamName) {
                this.teamName = teamName;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getPer() {
                return per;
            }

            public void setPer(String per) {
                this.per = per;
            }

            public String getMatchCount() {
                return matchCount;
            }

            public void setMatchCount(String matchCount) {
                this.matchCount = matchCount;
            }
        }

        public static class AtkWeakBean {
            /**
             * teamId : 10932
             * teamName : 森特尔迪亚
             * icon : http://pic.13322.com/icons/teams/100/10932.png
             * total : 0
             * per : 0
             */

            private int teamId;
            private String teamName;
            private String icon;
            private String total;
            private String per;

            public int getTeamId() {
                return teamId;
            }

            public void setTeamId(int teamId) {
                this.teamId = teamId;
            }

            public String getTeamName() {
                return teamName;
            }

            public void setTeamName(String teamName) {
                this.teamName = teamName;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getPer() {
                return per;
            }

            public void setPer(String per) {
                this.per = per;
            }
        }

        public static class DefWeakBean {
            /**
             * teamId : 70
             * teamName : 凯尔特人
             * icon : http://pic.13322.com/icons/teams/100/70.png
             * total : 22
             * per : 1.83
             */

            private int teamId;
            private String teamName;
            private String icon;
            private String total;
            private String per;

            public int getTeamId() {
                return teamId;
            }

            public void setTeamId(int teamId) {
                this.teamId = teamId;
            }

            public String getTeamName() {
                return teamName;
            }

            public void setTeamName(String teamName) {
                this.teamName = teamName;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getPer() {
                return per;
            }

            public void setPer(String per) {
                this.per = per;
            }
        }
    }
}
