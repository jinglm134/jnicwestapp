package com.jnic.provide.football.ui.host.board

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import com.google.gson.Gson
import com.jnic.provide.football.R
import com.jnic.provide.football.base.BaseActivity
import com.jnic.provide.football.bean.TeamInfoBean
import com.jnic.provide.football.net.BaseCallback
import com.jnic.provide.football.net.WebList
import com.jnic.provide.football.util.GsonUtils
import com.jnic.provide.football.util.glide.GlideUtils
import kotlinx.android.synthetic.main.activity_team_info.*
import kotlin.collections.ArrayList

/**
 * Created by ${jaylm}
 * on 2018/1/22.
 */
class ActivityTeamInfo : BaseActivity() {

    private val TAB_TITLE = arrayOf("球员", "资料")
    private var mTeamId: Int = 0
    private lateinit var mData: TeamInfoBean
    private var fragments = ArrayList<Fragment>()

    override fun bindLayout(): Int {
        return R.layout.activity_team_info
    }

    override fun initParams(params: Bundle?) {
        super.initParams(params)
        if (params != null) {
            mTeamId = params.getInt("teamid")
        }
    }

    override fun initView(contentView: View) {
        super.initView(contentView)
    }

    override fun setListener() {
        super.setListener()
        tabLayout.addOnTabSelectedListener(MyTabSelectListener())
        viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }

    internal inner class MyPagerAdapter(fm: android.support.v4.app.FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return TAB_TITLE.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return TAB_TITLE[position]
        }
    }


    internal inner class MyTabSelectListener : TabLayout.OnTabSelectedListener {

        override fun onTabSelected(tab: TabLayout.Tab) {
            viewpager.currentItem = tab.position
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {}

        override fun onTabReselected(tab: TabLayout.Tab) {}
    }

    override fun setValue() {
        super.setValue()

        loadData()
    }

    private fun loadData() {
        WebList.getTeamInfo(mTeamId, object : BaseCallback(mActivity) {
            override fun onSuccess(jsonString: String) {
                mData = GsonUtils.parseJsonWithGson(jsonString, TeamInfoBean::class.java)
                invalidateView()
            }

        })
    }

    private fun invalidateView() {
        val data = mData.base_info
        GlideUtils.loadImg(mActivity, data.team_logo, iv_teamLogo)
        GlideUtils.loadImg(mActivity, data.country_logo, iv_teamIcon)
        tv_teamName.text = data.team_name
        tv_teamName_english.text = data.team_en_name
        tv_team_info.text = data.founded + "年 / " + data.city + " / " + data.country

        initFragment()
        val mAdapter = MyPagerAdapter(mActivity.supportFragmentManager)
        viewpager.offscreenPageLimit = 1
        viewpager.adapter = mAdapter

        tabLayout.tabMode = TabLayout.MODE_FIXED
        tabLayout.setupWithViewPager(viewpager)
        tabLayout.setTabsFromPagerAdapter(mAdapter)
    }

    private fun initFragment() {
        val fragment2 = FragmentTeamInfo()
        val bundle = Bundle()
        bundle.putString("data", Gson().toJson(mData))
        fragment2.arguments = bundle
        fragments.add(fragment2)
        fragments.add(fragment2)
    }
}