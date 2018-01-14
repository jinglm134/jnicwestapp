package com.jnic.provide.jnicwest.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by ${jaylm}
 * on 2017/12/31.
 */
class BaseRecyclerHolder(var mConvertView: View) : RecyclerView.ViewHolder(mConvertView) {

    private var mViews: SparseArray<View> = SparseArray()
    private lateinit var mContext: Context


    private constructor(context: Context, itemView: View) : this(itemView) {
        mContext = context
    }

    fun getConvertView(): View {
        return mConvertView
    }

    companion object {
        fun init(context: Context, parent: ViewGroup, layoutId: Int): BaseRecyclerHolder {
            val itemView = LayoutInflater.from(context).inflate(layoutId, parent, false)
            return BaseRecyclerHolder(context, itemView)
        }
    }


    /**
     * 通过viewId获取控件

     * @param viewId viewId
     * *
     * @return View
     */
    fun <T : View> getView(viewId: Int): T {
        var view: View? = mViews.get(viewId)
        if (view == null) {
            view = mConvertView.findViewById<View>(viewId)
            mViews.put(viewId, view)
        }

        return view as T
    }

    fun setOnClickListener(viewId: Int, listener: View.OnClickListener): BaseRecyclerHolder {
        val view = getView<View>(viewId)
        view.setOnClickListener(listener)
        return this
    }

    fun setOnLongClickListener(viewId: Int, listener: View.OnLongClickListener): BaseRecyclerHolder {
        val view = getView<View>(viewId)
        view.setOnLongClickListener(listener)
        return this
    }
}