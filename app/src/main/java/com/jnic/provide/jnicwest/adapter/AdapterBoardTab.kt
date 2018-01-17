package com.jnic.provide.jnicwest.adapter

import android.content.Context
import android.widget.RelativeLayout
import android.widget.TextView
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.base.BaseRecyclerAdapter
import com.jnic.provide.jnicwest.base.BaseRecyclerHolder
import com.jnic.provide.jnicwest.bean.BoardTypeBean

/**
 * Created by ${jaylm}
 * on 2018/1/16.
 */
class AdapterBoardTab(context: Context, layoutId: Int, data: ArrayList<BoardTypeBean.ContentBean.DataBean>) : BaseRecyclerAdapter<BoardTypeBean.ContentBean.DataBean>(context, layoutId, data) {
    override fun convert(holder: BaseRecyclerHolder, t: BoardTypeBean.ContentBean.DataBean) {

    }

    override fun convert(holder: BaseRecyclerHolder, t: BoardTypeBean.ContentBean.DataBean, index: Int) {
        super.convert(holder, t, index)

        val tv_tab = holder.getView<TextView>(R.id.tv_tab)
        val rl_tab = holder.getView<RelativeLayout>(R.id.rl_tab)
        tv_tab.text = t.name
        if (index == onSelectedPosition) {
            rl_tab.setBackgroundResource(R.color.c2)
        } else {
            rl_tab.setBackgroundResource(R.color.c6)
        }
    }

    fun resetAdapter(datas: List<BoardTypeBean.ContentBean.DataBean>, selected: Int) {
        onSelectedPosition = selected
        super.resetAdapter(datas)
    }
}