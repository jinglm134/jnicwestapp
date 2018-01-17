package com.jnic.provide.jnicwest.ui.host.jiao

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jnic.provide.jnicwest.adapter.AdapterJiaoQiu
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.base.BaseFragment
import com.jnic.provide.jnicwest.bean.JiaoQiu
import com.jnic.provide.jnicwest.net.BaseCallback
import com.jnic.provide.jnicwest.net.WebList
import com.jnic.provide.jnicwest.util.GsonUtils
import com.jnic.provide.jnicwest.view.ActionSheet
import com.jnic.provide.jnicwest.view.SpaceLinearItemDecoration
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.fragment_jiaoqu.*

/**
 * Created by ${jaylm}
 * on 2018/1/13.
 */
class FragmentJiaoQiu : BaseFragment(), View.OnClickListener {
    private val mData = ArrayList<JiaoQiu.CornerBean>()
    private lateinit var mAdapter: AdapterJiaoQiu

    private val RILI = arrayOf(/*"2018-01-08", "2018-01-09", */"2018-01-10", "2018-01-11", "2018-01-12", "2018-01-13", "2018-01-14"/*, "2018-01-15"*/, "2018-01-16"/*, "2018-01-17"*/)
    private var mCurrentPosition = RILI.size - 1
    private val mCurrentDate = RILI[mCurrentPosition]
    override fun bindLayout(): Int {
        return R.layout.fragment_jiaoqu
    }

    override fun initView() {
        super.initView()

        tv_rili.text = mCurrentDate
        xRecyclerView.setHasFixedSize(true)
        xRecyclerView.setLoadingMoreEnabled(false)
        xRecyclerView.layoutManager = LinearLayoutManager(mActivity)
        xRecyclerView.addItemDecoration(SpaceLinearItemDecoration())

        mAdapter = AdapterJiaoQiu(mActivity, R.layout.item_jiaoqiu, mData)
        xRecyclerView.adapter = mAdapter
    }

    override fun setListener() {
        super.setListener()
        rl_rili.setOnClickListener(this)
        rl_left.setOnClickListener(this)
        rl_right.setOnClickListener(this)
        xRecyclerView.setLoadingListener(object : XRecyclerView.LoadingListener {
            override fun onRefresh() {
                loadData()
            }

            override fun onLoadMore() {
            }

        })
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.rl_left -> {
                if (mCurrentPosition > 0) {
                    mCurrentPosition -= 1
                    refresh()
                    xRecyclerView.refresh()
                }
            }

            R.id.rl_right -> {
                if (mCurrentPosition < RILI.size - 1) {
                    mCurrentPosition += 1
                    refresh()
                    xRecyclerView.refresh()
                }
            }
            R.id.rl_rili -> {
                ActionSheet.defaultActionSheet(mActivity, "选择", RILI, object : ActionSheet.OnContentSheetSelected() {
                    override fun onClickContentSheet(v: View?, index: Int) {
                        mCurrentPosition = index - 1
                        refresh()
                        xRecyclerView.refresh()
                    }

                }).show()
            }
        }
    }

    fun refresh() {
        tv_rili.text = RILI[mCurrentPosition]
        if (mCurrentPosition > 0) {
            rl_left.visibility = View.VISIBLE
        } else {
            rl_left.visibility = View.GONE
        }

        if (mCurrentPosition < RILI.size - 1) {
            rl_right.visibility = View.VISIBLE
        } else {
            rl_right.visibility = View.GONE
        }
    }

    override fun setValue() {
        super.setValue()
        xRecyclerView.refresh()
    }

    fun loadData(isPullDown: Boolean = true) {
        WebList.jiaoqiu(RILI[mCurrentPosition], object : BaseCallback(mActivity, xRecyclerView, isPullDown) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
                val jsonString = response.body()
                val data = GsonUtils.parseJsonWithGson(jsonString, JiaoQiu::class.java)
                if (isPullDown) {
                    mData.clear()
                }
                mData.addAll(data.corner)
                mAdapter.resetAdapter(mData)
            }
        })
    }
}