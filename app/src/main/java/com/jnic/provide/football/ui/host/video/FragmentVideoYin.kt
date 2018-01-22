package com.jnic.provide.football.ui.host.video

import android.support.v7.widget.LinearLayoutManager
import com.jnic.provide.football.adapter.AdapterVideo
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.jnic.provide.football.R
import com.jnic.provide.football.base.BaseFragment
import com.jnic.provide.football.base.BaseRecyclerAdapter
import com.jnic.provide.football.bean.VideoBean
import com.jnic.provide.football.constant.API
import com.jnic.provide.football.net.BaseCallback
import com.jnic.provide.football.net.WebList
import com.jnic.provide.football.util.GsonUtils
import com.jnic.provide.football.view.SpaceLinearItemDecoration
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_xrecycler.*

/**
 * Created by ${jaylm}
 * on 2018/1/15.
 */
class FragmentVideoYin : BaseFragment() {
    private var data: VideoBean? = null
    private val mDatas = ArrayList<VideoBean.ResultBean.DataBean>()
    private lateinit var mAdapter: AdapterVideo
    override fun bindLayout(): Int {
        return R.layout.activity_xrecycler
    }

    override fun initView() {
        super.initView()
        xRecyclerView.setHasFixedSize(true)
        xRecyclerView.layoutManager = LinearLayoutManager(mActivity)
        xRecyclerView.addItemDecoration(SpaceLinearItemDecoration())

        mAdapter = AdapterVideo(mActivity, R.layout.item_remen, mDatas)
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

        mAdapter.setOnItemClickListener(object : BaseRecyclerAdapter.OnItemClickListener<VideoBean.ResultBean.DataBean> {
            override fun onItemClick(data: VideoBean.ResultBean.DataBean, position: Int) {
               /* val url: String
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

                mActivity.startActivity(ActivityWebView::class.java, bundle)*/
            }

        })
    }

    override fun setValue() {
        super.setValue()
        xRecyclerView.refresh()
    }

    fun loadData(isPullDown: Boolean) {

        var url: String = API.VO_YINGCHAO + "&crt=" + System.currentTimeMillis()
        if (data != null) {
            if (!isPullDown) {
                url += "&direc=next" + "vid=" + mDatas[mDatas.size - 1].vid
            }else{

            }
        }

        WebList.base(url, object : BaseCallback(mActivity, xRecyclerView, isPullDown) {
            override fun onSuccess(response: Response<String>) {
                data = GsonUtils.parseJsonWithGson(response.body(), VideoBean::class.java)

                if (isPullDown) {
                    mDatas.clear()
                }

                mDatas.addAll(data!!.result.data)
                mAdapter.resetAdapter(mDatas)
            }

            override fun onSuccess(jsonString: String) {
            }

        })
    }
}