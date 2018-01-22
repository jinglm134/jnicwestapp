package com.jnic.provide.football.ui.host.info

import android.support.v7.widget.LinearLayoutManager
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager
import com.jnic.provide.football.R
import com.jnic.provide.football.adapter.AdapterInfoScore
import com.jnic.provide.football.base.BaseFragment
import com.jnic.provide.football.bean.Info_ScoreBean
import com.jnic.provide.football.net.BaseCallback
import com.jnic.provide.football.net.WebList
import com.jnic.provide.football.util.GsonUtils
import com.jnic.provide.football.view.DividerLinearItemDecoration
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_xrecycler.*

/**
 * Created by ${jaylm}
 * on 2018/1/15.
 */
class FragmentInfoScore : BaseFragment() {

    private lateinit var data: Info_ScoreBean
    private var mData = ArrayList<Info_ScoreBean.RankingObjBean.AllBean>()
    private lateinit var mAdapter: AdapterInfoScore

    private var leagueId: Int = 0
    private var kind: Int = 0

    override fun bindLayout(): Int {
        return R.layout.activity_xrecycler
    }


    override fun initView() {
        super.initView()
        leagueId = arguments!!.getInt("leagueId")
        kind = arguments!!.getInt("kind")


    }

    private fun initRecyclerView() {
        val mLayoutManager = LinearLayoutManager(mActivity)
        val mRecyclerViewExpandableItemManager = RecyclerViewExpandableItemManager(null)

        mAdapter = AdapterInfoScore(mActivity, mData, mRecyclerViewExpandableItemManager)
        val mWrappedAdapter = mRecyclerViewExpandableItemManager.createWrappedAdapter(mAdapter)

        xRecyclerView.setHasFixedSize(true)
        xRecyclerView.setLoadingMoreEnabled(false)
        xRecyclerView.setPullRefreshEnabled(false)
        xRecyclerView.layoutManager = mLayoutManager
        xRecyclerView.adapter = mWrappedAdapter
        xRecyclerView.addItemDecoration(DividerLinearItemDecoration())

        mRecyclerViewExpandableItemManager.attachRecyclerView(xRecyclerView)

        mData.forEachIndexed { index, _ ->
            mRecyclerViewExpandableItemManager.expandGroup(index)
        }

    }

    override fun setListener() {
        super.setListener()
    }

    override fun setValue() {
        super.setValue()
        loadData()
    }

    fun loadData() {

        WebList.LeagueScore(leagueId, kind, object : BaseCallback(mActivity) {
            override fun onSuccess(response: Response<String>) {
                data = GsonUtils.parseJsonWithGson(response.body(), Info_ScoreBean::class.java)

                mData.addAll(data.rankingObj.all)
                initRecyclerView()
//                mAdapter.resetAdapter(mData)
            }

            override fun onSuccess(jsonString: String) {
            }

        })
    }

}