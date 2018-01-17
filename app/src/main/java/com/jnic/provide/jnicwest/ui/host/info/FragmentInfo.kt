package com.jnic.provide.jnicwest.ui.host.info

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.adapter.AdapterInfo
import com.jnic.provide.jnicwest.base.BaseFragment
import com.jnic.provide.jnicwest.base.BaseRecyclerAdapter
import com.jnic.provide.jnicwest.bean.InfoBean
import com.jnic.provide.jnicwest.constant.API
import com.jnic.provide.jnicwest.net.BaseCallback
import com.jnic.provide.jnicwest.net.WebList
import com.jnic.provide.jnicwest.util.GsonUtils
import com.jnic.provide.jnicwest.view.DividerLinearItemDecoration
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_xrecycler.*

/**
 * Created by ${jaylm}
 * on 2018/1/16.
 */
class FragmentInfo : BaseFragment() {

    private lateinit var mAdapter: AdapterInfo
    private var mDatas = ArrayList<InfoBean.InternationBean>()

    override fun bindLayout(): Int {
        return R.layout.activity_xrecycler
    }


    override fun initView() {
        super.initView()
        xRecyclerView.setHasFixedSize(true)
        xRecyclerView.setLoadingMoreEnabled(false)
        xRecyclerView.setPullRefreshEnabled(false)
        val layoutManager = GridLayoutManager(mActivity, 3)
        xRecyclerView.layoutManager = layoutManager
        xRecyclerView.addItemDecoration(DividerLinearItemDecoration())

        mAdapter = AdapterInfo(mActivity, R.layout.item_grid_info, mDatas)
        xRecyclerView.adapter = mAdapter
    }

    override fun setListener() {
        super.setListener()

        mAdapter.setOnItemClickListener(object : BaseRecyclerAdapter.OnItemClickListener<InfoBean.InternationBean> {
            override fun onItemClick(data: InfoBean.InternationBean, position: Int) {
                val bundle = Bundle()
                bundle.putInt("leagueId", data.leagueId)
                bundle.putString("leagueName", data.lgName)
                bundle.putInt("kind", data.kind)
                mActivity.startActivity(ActivityInfo::class.java, bundle)
            }
        })
    }

    override fun setValue() {
        super.setValue()
        loadData()
    }

    fun loadData() {
        WebList.base(API.DataMenu, object : BaseCallback(mActivity) {
            override fun onSuccess(response: Response<String>) {
                val data = GsonUtils.parseJsonWithGson(response.body(), InfoBean::class.java)
                mDatas.addAll(data.internation)

                mAdapter.resetAdapter(mDatas)
            }

            override fun onSuccess(jsonString: String) {
            }

        })
    }
}