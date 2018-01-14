package com.jnic.provide.jnicwest.ui.release

import android.os.Bundle
import android.view.View
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.base.BaseActivity
import com.jnic.provide.jnicwest.bean.APIServiceBean
import com.jnic.provide.jnicwest.net.BaseCallback
import com.jnic.provide.jnicwest.net.WebList
import com.jnic.provide.jnicwest.tools.UIHelper
import com.jnic.provide.jnicwest.util.GsonUtils
import com.jnic.provide.jnicwest.util.StringUtils

/**
 * Created by ${jaylm}
 * on 2017/12/30.
 */
class ActivitySplash : BaseActivity() {

    override fun bindLayout(): Int {
        return R.layout.activity_splash
    }


    override fun initView(contentView: View) {
        super.initView(contentView)
        val channel = UIHelper.getAppMetaData(mActivity, "UMENG_CHANNEL")
        var appId = 201711212115L
        when (channel) {
            "_360" -> appId = 201711212115L
            "baidu" -> appId = 201711212116L
            "huawei" -> appId = 201711212117L
            "yingyongbao" -> appId = 201711212118L
            "xiaomi" -> appId = 201711212119L
            else -> 201711212115L
        }

        WebList.getService_api(appId, object : BaseCallback(mActivity, false) {
            override fun onSuccess(jsonString: String) {
                if (mActivity.isFinishing) {
                    return
                }

                val data = GsonUtils.parseJsonWithGson(jsonString, APIServiceBean::class.java)
                val version = data.version

                if (!StringUtils.isEmpty(version) && version.contains("2.0")) {
                    val bundle = Bundle()
                    bundle.putSerializable("data", data)
                    startActivity(ActivityHome::class.java, bundle)
                } else {
//                    startActivity(Intent(this@ActivitySplash, ActivityMain::class.java))
                }
                finish()
            }

            override fun onFailed(status: Int, msg: String, data: String) {
                super.onFailed(status, msg, data)
                if (mActivity.isFinishing) {
                    return
                }
//                startActivity(Intent(this@ActivitySplash, ActivityMain::class.java))
            }
        })
    }


}