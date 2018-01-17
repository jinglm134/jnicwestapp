package com.jnic.provide.jnicwest.ui.host.board

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.*
import java.util.*

/**
 * Created by ${jaylm}
 * on 2018/1/14.
 */
class FragmentBoard : BaseFragment() {
    private val TITLES = arrayOf("英超", "西甲", "意甲", "德甲")
    private val fragments = ArrayList<Fragment>()

    override fun bindLayout(): Int {
        return R.layout.fragment_news
    }

    override fun initView() {
        super.initView()
        val mAdapter = MyPagerAdapter(mActivity.supportFragmentManager)
        viewpager.offscreenPageLimit = 1
        viewpager.adapter = mAdapter

        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        tabLayout.setupWithViewPager(viewpager)
        tabLayout.setTabsFromPagerAdapter(mAdapter)

        fragments.add(initFragment(9235))
        fragments.add(initFragment(9235))
        fragments.add(initFragment(9235))
        fragments.add(initFragment(9235))
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


    fun initFragment(season_id: Int): FragmentBoardYC {
        val fragment = FragmentBoardYC()
        val bundle = Bundle()
        bundle.putInt("season_id", season_id)
        fragment.arguments = bundle
        return fragment
    }
}