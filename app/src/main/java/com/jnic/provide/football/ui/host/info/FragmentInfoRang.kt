package com.jnic.provide.football.ui.host.info

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.jnic.provide.football.R
import com.jnic.provide.football.adapter.AdapterInfoRang
import com.jnic.provide.football.base.BaseFragment
import com.jnic.provide.football.bean.InfoRangBean
import com.jnic.provide.football.constant.API
import com.jnic.provide.football.net.BaseCallback
import com.jnic.provide.football.net.WebList
import com.jnic.provide.football.util.GsonUtils
import com.jnic.provide.football.view.DividerLinearItemDecoration
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.freagment_info_rang.*
import org.jetbrains.anko.backgroundDrawable
import org.jetbrains.anko.collections.forEachWithIndex

@Suppress("DEPRECATION")
/**
 * Created by ${jaylm}
 * on 2018/1/16.
 */
class FragmentInfoRang : BaseFragment(), View.OnClickListener {


    private var mType: Int = 0
    private var mKind: Int = 0
    private var leagueId: Int = 0
    private lateinit var mData: InfoRangBean
    private var mDatas = ArrayList<InfoRangBean.HomeBean>()
    private var mViewArray = ArrayList<TextView>()
    private lateinit var mAdapter: AdapterInfoRang

    override fun bindLayout(): Int {
        return R.layout.freagment_info_rang
    }

    override fun initView() {
        super.initView()
        leagueId = arguments!!.getInt("leagueId")
        mType = arguments!!.getInt("type")
        mKind = arguments!!.getInt("kind")

        initTextView()
        xRecyclerView.setHasFixedSize(true)
        xRecyclerView.setLoadingMoreEnabled(false)
        xRecyclerView.setPullRefreshEnabled(false)
        xRecyclerView.layoutManager = LinearLayoutManager(mActivity)
        xRecyclerView.addItemDecoration(DividerLinearItemDecoration())

        mAdapter = AdapterInfoRang(mActivity, mDatas, mType)
        xRecyclerView.adapter = mAdapter
    }

    fun initTextView() {
        mViewArray.add(tv_quanbu)
        mViewArray.add(tv_zhu)
        mViewArray.add(tv_ke)
    }

    override fun setListener() {
        super.setListener()
        tv_quanbu.setOnClickListener(this)
        tv_zhu.setOnClickListener(this)
        tv_ke.setOnClickListener(this)
    }

    override fun setValue() {
        super.setValue()
        loadData()
    }

    fun loadData() {
        val url: String
        if (mType == 1) {
            url = API.LeagueHdp + "&leagueId=" + leagueId + "&type=" + mKind
        } else {
            url = API.LeagueOu + "&leagueId=" + leagueId
        }
        WebList.base(url, object : BaseCallback(mActivity) {
            override fun onSuccess(response: Response<String>) {
                mData = GsonUtils.parseJsonWithGson(response.body(), InfoRangBean::class.java)

                onSelectChange()
            }

            override fun onSuccess(jsonString: String) {

            }

        })
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tv_quanbu -> onSelectChange()
            R.id.tv_zhu -> onSelectChange(1)
            R.id.tv_ke -> onSelectChange(2)
        }
    }

    fun onSelectChange(position: Int = 0) {
        mViewArray.forEachWithIndex { i, textView ->
            if (i == position) {
                textView.setTextColor(mActivity.resources.getColor(R.color.c14))
                textView.backgroundDrawable = mActivity.resources.getDrawable(R.drawable.shape_bd_c2_bg_c2)
            } else {
                textView.setTextColor(mActivity.resources.getColor(R.color.c2))
                textView.backgroundDrawable = mActivity.resources.getDrawable(R.drawable.shape_bd_c2_bg_c14)
            }
        }

        mDatas.clear()
        if (position == 0) {
            mDatas.addAll(mData.all)
        } else if (position == 1) {
            mDatas.addAll(mData.home)
        } else {
            mDatas.addAll(mData.guest)
        }
        mAdapter.resetAdapter(mDatas)
    }
}