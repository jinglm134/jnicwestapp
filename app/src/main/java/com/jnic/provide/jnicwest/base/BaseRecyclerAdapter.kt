package com.jnic.provide.jnicwest.base

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Created by ${jaylm}
 * on 2017/12/31.
 */
abstract class BaseRecyclerAdapter<T>(var mContext: Context, @LayoutRes private var mLayoutId: Int, datas: List<T>?) : RecyclerView.Adapter<BaseRecyclerHolder>(), View.OnClickListener {

    private var mListener: OnItemClickListener<T>? = null
    protected var mDatas: ArrayList<T>
    protected var onSelectedPosition: Int = 0

    init {
        if (datas == null) {
            this.mDatas = ArrayList()
        } else {
            this.mDatas = datas as ArrayList<T>
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerHolder {
        val holder = BaseRecyclerHolder.init(mContext, parent, mLayoutId)
        holder.getConvertView().setOnClickListener(this)
        return holder
    }

    override fun onBindViewHolder(holder: BaseRecyclerHolder?, position: Int) {
        holder!!.getConvertView().tag = position
        convert(holder, mDatas[position], position)
    }

    override fun onBindViewHolder(holder: BaseRecyclerHolder?, position: Int, payloads: MutableList<Any>?) {

        if (payloads == null || payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            holder!!.getConvertView().tag = position
            convertItemChange(holder, mDatas[position], payloads)
        }
    }

    override fun getItemCount(): Int {
        if (mDatas.isEmpty()) {
            return 0
        }
        return mDatas.size
    }

    open fun resetAdapter(datas: List<T>) {
        mDatas = datas as ArrayList<T>
        notifyDataSetChanged()
    }

    abstract fun convert(holder: BaseRecyclerHolder, t: T)
    open fun convert(holder: BaseRecyclerHolder, t: T, index: Int) {
        convert(holder, t)
    }

    /*when item changed must be override*/
    open fun convertItemChange(holder: BaseRecyclerHolder, t: T, payloads: MutableList<Any>) {}


    override fun onClick(p0: View) {
        onSelectedPosition = p0.tag as Int
        if (mListener != null) {
            mListener!!.onItemClick(mDatas[onSelectedPosition], onSelectedPosition)
        }
    }

    interface OnItemClickListener<in T> {
        fun onItemClick(data: T, position: Int)
    }

    fun setOnItemClickListener(mListener: OnItemClickListener<T>) {
        this.mListener = mListener
    }

}