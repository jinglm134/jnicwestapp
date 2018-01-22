package com.jnic.provide.football.ui.host.info

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import com.jnic.provide.football.R
import com.jnic.provide.football.base.BaseActivity
import kotlinx.android.synthetic.main.fragment_news.*

/**
 * Created by ${jaylm}
 * on 2018/1/14.
 */
class ActivityInfo : BaseActivity() {
    private lateinit var TITLES: Array<String>
    private val fragments = ArrayList<Fragment>()
    private var mLeagueName: String = ""
    private var mLeagueId: Int = 0
    private var mKind: Int = 0
    override fun bindLayout(): Int {
        return R.layout.fragment_news
    }

    override fun initParams(params: Bundle?) {
        super.initParams(params)
        if (params != null) {
            mLeagueId = params.getInt("leagueId")
            mLeagueName = params.getString("leagueName")
            mKind = params.getInt("kind")
            if (mKind == 2) {
                TITLES = arrayOf("赛程", "积分", "让分盘", "大小盘", "统计")
            } else {
                TITLES = arrayOf("赛程", "让分盘", "大小盘", "统计")

            }
        }
    }

    override fun initView(contentView: View) {
        super.initView(contentView)
        setHeader(mLeagueName)

        val mAdapter = MyPagerAdapter(mActivity.supportFragmentManager)
        viewpager.offscreenPageLimit = 1
        viewpager.adapter = mAdapter

        tabLayout.tabMode = TabLayout.MODE_FIXED
        tabLayout.setupWithViewPager(viewpager)
        tabLayout.setTabsFromPagerAdapter(mAdapter)

        fragments.add(initFragment(FragmentInfoRace()))
        if (mKind == 2) {
            fragments.add(initFragment(FragmentInfoScore()))
        }
        fragments.add(initFragment(FragmentInfoRang(), 1))
        fragments.add(initFragment(FragmentInfoRang(), 2))
        fragments.add(initFragment(FragmentInfoTj()))
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
            return TITLES.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return TITLES[position]
        }
    }


    internal inner class MyTabSelectListener : TabLayout.OnTabSelectedListener {

        override fun onTabSelected(tab: TabLayout.Tab) {
            viewpager.currentItem = tab.position
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {}

        override fun onTabReselected(tab: TabLayout.Tab) {}
    }


    fun initFragment(fragment: Fragment, type: Int = 0): Fragment {
        val bundle = Bundle()
        bundle.putInt("leagueId", mLeagueId)
        bundle.putInt("kind", mKind)
        if (type != 0) {
            bundle.putInt("type", type)
        }
        fragment.arguments = bundle
        return fragment
    }
}