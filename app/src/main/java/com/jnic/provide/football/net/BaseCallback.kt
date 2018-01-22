package com.jnic.provide.football.net

import android.app.Activity
import com.jnic.provide.football.BuildConfig
import com.jnic.provide.football.util.SnackbarUtils
import com.jnic.provide.football.view.ProgressDialog
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.model.Response
import com.lzy.okgo.request.base.Request
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by ${jaylm}
 * on 2017/12/30.
 */
abstract class BaseCallback(private var mActivity: Activity, private var isShow: Boolean = true) : StringCallback() {
    private var mDialog: ProgressDialog? = null
    private var xRecyclerView: XRecyclerView? = null
    private var isPullDown: Boolean = false

    init {
        if (isShow && mDialog == null) {
            mDialog = ProgressDialog(mActivity)
        }
    }

    /*xRecyclerView 的constructor*/
    constructor(mActivity: Activity, xRecyclerView: XRecyclerView, isPullDown: Boolean = true) : this(mActivity, false) {
        this.xRecyclerView = xRecyclerView
        this.isPullDown = isPullDown
    }


    override fun onSuccess(response: Response<String>) {
        val jsonString = response.body()
        try {
            val jsonObject = JSONObject(jsonString)
            /*JsonObject.opt 无key值时会得到默认值,JsonObject.get无key值会出错*/
            val data = jsonObject.optString("data")
            val status = jsonObject.optInt("status")
            val msg = jsonObject.optString("msg")
            if (status == 1) {
                onSuccess(data)
            } else {
                onFailed(status, msg, data)
            }
        } catch (e: JSONException) {
            if (BuildConfig.LOG_DEBUG) {
                e.printStackTrace()
                SnackbarUtils.showSnackbar(mActivity.window.decorView.rootView, "GSON解析错误")
            } else {
                SnackbarUtils.showSnackbar(mActivity.window.decorView.rootView, "网络异常,清稍后再试")
            }
        }

    }

    abstract fun onSuccess(jsonString: String)

    open fun onFailed(status: Int, msg: String, data: String) {
        SnackbarUtils.showSnackbar(mActivity.window.decorView.rootView, msg)
    }


    override fun onStart(request: Request<String, out Request<*, *>>?) {
        super.onStart(request)
        /* if (mActivity is BaseActivity) {
             mActivity.view_shade.visibility = View.VISIBLE
         }*/

        if (isShow) {
            showDialog()
        }
    }

    override fun onFinish() {
        super.onFinish()
        /* if (mActivity is BaseActivity) {
             mActivity.view_shade.visibility = View.GONE
         }*/

        if (isShow) {
            dismissDialog()
        }
        if (xRecyclerView != null) {
            if (isPullDown) {
                xRecyclerView!!.refreshComplete()
            } else {
                xRecyclerView!!.loadMoreComplete()
            }

        }
    }


    private fun showDialog() {
        if (mDialog != null && !mDialog!!.isShowing) {
            mDialog!!.show()
        }
    }

    private fun dismissDialog() {
        if (mDialog != null && mDialog!!.isShowing) {
            mDialog!!.dismiss()
        }
    }
}