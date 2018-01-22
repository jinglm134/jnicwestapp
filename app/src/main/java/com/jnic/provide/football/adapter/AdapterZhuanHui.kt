package com.jnic.provide.football.adapter

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.jnic.provide.football.R
import com.jnic.provide.football.base.BaseRecyclerAdapter
import com.jnic.provide.football.base.BaseRecyclerHolder
import com.jnic.provide.football.bean.ZhuanHuiBean
import com.jnic.provide.football.util.glide.GlideUtils

/**
 * Created by ${jaylm}
 * on 2018/1/15.
 */
class AdapterZhuanHui(context: Context, layouId: Int, data: ArrayList<ZhuanHuiBean.ArticlesBean>) : BaseRecyclerAdapter<ZhuanHuiBean.ArticlesBean>(context, layouId, data) {
    override fun convert(holder: BaseRecyclerHolder, t: ZhuanHuiBean.ArticlesBean) {
        val iv_image = holder.getView<ImageView>(R.id.iv_image)
        val tv_name = holder.getView<TextView>(R.id.tv_name)
        val tv_content = holder.getView<TextView>(R.id.tv_content)
        val tv_discuss = holder.getView<TextView>(R.id.tv_discuss)
        val tv_time = holder.getView<TextView>(R.id.tv_time)

        GlideUtils.loadImg(mContext, t.thumb, iv_image)
        tv_name.text = t.title
        tv_content.text = t.description
        tv_discuss.text = t.comments_total.toString().plus("条评论")
        tv_time.text = t.published_at
    }
}