package com.jnic.provide.football.adapter

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.jnic.provide.football.R
import com.jnic.provide.football.base.BaseRecyclerAdapter
import com.jnic.provide.football.base.BaseRecyclerHolder
import com.jnic.provide.football.bean.JiaoQiu
import com.jnic.provide.football.util.glide.GlideUtils

/**
 * Created by ${jaylm}
 * on 2018/1/13.
 */
class AdapterJiaoQiu(context: Context, layoutId: Int, data: List<JiaoQiu.CornerBean>?) : BaseRecyclerAdapter<JiaoQiu.CornerBean>(context, layoutId, data) {
    override fun convert(holder: BaseRecyclerHolder, t: JiaoQiu.CornerBean) {
        val tv_name = holder.getView<TextView>(R.id.tv_name)
        val tv_date = holder.getView<TextView>(R.id.tv_date)

        val iv_logo_1 = holder.getView<ImageView>(R.id.iv_logo_1)
        val tv_name_1 = holder.getView<TextView>(R.id.tv_name_1)
        val tv_ban_1 = holder.getView<TextView>(R.id.tv_ban_1)
        val tv_quan_1 = holder.getView<TextView>(R.id.tv_quan_1)

        val iv_logo_2 = holder.getView<ImageView>(R.id.iv_logo_2)
        val tv_name_2 = holder.getView<TextView>(R.id.tv_name_2)
        val tv_ban_2 = holder.getView<TextView>(R.id.tv_ban_2)
        val tv_quan_2 = holder.getView<TextView>(R.id.tv_quan_2)


        val tv_ban_da_1 = holder.getView<TextView>(R.id.tv_ban_da_1)
        val tv_ban_chu_1 = holder.getView<TextView>(R.id.tv_ban_chu_1)
        val tv_ban_xiao_1 = holder.getView<TextView>(R.id.tv_ban_xiao_1)
        val tv_ban_da_2 = holder.getView<TextView>(R.id.tv_ban_da_2)
        val tv_ban_ji_2 = holder.getView<TextView>(R.id.tv_ban_ji_2)
        val tv_ban_xiao_2 = holder.getView<TextView>(R.id.tv_ban_xiao_2)

        val tv_quan_da_1 = holder.getView<TextView>(R.id.tv_quan_da_1)
        val tv_quan_chu_1 = holder.getView<TextView>(R.id.tv_quan_chu_1)
        val tv_quan_xiao_1 = holder.getView<TextView>(R.id.tv_quan_xiao_1)
        val tv_quan_da_2 = holder.getView<TextView>(R.id.tv_quan_da_2)
        val tv_quan_ji_2 = holder.getView<TextView>(R.id.tv_quan_ji_2)
        val tv_quan_xiao_2 = holder.getView<TextView>(R.id.tv_quan_xiao_2)


        val od = t.od//全场
        val tod = t.hod//半场

        tv_ban_da_1.text = tod.cpUpOdd.toString()
        tv_ban_chu_1.text = tod.cpOdd.toString()
        tv_ban_xiao_1.text = tod.cpDownOdd.toString()
        tv_ban_da_2.text = tod.higher.toString()
        tv_ban_ji_2.text = tod.jsOdd.toString()
        tv_ban_xiao_2.text = tod.below.toString()

        tv_quan_da_1.text = od.cpUpOdd.toString()
        tv_quan_chu_1.text = od.cpOdd.toString()
        tv_quan_xiao_1.text = od.cpDownOdd.toString()
        tv_quan_da_2.text = od.higher.toString()
        tv_quan_ji_2.text = od.jsOdd.toString()
        tv_quan_xiao_2.text = od.below.toString()


        val info = t.cornerMatchInfo
        GlideUtils.loadImg(mContext, info.hpic, iv_logo_1)
        tv_name_1.text = info.htn
        tv_ban_1.text = info.hhc.toString()
        tv_quan_1.text = info.hc.toString()

        GlideUtils.loadImg(mContext, info.gpic, iv_logo_2)
        tv_name_2.text = info.gtn
        tv_ban_2.text = info.ghc.toString()
        tv_quan_2.text = info.gc.toString()

        tv_name.text = info.rname
        tv_date.text = info.date + "  " + info.time
    }

}