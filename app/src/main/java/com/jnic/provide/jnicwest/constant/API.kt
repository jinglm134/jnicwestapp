package com.company.yijiu.newsapp.constant

/**
 * Created by ${jaylm}
 * on 2017/12/30.
 */
class API {
    companion object {
        const val HOST = "http://103.84.44.233:8080"
        const val REGISTER = "http://103.84.44.233:8080/index.php?s=/Api/News/register.html"
        const val API_SERVICE = "http://103.84.44.233:8081/serverapian.php"
        const val LOGIN = "http://103.84.44.233:8080/index.php?s=/Api/News/checklogin.html"
        const val MODIFY_PASSWORD = "http://103.84.44.233:8080/index.php?s=/Api/News/setpassword.html"
        const val NEWS_LOTTERY = "http://103.84.44.233:8080/index.php?s=/Api/Lottery/news_lottery.html"
        const val VIDEO_LIST = "http://103.84.44.233:8080/index.php?s=/Api/Video/videolist.html"
        const val NEWS_DETAIL = "http://103.84.44.233:8080/index.php?s=/Api/Lottery/news_details.html"
        const val SEND_MSG = "http://103.84.44.233:8080/index.php?s=/Api/Lottery/sendmsg.html"
        const val SEND_MSG_COMMENT = "http://103.84.44.233:8080/index.php?s=/Api/Comment/sendmsg.html"

        const val NEWS_ALL = "http://103.84.44.233:8080/index.php?s=/Api/News/news.html"
        const val NEWS_ALL_DETAIL = "http://103.84.44.233:8080/index.php?s=/Api/News/details.html"
        const val RACE_SCORE = "http://103.84.44.233:8080/index.php?s=/Api/News/getscore.html"
        const val RACE_INFO = "http://103.84.44.233:8080/index.php?s=/Api/Race/race_info.html"


        const val UPLOAD_USERFACE = "http://103.84.44.233:8080/index.php?s=/Api/News/userface.html"
        const val HOME_BANNER = "http://103.84.44.233:8080/index.php?s=/Api/User/carousel.html"
        const val USER_SIGN = "http://103.84.44.233:8080/index.php?s=/Api/News/user_sign.html"

        const val TEAM_BOARD = "http://103.84.44.233:8080/index.php?s=/Api/Race/get_raceinfolist.html"
        const val ATTENTION = "http://103.84.44.233:8080/index.php?s=/Api/User/attention.html"
        const val CANCEL_ATTENTION = "http://103.84.44.233:8080/index.php?s=/Api/User/cancel_attention.html"
        const val DYNAMIC_LIST = "http://103.84.44.233:8080/index.php?s=/Api/User/dynamic_list.html"
        const val DYNAMIC_DEL = "http://103.84.44.233:8080/index.php?s=/Api/User/del_dynamic.html"
        const val FEEDBACK = "http://103.84.44.233:8080/index.php?s=/Api/News/freeback.html"
        const val ATTENTION_LIST = "http://103.84.44.233:8080/index.php?s=/Api/User/attention_list.html"
        const val SEND_DYNAMIC = "http://103.84.44.233:8080/index.php?s=/Api/User/send_message.html"

        /****************************************一比分***********************************************/
        /**情报*/
        const val QINGBAO = "http://m.13322.com/mlottery/core/footballInformation.todayInfoList.do?date=2018-01-12&sourceType=0&seasonType=0&lang=zh&timeZone=8&version=140&versionCode=41&channelNumber=S1001"
        const val VIDEO = "http://games.mobileapi.hupu.com/1/7.1.14/fifa/getVideo?android_id=54e1ad7221299880&client=359090010542254&crt=1515829977886&time_zone=Asia%2FShanghai&sign=c89cfc082834c6c128eb58c1115255b0&night=0&type=&channel=360"

        const val JIAOQIU = "http://m.13322.com/mlottery/core/corner.getCornerList.do?lang=zh&timeZone=8"
    }
}