package com.jnic.provide.football.net

import com.jnic.provide.football.constant.API
import com.lzy.okgo.OkGo

/**
 * Created by ${jaylm}
 * on 2017/12/30.
 */
object WebList {
    /**
     * 版本号信息接口
     * @param callback callback
     */
    fun getService_api(appId: Long, callback: BaseCallback) {
        OkGo.post<String>(API.API_SERVICE)
                .params("app_id", appId)
                .execute(callback)
    }

    /**
     * 球队信息
     */
    fun getTeamInfo(team_id: Int, callback: BaseCallback) {
        OkGo.post<String>(API.API_SERVICE)
                .params("dopost", "getteaminfo")
                .params("team_id", team_id)
                .execute(callback)
    }

    /*****************************************一比分*********************************/
    /**
     * 情报
     */
    fun qingbao(data: String, callback: BaseCallback) {
        OkGo.get<String>(API.QINGBAO + "&date=" + data).execute(callback)
    }

    fun video(callback: BaseCallback) {
        OkGo.get<String>(API.VIDEO).execute(callback)
    }

    fun jiaoqiu(date: String, callback: BaseCallback) {
        OkGo.get<String>(API.JIAOQIU + "&date=" + date).execute(callback)
    }


    /**********************************懂球帝****************************************************/

    fun remen(callback: BaseCallback) {
        OkGo.get<String>(API.REMEN).execute(callback)
    }

    fun base(url: String, callback: BaseCallback) {
        OkGo.get<String>(url).execute(callback)
    }

    /**race*/
    fun LeagueRace(leagueId: Int, type: Int, callback: BaseCallback) {
        OkGo.post<String>(API.LeagueRound)
                .params("timeZone", 8)
                .params("type", type)
                .params("lang", "zh")
                .params("leagueId", leagueId)
                .execute(callback)
    }

    /**score*/
    fun LeagueScore(leagueId: Int, type: Int, callback: BaseCallback) {
        OkGo.post<String>(API.LeagueScore)
                .params("timeZone", 8)
                .params("type", type)
                .params("lang", "zh")
                .params("leagueId", leagueId)
                .execute(callback)
    }

}

