package com.jnic.provide.jnicwest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.bean.Info_ScoreBean
import org.jetbrains.anko.find
import org.jetbrains.annotations.NotNull


@Suppress("DEPRECATION", "INACCESSIBLE_TYPE")
/**
 * Created by ${jaylm}
 * on 2017/12/13.
 */
class AdapterInfoScore(@NotNull var mContext: Context, val datas: ArrayList<Info_ScoreBean.RankingObjBean.AllBean>?,
                       @NotNull var mExpandableItemAdapter: RecyclerViewExpandableItemManager) :
        AbstractExpandableItemAdapter<AdapterInfoScore.MyGroupHolder, AdapterInfoScore.MyChildHolder>() {

    private val TYPE_TITLE = R.layout.item_info_score_title
    private val TYPE_CHILD = R.layout.item_info_score_child
    private var mDatas: ArrayList<Info_ScoreBean.RankingObjBean.AllBean>

    init {
        if (datas == null) {
            mDatas = ArrayList<Info_ScoreBean.RankingObjBean.AllBean>()
        } else {
            mDatas = datas
        }
        setHasStableIds(true)
    }

    fun resetAdapter(data: ArrayList<Info_ScoreBean.RankingObjBean.AllBean>) {
        this.mDatas = data
        notifyDataSetChanged()
    }


    override fun getChildItemViewType(groupPosition: Int, childPosition: Int): Int {
        if (childPosition == 0) {
            return TYPE_TITLE
        } else {
            return TYPE_CHILD
        }
    }

    override fun getGroupCount(): Int {
        if (mDatas.isEmpty()) {
            return 0
        }
        return mDatas.size
    }

    override fun getChildCount(groupPosition: Int): Int {
        if (mDatas.isEmpty()) {
            return 0
        }
        return mDatas[groupPosition].list.size + 1
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return groupPosition.xor(childPosition).toLong()
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): MyGroupHolder {
        return MyGroupHolder(LayoutInflater.from(mContext).inflate(R.layout.item_info_score_group, parent, false))
    }

    override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): MyChildHolder {

        return MyChildHolder(LayoutInflater.from(mContext).inflate(viewType, parent, false), viewType)
    }

    override fun onBindGroupViewHolder(holder: MyGroupHolder?, groupPosition: Int, viewType: Int) {
        holder!!.bindData(groupPosition)
    }

    override fun onBindChildViewHolder(holder: MyChildHolder?, groupPosition: Int, childPosition: Int, viewType: Int) {
        holder!!.bindData(groupPosition, childPosition, viewType)
    }

    override fun onCheckCanExpandOrCollapseGroup(holder: MyGroupHolder?, groupPosition: Int, x: Int, y: Int, expand: Boolean): Boolean {
//        if (!holder!!.itemView.isEnabled || !holder.itemView.isClickable) return false
        return true
    }

    inner class MyGroupHolder(itemView: View) : AbstractExpandableItemViewHolder(itemView) {
        init {
            initView()
        }

        private lateinit var tv_name: TextView

        fun initView() {
            tv_name = itemView.findViewById(R.id.tv_name)
        }

        fun bindData(position: Int) {
            tv_name.text = mDatas[position].group
        }

    }

    inner class MyChildHolder(itemView: View, val mType: Int) : AbstractExpandableItemViewHolder(itemView) {

        //        @BindView(R.id.tv_rank)
        lateinit var tv_rank: TextView

        //        @BindView(R.id.tv_name)
        lateinit var tv_name: TextView
        //        @BindView(R.id.tv_yisai)
        lateinit var tv_yisai: TextView
        //        @BindView(R.id.tv_s_p_f)
        lateinit var tv_s_p_f: TextView

        //        @BindView(R.id.tv_d_s)
        lateinit var tv_d_s: TextView
        //        @BindView(R.id.tv_j_s)
        lateinit var tv_j_s: TextView
        //        @BindView(R.id.tv_score)
        lateinit var tv_score: TextView


        init {
            initView()
        }

        fun initView() {
            if (mType == TYPE_CHILD) {
                tv_rank = itemView.find(R.id.tv_rank)
                tv_name = itemView.find(R.id.tv_name)
                tv_yisai = itemView.find(R.id.tv_yisai)
                tv_s_p_f = itemView.find(R.id.tv_s_p_f)
                tv_d_s = itemView.find(R.id.tv_d_s)
                tv_j_s = itemView.find(R.id.tv_j_s)
                tv_score = itemView.find(R.id.tv_score)
            }
        }

        fun bindData(groupPosition: Int, childPosition: Int, viewType: Int) {
            if (viewType == TYPE_CHILD) {
                val cPosition = childPosition - 1
                val data = mDatas[groupPosition].list[cPosition]

                tv_rank.text = data.rank.toString()
                tv_name.text = data.name
                tv_yisai.text = data.round.toString()
                tv_s_p_f.text = data.win.toString() + "/" + data.equ + "/" + data.fail
                tv_d_s.text = data.goal.toString() + "/" + data.loss
                tv_j_s.text = data.abs.toString()
                tv_score.text = data.score.toString()
            }
        }
    }

}