package com.jnic.provide.jnicwest.net

import com.company.yijiu.newsapp.constant.API
import com.lzy.okgo.OkGo
import java.io.File

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
     * banner接口
     * @param callback callback
     */
    fun getBanner(callback: BaseCallback) {
        OkGo.post<String>(API.HOME_BANNER)
                .params("dopost", "getcarousel")
                .execute(callback)
    }

    /**
     * 获取赛事数据接口
     * @param callback callback
     */
    fun getRaceScore(callback: BaseCallback) {
        OkGo.post<String>(API.RACE_SCORE)
                .params("dopost", "match")
                .execute(callback)
    }

    /**
     * 注册接口

     * @param username
     *
     * @param password
     *
     * @param callback
     */
    fun register(username: String, password: String, callback: BaseCallback) {
        OkGo.post<String>(API.REGISTER)
                .params("dopost", "reg")
                .params("username", username)
                .params("password", password)
                .execute(callback)
    }


    /**
     * 登陆接口

     * @param username
     *
     * @param password
     *
     * @param callback
     */
    fun login(username: String, password: String, callback: BaseCallback) {
        OkGo.post<String>(API.LOGIN)
                .params("dopost", "checklogin")
                .params("username", username)
                .params("password", password)
                .execute(callback)
    }

    /**
     * 修改密码接口
     * @param username
     *
     * @param password
     *
     * @param callback
     */
    fun modifyPassword(username: String, password: String, callback: BaseCallback) {
        OkGo.post<String>(API.MODIFY_PASSWORD)
                .params("dopost", "change")
                .params("username", username)
                .params("password", password)
                .execute(callback)
    }


    /**
     * 获取视频列表
     * @param callback
     */
    fun getVideoList(callback: BaseCallback) {
        OkGo.post<String>(API.VIDEO_LIST)
                .params("dopost", "getlist")
                .execute(callback)
    }


    /**
     * 评论消息

     * @param username 用户名
     *
     * @param nid      所属新闻ID
     *
     * @param uid      用户ID
     *
     * @param content  评论内容
     *
     * @param callback callback
     */
    fun sendMessage_Comment(username: String, nid: Int, uid: Int, content: String, callback: BaseCallback) {
        OkGo.post<String>(API.SEND_MSG_COMMENT)
                .params("dopost", "send")
                .params("username", username)
                .params("nid", nid)
                .params("uid", uid)
                .params("content", content)
                .execute(callback)
    }

    /**
     * 获取新闻列表
     * @param callback
     */
    fun getNews_all(callback: BaseCallback) {
        OkGo.post<String>(API.NEWS_ALL)
                .execute(callback)
    }

    /**
     * 获取新闻详情
     * @param id
     *
     * @param callback
     */
    fun getNewsAllDetail(id: Int, callback: BaseCallback) {
        OkGo.post<String>(API.NEWS_ALL_DETAIL)
                .params("id", id)
                .execute(callback)
    }


    /**
     * @param boards   goals/assits
     *
     * @param team     epl英超/liga西甲/bund德甲/fran法甲/seri意甲/chlg欧冠
     *
     * @param callback callback
     */
    fun getRaceInfo(boards: String, team: String, callback: BaseCallback) {
        OkGo.post<String>(API.RACE_INFO)
                .params("dopost", "raceinfo")
                .params("type", boards)
                .params("team", team)
                .execute(callback)
    }

    fun uploadUserface(uid: Int, file: File, callback: BaseCallback) {
        OkGo.post<String>(API.UPLOAD_USERFACE)
                .params("dopost", "uploadimg")
                .params("uid", uid)
                .params("file", file)
                .execute(callback)
    }

    fun getTeamBoard(callback: BaseCallback) {
        OkGo.post<String>(API.TEAM_BOARD)
                .params("dopost", "getraceinfolist")
                .execute(callback)
    }


    fun userSign(uid: Int, callback: BaseCallback) {
        OkGo.post<String>(API.USER_SIGN)
                .params("dopost", "sign")
                .params("uid", uid)
                .execute(callback)
    }

    /**
     * 关注接口
     * @param uid:用户id
     * @param auid:被关注用户id
     * @param callback:BaseCallback
     */
    fun attention(uid: Int, auid: Int, callback: BaseCallback) {
        OkGo.post<String>(API.ATTENTION)
                .params("dopost", "attention")
                .params("uid", uid)
                .params("auid", auid)
                .execute(callback)
    }

    /**
     *
     * 取消关注接口
     * @param uid:用户id
     * @param auid:被关注用户id
     * @param callback:BaseCallback
     */
    fun attention_cancel(uid: Int, auid: Int, callback: BaseCallback) {
        OkGo.post<String>(API.CANCEL_ATTENTION)
                .params("dopost", "cancel")
                .params("uid", uid)
                .params("auid", auid)
                .execute(callback)
    }

    /**
     * 删除动态
     * @param uid 用户id
     * @param id 动态id
     * @param callback BaseCallback
     */
    fun attention_del(uid: Int, id: Int, callback: BaseCallback) {
        OkGo.post<String>(API.DYNAMIC_DEL)
                .params("dopost", "deldynamic")
                .params("uid", uid)
                .params("id", id)
                .execute(callback)
    }

    /**
     * 关注用户的动态列表接口
     * @param uid:用户id
     * @param callback:BaseCallback
     */
    fun attention_list(uid: Int, callback: BaseCallback) {
        OkGo.post<String>(API.ATTENTION_LIST)
                .params("dopost", "alist")
                .params("uid", uid)
                .execute(callback)
    }

    /**
     * 关注的用户列表接口
     * @param uid:用户id
     * @param callback:BaseCallback
     */
    fun attention_user(uid: Int, callback: BaseCallback) {
        OkGo.post<String>(API.ATTENTION_LIST)
                .params("dopost", "ulist")
                .params("uid", uid)
                .execute(callback)
    }

    /**
     * 我的动态列表/全部动态列表
     * @param uid:用户id
     * @param callback:BaseCallback
     */
    fun dynamic_list(uid: Int, callback: BaseCallback) {
        if (uid <= 0) {
            OkGo.post<String>(API.DYNAMIC_LIST)
                    .params("dopost", "dlist")
                    .execute(callback)
        } else {
            OkGo.post<String>(API.DYNAMIC_LIST)
                    .params("dopost", "dlist")
                    .params("uid", uid)
                    .execute(callback)
        }
    }


    /**
     * 发表动态
     * @param uid:用户id
     * @param callback:BaseCallback
     */
    fun sendDynamic(uid: Int, content: String, file: List<File>, callback: BaseCallback) {
        OkGo.post<String>(API.SEND_DYNAMIC)
                .params("dopost", "send")
                .params("uid", uid)
                .params("title", "")
                .params("content", content)
                .addFileParams(if (file.size == 1) {
                    "file"
                } else {
                    "file[]"
                }, file)
                .execute(callback)

    }

    /**
     * 反馈建议
     * @param uid:用户id
     * @param content:反馈内容
     * @param callback:BaseCallback
     */
    fun feedback(uid: Int, content: String, callback: BaseCallback) {
        OkGo.post<String>(API.FEEDBACK)
                .params("dopost", "addinfo")
                .params("uid", uid)
                .params("content", content)
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
}