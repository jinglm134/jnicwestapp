package com.jnic.provide.jnicwest.base

import java.io.Serializable

/**
 * Created by ${jaylm}
 * on 2017/12/30.
 */
open class BaseBean(var stampTime: Long = 0L) : Serializable {
    init {
        stampTime = System.currentTimeMillis()
    }
}