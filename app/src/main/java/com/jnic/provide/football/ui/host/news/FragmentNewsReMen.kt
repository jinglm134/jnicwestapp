package com.jnic.provide.football.ui.host.news

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.jnic.provide.football.R
import com.jnic.provide.football.adapter.AdapterReMen
import com.jnic.provide.football.base.BaseFragment
import com.jnic.provide.football.base.BaseRecyclerAdapter
import com.jnic.provide.football.bean.ReMenBean
import com.jnic.provide.football.constant.API
import com.jnic.provide.football.net.BaseCallback
import com.jnic.provide.football.net.WebList
import com.jnic.provide.football.ui.main.ActivityWebView
import com.jnic.provide.football.util.GsonUtils
import com.jnic.provide.football.util.SnackbarUtils
import com.jnic.provide.football.view.FloatingBarItemDecoration
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_xrecycler.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by ${jaylm}
 * on 2018/1/15.
 */
class FragmentNewsReMen : BaseFragment() {
    private var mHeaderList = LinkedHashMap<Int, String>()
    private var data: ReMenBean? = null
    private var mData = ArrayList<ReMenBean.ContentsBean.ArticlesBean>()
    private var mContent = ArrayList<ReMenBean.ContentsBean>()
    private lateinit var mAdapter: AdapterReMen


    override fun bindLayout(): Int {
        return R.layout.activity_xrecycler
    }

    override fun initView() {
        super.initView()
        xRecyclerView.setHasFixedSize(true)
        xRecyclerView.layoutManager = LinearLayoutManager(mActivity)
        xRecyclerView.addItemDecoration(FloatingBarItemDecoration(mHeaderList))

        mAdapter = AdapterReMen(mActivity, R.layout.item_remen, mData)
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

        mAdapter.setOnItemClickListener(object : BaseRecyclerAdapter.OnItemClickListener<ReMenBean.ContentsBean.ArticlesBean> {
            override fun onItemClick(data: ReMenBean.ContentsBean.ArticlesBean, position: Int) {
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
                bundle.putString("title", "详情")

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
            url = API.REMEN
        }

        WebList.base(url, object : BaseCallback(mActivity, xRecyclerView, isPullDown) {
            override fun onSuccess(response: Response<String>) {
                data = GsonUtils.parseJsonWithGson(response.body(), ReMenBean::class.java)
                mData.clear()
                if (isPullDown) {
                    mContent.clear()
                    mHeaderList.clear()
                }

                mContent.addAll(data!!.contents)
                var index: Int = 0
                var day: String = ""
                mContent.forEach { content ->
                    if (day != content.day) {
                        day = content.day
                        mHeaderList.put(index, day)
                    }
                    mData.addAll(content.articles)

                    index += content.articles.size
                }

                mAdapter.resetAdapter(mData)
            }

            override fun onSuccess(jsonString: String) {
            }

        })
    }

    /*  fun initHeaderList() {

          *//*排序*//*
        Collections.sort<ReMenBean.ContentsBean>(mContent) { o1, o2 ->
            */
    /**
     * 如果o1小于o2,返回一个负数;如果o1大于o2，返回一个正数;如果他们相等，则返回0;
     */
    /*
                val py1 = o1.day
                val py2 = o2.day
                py1.compareTo(py2)
            }

            mHeaderList.clear()
            if (mContent.size == 0) {
                return
            }
            for (i in 0..mContent.size - 1) {

                mHeaderList.put(i, mContent[i].day)
            }
        }*/
}