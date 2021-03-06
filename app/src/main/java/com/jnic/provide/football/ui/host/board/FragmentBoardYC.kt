package com.jnic.provide.football.ui.host.board

import android.animation.ObjectAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.jnic.provide.football.R
import com.jnic.provide.football.adapter.AdapterBoard
import com.jnic.provide.football.adapter.AdapterBoardTab
import com.jnic.provide.football.base.BaseFragment
import com.jnic.provide.football.base.BaseRecyclerAdapter
import com.jnic.provide.football.bean.BoardDataBean
import com.jnic.provide.football.bean.BoardTypeBean
import com.jnic.provide.football.constant.API
import com.jnic.provide.football.net.BaseCallback
import com.jnic.provide.football.net.WebList
import com.jnic.provide.football.util.GsonUtils
import com.jnic.provide.football.view.DividerLinearItemDecoration
import com.jnic.provide.football.view.SpinnerPopup
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.fragment_board_yc.*

@Suppress("CAST_NEVER_SUCCEEDS")
/**
 * Created by ${jaylm}
 * on 2018/1/16.
 */
class FragmentBoardYC : BaseFragment(), View.OnClickListener {

    private lateinit var spinnerPopup: SpinnerPopup
    private var mTabData = ArrayList<BoardTypeBean.ContentBean.DataBean>()
    private var mData = ArrayList<BoardDataBean.ContentBean.DataBean>()
    private var mUrl = ""

    private lateinit var mTabAdapter: AdapterBoardTab
    private lateinit var mAdapter: AdapterBoard
    private var type = "person"
    private var type_int = 1 //1球员 2球队
    private var mViewP = ArrayList<TextView>()

    private var mTeamName = emptyArray<String>()
    private var mTeamValue = ArrayList<Int>()
    private var mTeam: Int = 9235
    private var mDegrees: Float = 0F

    override fun bindLayout(): Int {
        return R.layout.fragment_board_yc
    }

    override fun initView() {
        super.initView()

//        season_id = arguments!!.getInt("season_id")
        initData()
        initTextView()
        initRecyclerView()
    }

    fun initData() {
        mTeamName = mActivity.resources.getStringArray(R.array.team)
//        英超：9235；
//        西甲：9234；
//        意甲：9298；
//        德甲：9236；
//        欧冠：9273；
//        法甲：9268；
//        中超：9100；
        mTeamValue.add(9235)
        mTeamValue.add(9234)
        mTeamValue.add(9298)
        mTeamValue.add(9236)
        mTeamValue.add(9273)
        mTeamValue.add(9268)
        mTeamValue.add(9100)
        mTeam = mTeamValue[0]

        spinnerPopup = SpinnerPopup(mActivity)
        spinnerPopup.addListAction(mTeamName.asList())
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
        view_race.setOnClickListener(this)

        mTabAdapter.setOnItemClickListener(object : BaseRecyclerAdapter.OnItemClickListener<BoardTypeBean.ContentBean.DataBean> {
            override fun onItemClick(data: BoardTypeBean.ContentBean.DataBean, position: Int) {
                mUrl = data.url
                loadData()
                mTabAdapter.notifyDataSetChanged()
            }
        })

        /*  mAdapter.setOnItemClickListener(object : AdapterBoard.OnItemClickListener {
              override fun onItemClick(position: Int, type: Int) {
                  if (type == 1) {
                      val person_id = mData[position].person_id.toInt()
                      val bundle = Bundle()
                      bundle.putInt("personid", person_id)
                      mActivity.startActivity(ActivityTeamInfo::class.java, bundle)
                  } else {
                      val team_id = mData[position].team_id.toInt()
                      val bundle = Bundle()
                      bundle.putInt("teamid", team_id)
                      mActivity.startActivity(ActivityTeamInfo::class.java, bundle)
                  }
  //
  //
  //                mActivity.startActivity()
              }

          })*/

        spinnerPopup.setOnDismissListener {
            setRotateAnimal(iv_race)
        }

        spinnerPopup.setOnItemClickListener {
            position ->
            tv_race.text = mTeamName[position]
            mTeam = mTeamValue[position]
            teamPerson()
        }
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tv_person -> {
                teamPerson()
            }
            R.id.tv_team -> {
                teamPerson(false)
            }

            R.id.view_race -> {
                spinnerPopup.showBottom(v)
                setRotateAnimal(iv_race)
            }
        }
    }

    override fun setValue() {
        super.setValue()
        loadTabData()
    }

    fun loadTabData(isRefresh: Boolean = false) {
        val url = API.BOARD + "&season_id=" + mTeam + "&type=" + type
        WebList.base(url, object : BaseCallback(mActivity) {
            override fun onSuccess(response: Response<String>) {
                val data = GsonUtils.parseJsonWithGson(response.body(), BoardTypeBean::class.java)
                mTabData.clear()
                mTabData.addAll(data.content.data)
                mUrl = mTabData[0].url
                loadData()
                if (isRefresh) {
                    mTabAdapter.resetAdapter(mTabData, 0)
                } else {
                    mTabAdapter.resetAdapter(mTabData)
                }
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


    fun teamPerson(isPerson: Boolean = true) {
        if (isPerson) {
            type = "person"
            type_int = 1
            tv_person.setTextColor(mActivity.resources.getColor(R.color.c14))
            tv_team.setTextColor(mActivity.resources.getColor(R.color.c2))
            tv_person.setBackgroundResource(R.drawable.shape_bd_c2_bg_c2)
            tv_team.setBackgroundResource(R.drawable.shape_bd_c2_bg_c14)
        } else {
            type = "team"
            type_int = 2
            tv_person.setTextColor(mActivity.resources.getColor(R.color.c2))
            tv_team.setTextColor(mActivity.resources.getColor(R.color.c14))
            tv_person.setBackgroundResource(R.drawable.shape_bd_c2_bg_c14)
            tv_team.setBackgroundResource(R.drawable.shape_bd_c2_bg_c2)
        }
        loadTabData(true)
    }

    /**
     * 设置旋转动画
     * @param view :旋转的view
     */
    private fun setRotateAnimal(view: View): Unit {
        ObjectAnimator.ofFloat(view, "rotation", mDegrees, mDegrees + 180).setDuration(300).start()
        mDegrees += 180
    }
}