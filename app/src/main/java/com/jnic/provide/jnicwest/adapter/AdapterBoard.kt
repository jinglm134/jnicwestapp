package com.jnic.provide.jnicwest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.bean.BoardDataBean
import com.jnic.provide.jnicwest.util.glide.GlideUtils
import de.hdodenhof.circleimageview.CircleImageView

@Suppress("DEPRECATION")
/**
 * Created by ${jaylm}
 * on 2017/12/10.
 */

class AdapterBoard(private val mContext: Context, datas: ArrayList<BoardDataBean.ContentBean.DataBean>?, var mType: Int) : RecyclerView.Adapter<AdapterBoard.MyViewHolder>() {


    private var VIEW_TYPE_TITLE: Int = 0
    private var VIEW_TYPE_ITEM: Int = 0
    private var mDatas: ArrayList<BoardDataBean.ContentBean.DataBean>

    init {
        if (datas == null) {
            mDatas = ArrayList<BoardDataBean.ContentBean.DataBean>()
        } else {
            mDatas = datas
        }
        initLayout()
    }

    fun initLayout() {
        if (mType == 1) {
            VIEW_TYPE_TITLE = R.layout.item_board_title
            VIEW_TYPE_ITEM = R.layout.item_board_item
        } else {
            VIEW_TYPE_TITLE = R.layout.item_board_title2
            VIEW_TYPE_ITEM = R.layout.item_board_item2
        }
    }

    fun resetAdapter(datas: ArrayList<BoardDataBean.ContentBean.DataBean>, type: Int) {
        this.mDatas = datas
        mType = type
        initLayout()
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
        private lateinit var circleImageView: CircleImageView
        private lateinit var tv_person: TextView
        private lateinit var tv_team: TextView
        private lateinit var tv_total: TextView

        private lateinit var tv_rank_2: TextView
        private lateinit var circleImageView_2: CircleImageView
        private lateinit var tv_person_2: TextView
        private lateinit var tv_total_2: TextView

        init {
            initView(itemView)
        }

        private fun initView(view: View) {
            if (mViewType == VIEW_TYPE_ITEM) {

                if (mType == 1) {
                    /*球员*/
                    tv_rank = view.findViewById(R.id.tv_rank)
                    circleImageView = view.findViewById(R.id.circleImageView)
                    tv_person = view.findViewById(R.id.tv_person)
                    tv_team = view.findViewById(R.id.tv_team)
                    tv_total = view.findViewById(R.id.tv_total)

                } else {
                    /*球队*/

                    tv_rank_2 = view.findViewById(R.id.tv_rank_2)
                    circleImageView_2 = view.findViewById(R.id.circleImageView_2)
                    tv_person_2 = view.findViewById(R.id.tv_person_2)
                    tv_total_2 = view.findViewById(R.id.tv_total_2)
                }
            }
        }

        fun bindView(sPosition: Int) {
            if (mViewType == VIEW_TYPE_ITEM) {
                val data = mDatas[sPosition - 1]

                if (mType == 1) {
                    tv_rank.text = data.rank
                    tv_person.text = data.person_name
                    tv_total.text = data.count
                    tv_team.text = data.team_name
                    GlideUtils.loadImg(mContext, data.person_logo, circleImageView)
                } else {
                    tv_rank_2.text = data.rank
                    tv_person_2.text = data.team_name
                    tv_total_2.text = data.count
                    GlideUtils.loadImg(mContext, data.team_logo, circleImageView_2)
                }

            }
        }
    }

}
