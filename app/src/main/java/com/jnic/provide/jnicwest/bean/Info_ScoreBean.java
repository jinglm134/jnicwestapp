package com.jnic.provide.jnicwest.bean;

import java.util.List;

/**
 * Created by ${jaylm}
 * on 2018/1/16.
 */

public class Info_ScoreBean {

    /**
     * code : 200
     * rankingObj : {"all":[{"group":"A","list":[{"rank":1,"tid":27,"name":"曼联","round":6,"win":5,"equ":0,"fail":1,"goal":12,"loss":3,"abs":9,"score":15},{"rank":2,"tid":451,"name":"巴塞尔","round":6,"win":4,"equ":0,"fail":2,"goal":11,"loss":5,"abs":6,"score":12},{"rank":3,"tid":407,"name":"莫斯科中央","round":6,"win":3,"equ":0,"fail":3,"goal":8,"loss":10,"abs":-2,"score":9},{"rank":4,"tid":463,"name":"本菲卡","round":6,"win":0,"equ":0,"fail":6,"goal":1,"loss":14,"abs":-13,"score":0}]},{"group":"B","list":[{"rank":1,"tid":271,"name":"巴黎圣日尔曼","round":6,"win":5,"equ":0,"fail":1,"goal":25,"loss":4,"abs":21,"score":15},{"rank":2,"tid":88,"name":"拜仁慕尼黑","round":6,"win":5,"equ":0,"fail":1,"goal":13,"loss":6,"abs":7,"score":15},{"rank":3,"tid":70,"name":"凯尔特人","round":6,"win":1,"equ":0,"fail":5,"goal":5,"loss":18,"abs":-13,"score":3},{"rank":4,"tid":153,"name":"安德莱赫特","round":6,"win":1,"equ":0,"fail":5,"goal":2,"loss":17,"abs":-15,"score":3}]},{"group":"C","list":[{"rank":1,"tid":24,"name":"切尔西","round":6,"win":3,"equ":2,"fail":1,"goal":16,"loss":8,"abs":8,"score":11},{"rank":2,"tid":174,"name":"罗马","round":6,"win":3,"equ":2,"fail":1,"goal":9,"loss":6,"abs":3,"score":11},{"rank":3,"tid":109,"name":"马德里竞技","round":6,"win":1,"equ":4,"fail":1,"goal":5,"loss":4,"abs":1,"score":7},{"rank":4,"tid":4395,"name":"卡拉巴克","round":6,"win":0,"equ":2,"fail":4,"goal":2,"loss":14,"abs":-12,"score":2}]},{"group":"D","list":[{"rank":1,"tid":84,"name":"巴塞罗那","round":6,"win":4,"equ":2,"fail":0,"goal":9,"loss":1,"abs":8,"score":14},{"rank":2,"tid":166,"name":"尤文图斯","round":6,"win":3,"equ":2,"fail":1,"goal":7,"loss":5,"abs":2,"score":11},{"rank":3,"tid":466,"name":"里斯本竞技","round":6,"win":2,"equ":1,"fail":3,"goal":8,"loss":9,"abs":-1,"score":7},{"rank":4,"tid":568,"name":"奥林匹亚科斯","round":6,"win":0,"equ":1,"fail":5,"goal":4,"loss":13,"abs":-9,"score":1}]},{"group":"E","list":[{"rank":1,"tid":25,"name":"利物浦","round":6,"win":3,"equ":3,"fail":0,"goal":23,"loss":6,"abs":17,"score":12},{"rank":2,"tid":86,"name":"塞维利亚","round":6,"win":2,"equ":3,"fail":1,"goal":12,"loss":12,"abs":0,"score":9},{"rank":3,"tid":411,"name":"莫斯科斯巴达","round":6,"win":1,"equ":3,"fail":2,"goal":9,"loss":13,"abs":-4,"score":6},{"rank":4,"tid":725,"name":"马里博尔","round":6,"win":0,"equ":3,"fail":3,"goal":3,"loss":16,"abs":-13,"score":3}]},{"group":"F","list":[{"rank":1,"tid":26,"name":"曼城","round":6,"win":5,"equ":0,"fail":1,"goal":14,"loss":5,"abs":9,"score":15},{"rank":2,"tid":716,"name":"顿涅茨克矿","round":6,"win":4,"equ":0,"fail":2,"goal":9,"loss":9,"abs":0,"score":12},{"rank":3,"tid":1419,"name":"那不勒斯","round":6,"win":2,"equ":0,"fail":4,"goal":11,"loss":11,"abs":0,"score":6},{"rank":4,"tid":252,"name":"费耶诺德","round":6,"win":1,"equ":0,"fail":5,"goal":5,"loss":14,"abs":-9,"score":3}]},{"group":"G","list":[{"rank":1,"tid":529,"name":"贝西克塔斯","round":6,"win":4,"equ":2,"fail":0,"goal":11,"loss":5,"abs":6,"score":14},{"rank":2,"tid":468,"name":"波尔图","round":6,"win":3,"equ":1,"fail":2,"goal":15,"loss":10,"abs":5,"score":10},{"rank":3,"tid":13201,"name":"RB莱比锡","round":6,"win":2,"equ":1,"fail":3,"goal":10,"loss":11,"abs":-1,"score":7},{"rank":4,"tid":197,"name":"摩纳哥","round":6,"win":0,"equ":2,"fail":4,"goal":6,"loss":16,"abs":-10,"score":2}]},{"group":"H","list":[{"rank":1,"tid":33,"name":"热刺","round":6,"win":5,"equ":1,"fail":0,"goal":15,"loss":4,"abs":11,"score":16},{"rank":2,"tid":82,"name":"皇家马德里","round":6,"win":4,"equ":1,"fail":1,"goal":17,"loss":7,"abs":10,"score":13},{"rank":3,"tid":99,"name":"多特蒙德","round":6,"win":0,"equ":2,"fail":4,"goal":7,"loss":13,"abs":-6,"score":2},{"rank":4,"tid":703,"name":"希腊人","round":6,"win":0,"equ":2,"fail":4,"goal":2,"loss":17,"abs":-15,"score":2}]}]}
     * searchCondition : ["分组赛"]
     * rankingType : 2
     */

    private int code;
    private RankingObjBean rankingObj;
    private int rankingType;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public RankingObjBean getRankingObj() {
        return rankingObj;
    }

    public void setRankingObj(RankingObjBean rankingObj) {
        this.rankingObj = rankingObj;
    }

    public int getRankingType() {
        return rankingType;
    }

    public void setRankingType(int rankingType) {
        this.rankingType = rankingType;
    }


    public static class RankingObjBean {
        private List<AllBean> all;

        public List<AllBean> getAll() {
            return all;
        }

        public void setAll(List<AllBean> all) {
            this.all = all;
        }

        public static class AllBean {
            /**
             * group : A
             * list : [{"rank":1,"tid":27,"name":"曼联","round":6,"win":5,"equ":0,"fail":1,"goal":12,"loss":3,"abs":9,"score":15},{"rank":2,"tid":451,"name":"巴塞尔","round":6,"win":4,"equ":0,"fail":2,"goal":11,"loss":5,"abs":6,"score":12},{"rank":3,"tid":407,"name":"莫斯科中央","round":6,"win":3,"equ":0,"fail":3,"goal":8,"loss":10,"abs":-2,"score":9},{"rank":4,"tid":463,"name":"本菲卡","round":6,"win":0,"equ":0,"fail":6,"goal":1,"loss":14,"abs":-13,"score":0}]
             */

            private String group;
            private List<ListBean> list;

            public String getGroup() {
                return group;
            }

            public void setGroup(String group) {
                this.group = group;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * rank : 1
                 * tid : 27
                 * name : 曼联
                 * round : 6
                 * win : 5
                 * equ : 0
                 * fail : 1
                 * goal : 12
                 * loss : 3
                 * abs : 9
                 * score : 15
                 */

                private int rank;
                private int tid;
                private String name;
                private int round;
                private int win;
                private int equ;
                private int fail;
                private int goal;
                private int loss;
                private int abs;
                private int score;

                public int getRank() {
                    return rank;
                }

                public void setRank(int rank) {
                    this.rank = rank;
                }

                public int getTid() {
                    return tid;
                }

                public void setTid(int tid) {
                    this.tid = tid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getRound() {
                    return round;
                }

                public void setRound(int round) {
                    this.round = round;
                }

                public int getWin() {
                    return win;
                }

                public void setWin(int win) {
                    this.win = win;
                }

                public int getEqu() {
                    return equ;
                }

                public void setEqu(int equ) {
                    this.equ = equ;
                }

                public int getFail() {
                    return fail;
                }

                public void setFail(int fail) {
                    this.fail = fail;
                }

                public int getGoal() {
                    return goal;
                }

                public void setGoal(int goal) {
                    this.goal = goal;
                }

                public int getLoss() {
                    return loss;
                }

                public void setLoss(int loss) {
                    this.loss = loss;
                }

                public int getAbs() {
                    return abs;
                }

                public void setAbs(int abs) {
                    this.abs = abs;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }
            }
        }
    }
}
