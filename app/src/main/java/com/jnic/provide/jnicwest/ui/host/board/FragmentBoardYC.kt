package com.jnic.provide.jnicwest.ui.host.board

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.adapter.AdapterBoard
import com.jnic.provide.jnicwest.adapter.AdapterBoardTab
import com.jnic.provide.jnicwest.base.BaseFragment
import com.jnic.provide.jnicwest.base.BaseRecyclerAdapter
import com.jnic.provide.jnicwest.bean.BoardDataBean
import com.jnic.provide.jnicwest.bean.BoardTypeBean
import com.jnic.provide.jnicwest.constant.API
import com.jnic.provide.jnicwest.net.BaseCallback
import com.jnic.provide.jnicwest.net.WebList
import com.jnic.provide.jnicwest.util.GsonUtils
import com.jnic.provide.jnicwest.view.DividerLinearItemDecoration
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.fragment_board_yc.*

/**
 * Created by ${jaylm}
 * on 2018/1/16.
 */
class FragmentBoardYC : BaseFragment(), View.OnClickListener {

    private var mTabData = ArrayList<BoardTypeBean.ContentBean.DataBean>()
    private var mData = ArrayList<BoardDataBean.ContentBean.DataBean>()
    private var mUrl = ""

    private lateinit var mTabAdapter: AdapterBoardTab
    private lateinit var mAdapter: AdapterBoard
    private var season_id = 9235
    private var type = "person"
    private var type_int = 1
    private var mViewP = ArrayList<TextView>()
    override fun bindLayout(): Int {
        return R.layout.fragment_board_yc
    }

    override fun initView() {
        super.initView()

//        season_id = arguments!!.getInt("season_id")

        initTextView()
        initRecyclerView()
    }

    fun initTextView() {
        mViewP.add(tv_person)
        mViewP.add(tv_team)
    }

    fun initRecyclerView() {
        xRecyclerView.setHasFixedSize(true)
        xRecyclerView.setLoadingMoreEnabled(false)
        xRecyclerView.setPullRefreshEnabled(false)
        xRecyclerView.layoutManager = LinearLayoutManager(mActivity)
        xRecyclerView.addItemDecoration(DividerLinearItemDecoration())
        mAdapter = AdapterBoard(mActivity, mData, type_int)
        xRecyclerView.adapter = mAdapter

        xRecyclerView_tab.setHasFixedSize(true)
        xRecyclerView_tab.setLoadingMoreEnabled(false)
        xRecyclerView_tab.setPullRefreshEnabled(false)
        xRecyclerView_tab.layoutManager = LinearLayoutManager(mActivity)
//        xRecyclerView_tab.addItemDecoration(DividerLinearItemDecoration(R.color.c14, 1))
        mTabAdapter = AdapterBoardTab(mActivity, R.layout.item_board_tab, mTabData)
        xRecyclerView_tab.adapter = mTabAdapter
    }

    override fun setListener() {
        super.setListener()
        tv_person.setOnClickListener(this)
        tv_team.setOnClickListener(this)

        mTabAdapter.setOnItemClickListener(object : BaseRecyclerAdapter.OnItemClickListener<BoardTypeBean.ContentBean.DataBean> {
            override fun onItemClick(data: BoardTypeBean.ContentBean.DataBean, position: Int) {
                mUrl = data.url
                loadData()
            }

        })
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tv_person -> {
                type = "person"
                type_int = 1
                loadTabData()

            }
            R.id.tv_team -> {
                type = "team"
                type_int = 2
                loadTabData()
            }
        }
    }

    override fun setValue() {
        super.setValue()
        loadTabData()
    }

    fun loadTabData() {
        val url = API.BOARD + "&season_id=" + season_id + "&type=" + type
        WebList.base(url, object : BaseCallback(mActivity) {
            override fun onSuccess(response: Response<String>) {
                val data = GsonUtils.parseJsonWithGson(response.body(), BoardTypeBean::class.java)
                mTabData.clear()
                mTabData.addAll(data.content.data)
                mUrl = mTabData[0].url
                loadData()
                mTabAdapter.resetAdapter(mTabData)
            }


            override fun onSuccess(jsonString: String) {
            }

        })
    }

    fun loadData() {
        WebList.base(mUrl, object : BaseCallback(mActivity) {
            override fun onSuccess(response: Response<String>) {
                val data = GsonUtils.parseJsonWithGson(response.body(), BoardDataBean::class.java)
                mData.clear()
                mData.addAll(data.content.data)

                mAdapter.resetAdapter(mData, type_int)
            }

            override fun onSuccess(jsonString: String) {
            }

        })
    }
}