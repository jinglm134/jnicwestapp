package com.jnic.provide.jnicwest.ui.host.news

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.adapter.AdapterZhuanHui
import com.jnic.provide.jnicwest.base.BaseFragment
import com.jnic.provide.jnicwest.base.BaseRecyclerAdapter
import com.jnic.provide.jnicwest.bean.ZhuanHuiBean
import com.jnic.provide.jnicwest.net.BaseCallback
import com.jnic.provide.jnicwest.net.WebList
import com.jnic.provide.jnicwest.ui.main.ActivityWebView
import com.jnic.provide.jnicwest.util.GsonUtils
import com.jnic.provide.jnicwest.util.SnackbarUtils
import com.jnic.provide.jnicwest.view.SpaceLinearItemDecoration
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_xrecycler.*

/**
 * Created by ${jaylm}
 * on 2018/1/15.
 */
class FragmentNewsZhuanHui : BaseFragment() {
    private var data: ZhuanHuiBean? = null
    private var mData = ArrayList<ZhuanHuiBean.ArticlesBean>()
    private lateinit var mAdapter: AdapterZhuanHui

    private lateinit var api: String

    override fun bindLayout(): Int {
        return R.layout.activity_xrecycler
    }


    override fun initView() {
        super.initView()
        api = arguments!!.getString("api")


        xRecyclerView.setHasFixedSize(true)
        xRecyclerView.layoutManager = LinearLayoutManager(mActivity)
        xRecyclerView.addItemDecoration(SpaceLinearItemDecoration())

        mAdapter = AdapterZhuanHui(mActivity, R.layout.item_remen, mData)
        xRecyclerView.adapter = mAdapter
    }

    override fun setListener() {
        super.setListener()
        xRecyclerView.setLoadingListener(object : XRecyclerView.LoadingListener {
            override fun onRefresh() {
                loadData(true)
            }

            override fun onLoadMore() {
                loadData(false)
            }

        })

        mAdapter.setOnItemClickListener(object : BaseRecyclerAdapter.OnItemClickListener<ZhuanHuiBean.ArticlesBean> {
            override fun onItemClick(data: ZhuanHuiBean.ArticlesBean, position: Int) {
                val url: String
                if (!TextUtils.isEmpty(data.url)) {
                    url = data.url
                } else {
                    if (!TextUtils.isEmpty(data.share)) {
                        url = data.share
                    } else {
                        SnackbarUtils.showSnackbar(mActivity.mContentView, "出错啦..清稍后再试")
                        return
                    }
                }

                val bundle = Bundle()
                bundle.putString("url", url)
                bundle.putString("title", data.title)

                mActivity.startActivity(ActivityWebView::class.java, bundle)
            }

        })
    }

    override fun setValue() {
        super.setValue()
        xRecyclerView.refresh()
    }

    fun loadData(isPullDown: Boolean) {

        val url: String
        if (data != null) {
            if (isPullDown) {
                url = data!!.fresh
            } else {
                url = data!!.next
            }

        } else {
            url = api
        }

        WebList.base(url, object : BaseCallback(mActivity, xRecyclerView, isPullDown) {
            override fun onSuccess(response: Response<String>) {
                data = GsonUtils.parseJsonWithGson(response.body(), ZhuanHuiBean::class.java)

                if (isPullDown) {
                    mData.clear()
                }

                mData.addAll(data!!.articles)
                mAdapter.resetAdapter(mData)
            }

            override fun onSuccess(jsonString: String) {
            }

        })
    }

}