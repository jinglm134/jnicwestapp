package com.jnic.provide.football.bean;

import java.util.List;

/**
 * Created by ${jaylm}
 * on 2018/1/16.
 */

public class BoardTypeBean {

    /**
     * template : ranking_types
     * content : {"data":[{"name":"进球","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=goals&version=134&refer=person_ranking&season_id=9235"},{"name":"助攻","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=assists&version=134&refer=person_ranking&season_id=9235"},{"name":"关键传球","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=key_passes&version=134&refer=person_ranking&season_id=9235"},{"name":"射门","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=shots&version=134&refer=person_ranking&season_id=9235"},{"name":"射正","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=shots_on_target&version=134&refer=person_ranking&season_id=9235"},{"name":"越位","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=offsides&version=134&refer=person_ranking&season_id=9235"},{"name":"传球","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=passes&version=134&refer=person_ranking&season_id=9235"},{"name":"成功传球","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=success_passes&version=134&refer=person_ranking&season_id=9235"},{"name":"拦截","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=interceptions&version=134&refer=person_ranking&season_id=9235"},{"name":"抢断","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=tackles&version=134&refer=person_ranking&season_id=9235"},{"name":"解围","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=clearances&version=134&refer=person_ranking&season_id=9235"},{"name":"犯规","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=fouls&version=134&refer=person_ranking&season_id=9235"},{"name":"被犯规","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=fouled&version=134&refer=person_ranking&season_id=9235"},{"name":"红牌","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=red_cards&version=134&refer=person_ranking&season_id=9235"},{"name":"黄牌","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=yellow_cards&version=134&refer=person_ranking&season_id=9235"},{"name":"扑救","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=saves&version=134&refer=person_ranking&season_id=9235"},{"name":"出场次数","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=appearances&version=134&refer=person_ranking&season_id=9235"},{"name":"出场时间","url":"https://api.dongqiudi.com/data/v1/person_ranking/0?type=time_played&version=134&refer=person_ranking&season_id=9235"}]}
     */

    private String template;
    private ContentBean content;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * name : 进球
             * url : https://api.dongqiudi.com/data/v1/person_ranking/0?type=goals&version=134&refer=person_ranking&season_id=9235
             */

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
