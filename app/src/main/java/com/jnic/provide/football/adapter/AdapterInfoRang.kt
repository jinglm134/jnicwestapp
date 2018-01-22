package com.jnic.provide.football.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jnic.provide.football.R
import com.jnic.provide.football.bean.InfoRangBean

@Suppress("DEPRECATION")
/**
 * Created by ${jaylm}
 * on 2017/12/10.
 */

class AdapterInfoRang(private val mContext: Context, datas: ArrayList<InfoRangBean.HomeBean>?, val type: Int) : RecyclerView.Adapter<AdapterInfoRang.MyViewHolder>() {

    private val VIEW_TYPE_TITLE: Int
    private val VIEW_TYPE_ITEM = R.layout.item_info_rang
    private var mDatas: ArrayList<InfoRangBean.HomeBean>

    init {
        if (type == 1) {
            VIEW_TYPE_TITLE = R.layout.item_info_rang_title
        } else {
            VIEW_TYPE_TITLE = R.layout.item_info_daxiao_title
        }

        if (datas == null) {
            mDatas = ArrayList<InfoRangBean.HomeBean>()
        } else {
            mDatas = datas
        }
    }

    fun resetAdapter(datas: ArrayList<InfoRangBean.HomeBean>) {
        this.mDatas = datas
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(viewType, parent, false)

        return MyViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_TITLE else VIEW_TYPE_ITEM
    }

    override fun getItemCount(): Int {
        if (mDatas.isEmpty()) {
            return 0
        }
        return mDatas.size + 1
    }

    inner class MyViewHolder(itemView: View, private val mViewType: Int) : RecyclerView.ViewHolder(itemView) {

        private lateinit var tv_rank: TextView
        private lateinit var tv_name: TextView
        private lateinit var tv_yisai: TextView
        private lateinit var tv_y_z_s: TextView
        private lateinit var tv_y: TextView
        private lateinit var tv_z: TextView
        private lateinit var tv_s: TextView


        init {
            initView(itemView)
        }

        private fun initView(view: View) {
            if (mViewType == VIEW_TYPE_ITEM) {
                tv_rank = view.findViewById(R.id.tv_rank)
                tv_name = view.findViewById(R.id.tv_name)
                tv_yisai = view.findViewById(R.id.tv_yisai)
                tv_y_z_s = view.findViewById(R.id.tv_y_z_s)
                tv_y = view.findViewById(R.id.tv_y)
                tv_z = view.findViewById(R.id.tv_z)
                tv_s = view.findViewById(R.id.tv_s)
            }
        }

        fun bindView(sPosition: Int) {
            if (mViewType == VIEW_TYPE_ITEM) {
                val data = mDatas[sPosition - 1]
                tv_rank.text = data.rank.toString()
                tv_name.text = data.teamName
                tv_yisai.text = data.matchCount
                tv_y_z_s.text = data.left + "/" + data.midd + "/" + data.right
                tv_y.text = data.lvg
                tv_z.text = data.mvg
                tv_s.text = data.rvg
            }
        }
    }

}
