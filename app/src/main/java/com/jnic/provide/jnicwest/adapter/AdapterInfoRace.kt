package com.jnic.provide.jnicwest.adapter

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.base.BaseRecyclerAdapter
import com.jnic.provide.jnicwest.base.BaseRecyclerHolder
import com.jnic.provide.jnicwest.bean.Info_RaceBean
import com.jnic.provide.jnicwest.util.glide.GlideUtils

/**
 * Created by ${jaylm}
 * on 2018/1/15.
 */
class AdapterInfoRace(context: Context, layouId: Int, data: ArrayList<Info_RaceBean.RaceBean.DatasBean>) : BaseRecyclerAdapter<Info_RaceBean.RaceBean.DatasBean>(context, layouId, data) {
    override fun convert(holder: BaseRecyclerHolder, t: Info_RaceBean.RaceBean.DatasBean) {
        val iv_home = holder.getView<ImageView>(R.id.iv_home)
        val iv_visit = holder.getView<ImageView>(R.id.iv_visit)
        val tv_time = holder.getView<TextView>(R.id.tv_time)
        val tv_home = holder.getView<TextView>(R.id.tv_home)
        val tv_visit = holder.getView<TextView>(R.id.tv_visit)

        GlideUtils.loadImg(mContext, t.homePic, iv_home)
        GlideUtils.loadImg(mContext, t.guestPic, iv_visit)
        tv_time.text = t.matchResult
        tv_home.text = t.homeName
        tv_visit.text = t.guestName
    }
}