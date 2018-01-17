package com.jnic.provide.jnicwest.constant

/**
 * Created by ${jaylm}
 * on 2017/12/30.
 */
class API {
    companion object {
        const val HOST = "http://103.84.44.233:8080"

        const val API_SERVICE = "http://103.84.44.233:8081/serverapian.php"


        /****************************************一比分***********************************************/
        /**情报*/
        const val QINGBAO = "http://m.13322.com/mlottery/core/footballInformation.todayInfoList.do?date=2018-01-12&sourceType=0&seasonType=0&lang=zh&timeZone=8&version=140&versionCode=41&channelNumber=S1001"
        const val VIDEO = "http://games.mobileapi.hupu.com/1/7.1.14/fifa/getVideo?android_id=54e1ad7221299880&client=359090010542254&crt=1515829977886&time_zone=Asia%2FShanghai&sign=c89cfc082834c6c128eb58c1115255b0&night=0&type=&channel=360"

        const val JIAOQIU = "http://m.13322.com/mlottery/core/corner.getCornerList.do?lang=zh&timeZone=8"


        /**懂球帝*/
        const val TOUTIAO = "https://api.dongqiudi.com/app/tabs/android/1.json?mark=gif&version=134"
        const val REMEN = "https://api.dongqiudi.com/app/tabs/android/104.json?mark=gif&version=134"
        const val ZHUANHUI = "https://api.dongqiudi.com/app/tabs/android/110.json?mark=gif&version=134"
        const val ZHUQIU = "https://api.dongqiudi.com/app/tabs/android/58.json?mark=gif&version=134"
        const val ZHONGGUOZUQIU = "https://api.dongqiudi.com/app/tabs/android/56.json?mark=gif&version=134"

        const val YINGCHAO = "https://api.dongqiudi.com/app/tabs/android/3.json?mark=gif&version=134"
        const val XIJIA = "https://api.dongqiudi.com/app/tabs/android/6.json?mark=gif&version=134"
        const val DEJIA = "https://api.dongqiudi.com/app/tabs/android/4.json?mark=gif&version=134"
        const val YIJIA = "https://api.dongqiudi.com/app/tabs/android/4.json?mark=gif&version=134"

        const val BOARD = "https://api.dongqiudi.com/data/v1/ranking_type/0?version=134&refer=data_tab"

        /**hupu*/
        const val VO_YINGCHAO = "http://games.mobileapi.hupu.com/1/7.1.14/epl/getVideo?android_id=54e1ad7221299880&client=359090010542254&time_zone=Asia%2FShanghai&sign=cd4f0020d85fec74bef4fe5b16f04254&night=0&type=&channel=360"

        /**一比分*/

        //赛程
        const val LeagueRound = "http://m.13322.com/mlottery/core/androidLeagueData.findAndroidLeagueRound.do"
        //积分
        const val LeagueScore = "http://m.13322.com/mlottery/core/androidLeagueData.findAndroidLeagueScore.do"
        /*让分盘*/
        const val LeagueHdp = "http://m.13322.com/mlottery/core/androidLeagueData.findAndroidLeagueHdp.do?lang=zh&timeZone=8"
        //大小盘
        const val LeagueOu = "http://m.13322.com/mlottery/core/androidLeagueData.findAndroidLeagueOu.do?lang=zh&timeZone=8"
        //统计
        const val Statics = "http://m.13322.com/mlottery/core/androidLeagueData.findAndroidStatics.do?lang=zh&timeZone=8"
        const val DataMenu = "http://m.13322.com/mlottery/core/androidLeagueData.findAndroidDataMenu.do?lang=zh&timeZone=8&index=0"

    }
}