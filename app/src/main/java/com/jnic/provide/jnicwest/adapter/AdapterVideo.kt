package com.jnic.provide.jnicwest.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.base.BaseRecyclerAdapter
import com.jnic.provide.jnicwest.base.BaseRecyclerHolder
import com.jnic.provide.jnicwest.bean.VideoBean
import com.jnic.provide.jnicwest.util.glide.GlideUtils

/**
 * Created by ${jaylm}
 * on 2018/1/13.
 */
class AdapterVideo(context: Context, layoutId: Int, data: List<VideoBean.ResultBean.DataBean>) : BaseRecyclerAdapter<VideoBean.ResultBean.DataBean>(context, layoutId, data) {
    override fun convert(holder: BaseRecyclerHolder, t: VideoBean.ResultBean.DataBean) {

        val iv_play = holder.getView<ImageView>(R.id.iv_play)
        iv_play.visibility = View.GONE

        val iv_cover = holder.getView<ImageView>(R.id.iv_cover)

        val tv_title = holder.getView<TextView>(R.id.tv_title)
        val tv_time = holder.getView<TextView>(R.id.tv_time)

        tv_title.text = t.title
        tv_time.text = t.playtime

        GlideUtils.loadImg(mContext, t.cover, iv_cover)
//        Glide.with(mContext)
//                .load(t.cover)
//                .into(object : GlideDrawableImageViewTarget(iv_cover) {
//
//                    override fun onResourceReady(resource: GlideDrawable, animation: GlideAnimation<in GlideDrawable>?) {
//                        super.onResourceReady(resource, animation)
//                        iv_play.visibility = View.VISIBLE
//                    }
//
//                })
    }
}