package com.jnic.provide.jnicwest.ui.host.info

import android.support.v7.widget.LinearLayoutManager
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.adapter.AdapterInfoRace
import com.jnic.provide.jnicwest.base.BaseFragment
import com.jnic.provide.jnicwest.bean.Info_RaceBean
import com.jnic.provide.jnicwest.net.BaseCallback
import com.jnic.provide.jnicwest.net.WebList
import com.jnic.provide.jnicwest.util.GsonUtils
import com.jnic.provide.jnicwest.view.FloatingBarItemDecoration
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_xrecycler.*
import java.util.LinkedHashMap
import kotlin.collections.ArrayList

/**
 * Created by ${jaylm}
 * on 2018/1/15.
 */
class FragmentInfoRace : BaseFragment() {
    private var mHeaderList = LinkedHashMap<Int, String>()

    private var mDatas = ArrayList<Info_RaceBean.RaceBean.DatasBean>()
    private lateinit var mAdapter: AdapterInfoRace

    private var leagueId: Int = 0
    private var kind: Int = 0

    override fun bindLayout(): Int {
        return R.layout.activity_xrecycler
    }


    override fun initView() {
        super.initView()
        leagueId = arguments!!.getInt("leagueId")
        kind = arguments!!.getInt("kind")

        xRecyclerView.setHasFixedSize(true)
        xRecyclerView.setLoadingMoreEnabled(false)
        xRecyclerView.setPullRefreshEnabled(false)
        xRecyclerView.layoutManager = LinearLayoutManager(mActivity)
        xRecyclerView.addItemDecoration(FloatingBarItemDecoration(mHeaderList))

        mAdapter = AdapterInfoRace(mActivity, R.layout.item_info_saicheng, mDatas)
        xRecyclerView.adapter = mAdapter
    }

    override fun setListener() {
        super.setListener()
    }

    override fun setValue() {
        super.setValue()
        loadData()
    }

    fun loadData() {

        WebList.LeagueRace(leagueId, kind, object : BaseCallback(mActivity) {
            override fun onSuccess(response: Response<String>) {
                val data = GsonUtils.parseJsonWithGson(response.body(), Info_RaceBean::class.java)
                val mData = data.race

                var index = 0
                mData.forEachIndexed { i, raceBean ->
                    mHeaderList.put(index, raceBean.dayStr)
                    mDatas.addAll(mData[i].datas)
                    index += mData[i].datas.size
                }
                mAdapter.resetAdapter(mDatas)
            }

            override fun onSuccess(jsonString: String) {
            }

        })
    }

}