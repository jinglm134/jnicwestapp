package com.jnic.provide.jnicwest.adapter

import android.content.Context
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
        val tv_tab = holder.getView<TextView>(R.id.tv_tab)
        tv_tab.text = t.name
    }
}