package com.jnic.provide.football.bean;

import com.jnic.provide.football.base.BaseBean;

import java.util.List;

/**
 * Created by ${jaylm}
 * on 2018/1/22.
 */

public class TeamInfoBean extends BaseBean {

    /**
     * base_info : {"id":"1","team_id":"50001756","team_name":"巴塞罗那","team_en_name":"Barcelona","team_logo":"https://img.dongqiudi.com/data/pic/2017.png","country_logo":"https://img.dongqiudi.com/data/areapic/176.png","country":"西班牙","address":"Avenida de Arístides Maillol","telephone":"+34 (902) 189 900","email":"oab@club.fcbarcelona.com","city":"Barcelona","founded":"1899","venue_name":"诺坎普球场","venue_capacity":"99787"}
     * trophy_info : [{"id":"1","competition_id":"6","competition_name":"欧洲冠军联赛","trophy_img":"https://img.dongqiudi.com/data/trophypic/10.png","team_id":"50001756","cup":"5","list":[{"id":"1","competition_id":"6","season_name":"2014/2015","team_id":"50001756"},{"id":"2","competition_id":"6","season_name":"2010/2011","team_id":"50001756"},{"id":"3","competition_id":"6","season_name":"2008/2009","team_id":"50001756"},{"id":"4","competition_id":"6","season_name":"2005/2006","team_id":"50001756"},{"id":"5","competition_id":"6","season_name":"1991/1992","team_id":"50001756"}]}]
     */

    private BaseInfoBean base_info;
    private List<TrophyInfoBean> trophy_info;

    public BaseInfoBean getBase_info() {
        return base_info;
    }

    public void setBase_info(BaseInfoBean base_info) {
        this.base_info = base_info;
    }

    public List<TrophyInfoBean> getTrophy_info() {
        return trophy_info;
    }

    public void setTrophy_info(List<TrophyInfoBean> trophy_info) {
        this.trophy_info = trophy_info;
    }

    public static class BaseInfoBean {
        /**
         * id : 1
         * team_id : 50001756
         * team_name : 巴塞罗那
         * team_en_name : Barcelona
         * team_logo : https://img.dongqiudi.com/data/pic/2017.png
         * country_logo : https://img.dongqiudi.com/data/areapic/176.png
         * country : 西班牙
         * address : Avenida de Arístides Maillol
         * telephone : +34 (902) 189 900
         * email : oab@club.fcbarcelona.com
         * city : Barcelona
         * founded : 1899
         * venue_name : 诺坎普球场
         * venue_capacity : 99787
         */

        private String id;
        private String team_id;
        private String team_name;
        private String team_en_name;
        private String team_logo;
        private String country_logo;
        private String country;
        private String address;
        private String telephone;
        private String email;
        private String city;
        private String founded;
        private String venue_name;
        private String venue_capacity;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTeam_id() {
            return team_id;
        }

        public void setTeam_id(String team_id) {
            this.team_id = team_id;
        }

        public String getTeam_name() {
            return team_name;
        }

        public void setTeam_name(String team_name) {
            this.team_name = team_name;
        }

        public String getTeam_en_name() {
            return team_en_name;
        }

        public void setTeam_en_name(String team_en_name) {
            this.team_en_name = team_en_name;
        }

        public String getTeam_logo() {
            return team_logo;
        }

        public void setTeam_logo(String team_logo) {
            this.team_logo = team_logo;
        }

        public String getCountry_logo() {
            return country_logo;
        }

        public void setCountry_logo(String country_logo) {
            this.country_logo = country_logo;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getFounded() {
            return founded;
        }

        public void setFounded(String founded) {
            this.founded = founded;
        }

        public String getVenue_name() {
            return venue_name;
        }

        public void setVenue_name(String venue_name) {
            this.venue_name = venue_name;
        }

        public String getVenue_capacity() {
            return venue_capacity;
        }

        public void setVenue_capacity(String venue_capacity) {
            this.venue_capacity = venue_capacity;
        }
    }

    public static class TrophyInfoBean {
        /**
         * id : 1
         * competition_id : 6
         * competition_name : 欧洲冠军联赛
         * trophy_img : https://img.dongqiudi.com/data/trophypic/10.png
         * team_id : 50001756
         * cup : 5
         * list : [{"id":"1","competition_id":"6","season_name":"2014/2015","team_id":"50001756"},{"id":"2","competition_id":"6","season_name":"2010/2011","team_id":"50001756"},{"id":"3","competition_id":"6","season_name":"2008/2009","team_id":"50001756"},{"id":"4","competition_id":"6","season_name":"2005/2006","team_id":"50001756"},{"id":"5","competition_id":"6","season_name":"1991/1992","team_id":"50001756"}]
         */

        private String id;
        private String competition_id;
        private String competition_name;
        private String trophy_img;
        private String team_id;
        private String cup;
        private List<ListBean> list;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCompetition_id() {
            return competition_id;
        }

        public void setCompetition_id(String competition_id) {
            this.competition_id = competition_id;
        }

        public String getCompetition_name() {
            return competition_name;
        }

        public void setCompetition_name(String competition_name) {
            this.competition_name = competition_name;
        }

        public String getTrophy_img() {
            return trophy_img;
        }

        public void setTrophy_img(String trophy_img) {
            this.trophy_img = trophy_img;
        }

        public String getTeam_id() {
            return team_id;
        }

        public void setTeam_id(String team_id) {
            this.team_id = team_id;
        }

        public String getCup() {
            return cup;
        }

        public void setCup(String cup) {
            this.cup = cup;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1
             * competition_id : 6
             * season_name : 2014/2015
             * team_id : 50001756
             */

            private String id;
            private String competition_id;
            private String season_name;
            private String team_id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCompetition_id() {
                return competition_id;
            }

            public void setCompetition_id(String competition_id) {
                this.competition_id = competition_id;
            }

            public String getSeason_name() {
                return season_name;
            }

            public void setSeason_name(String season_name) {
                this.season_name = season_name;
            }

            public String getTeam_id() {
                return team_id;
            }

            public void setTeam_id(String team_id) {
                this.team_id = team_id;
            }
        }
    }
}
