package com.jnic.provide.jnicwest.adapter

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.base.BaseRecyclerAdapter
import com.jnic.provide.jnicwest.base.BaseRecyclerHolder
import com.jnic.provide.jnicwest.bean.InfoBean
import com.jnic.provide.jnicwest.bean.ReMenBean
import com.jnic.provide.jnicwest.util.glide.GlideUtils

/**
 * Created by ${jaylm}
 * on 2018/1/15.
 */
class AdapterInfo(context: Context, layoutId: Int, data: ArrayList<InfoBean.InternationBean>) : BaseRecyclerAdapter<InfoBean.InternationBean>(context, layoutId, data) {
    override fun convert(holder: BaseRecyclerHolder, t: InfoBean.InternationBean) {
        val iv_logo = holder.getView<ImageView>(R.id.iv_logo)
        val tv_name = holder.getView<TextView>(R.id.tv_name)

        GlideUtils.loadImg(mContext, t.pic, iv_logo)
        tv_name.text = t.lgName
    }
}