package com.jnic.provide.jnicwest.bean;

import com.jnic.provide.jnicwest.base.BaseBean;

import java.util.List;

/**
 * Created by ${jaylm}
 * on 2018/1/16.
 */

public class InfoBean extends BaseBean{

    /**
     * code : 200
     * internation : [{"kind":0,"leagueId":60,"lgName":"中超","pic":"http://pic.13322.com/icons/league/60.png"},{"kind":0,"leagueId":61,"lgName":"中甲","pic":"http://pic.13322.com/icons/league/61.png"},{"kind":0,"leagueId":36,"lgName":"英超","pic":"http://pic.13322.com/icons/league/36.png"},{"kind":0,"leagueId":31,"lgName":"西甲","pic":"http://pic.13322.com/icons/league/31.png"},{"kind":0,"leagueId":34,"lgName":"意甲","pic":"http://pic.13322.com/icons/league/34.png"},{"kind":0,"leagueId":8,"lgName":"德甲","pic":"http://pic.13322.com/icons/league/8.png"},{"kind":0,"leagueId":11,"lgName":"法甲","pic":"http://pic.13322.com/icons/league/11.png"},{"kind":2,"leagueId":67,"lgName":"欧洲杯","pic":"http://pic.13322.com/icons/league/67.png"},{"kind":2,"leagueId":224,"lgName":"美洲杯","pic":"http://pic.13322.com/icons/league/224.png"},{"kind":2,"leagueId":103,"lgName":"欧冠杯","pic":"http://pic.13322.com/icons/league/103.png"}]
     */

    private int code;
    private List<InternationBean> internation;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<InternationBean> getInternation() {
        return internation;
    }

    public void setInternation(List<InternationBean> internation) {
        this.internation = internation;
    }

    public static class InternationBean {
        /**
         * kind : 0
         * leagueId : 60
         * lgName : 中超
         * pic : http://pic.13322.com/icons/league/60.png
         */

        private int kind;
        private int leagueId;
        private String lgName;
        private String pic;

        public int getKind() {
            return kind;
        }

        public void setKind(int kind) {
            this.kind = kind;
        }

        public int getLeagueId() {
            return leagueId;
        }

        public void setLeagueId(int leagueId) {
            this.leagueId = leagueId;
        }

        public String getLgName() {
            return lgName;
        }

        public void setLgName(String lgName) {
            this.lgName = lgName;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
