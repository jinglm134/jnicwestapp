package com.jnic.provide.football.bean

import com.jnic.provide.football.base.BaseBean

/**
 * Created by ${jaylm}
 * on 2017/12/30.
 */
data class APIServiceBean(
        var app_id: String, var version: String, var kc_url: String, var home_url: String,
        var service_url: String, var buttonArr: String, var buttonImage: String) : BaseBean()