package com.jnic.provide.jnicwest.ui.host.video

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.base.BaseFragment
import com.jnic.provide.jnicwest.constant.API
import com.jnic.provide.jnicwest.ui.host.news.FragmentNewsReMen
import com.jnic.provide.jnicwest.ui.host.news.FragmentNewsZhuanHui
import kotlinx.android.synthetic.main.fragment_news.*
import java.util.*

/**
 * Created by ${jaylm}
 * on 2018/1/14.
 */
class FragmentVideo : BaseFragment() {
    private val TITLES = arrayOf("头条", "热门", "转会", "足球", "中国足球", "英甲", "西甲", "德甲", "意甲")
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

        fragments.add(initFragment(API.TOUTIAO))
        fragments.add(FragmentNewsReMen())
        fragments.add(initFragment(API.ZHUANHUI))
        fragments.add(initFragment(API.ZHUQIU))
        fragments.add(initFragment(API.ZHONGGUOZUQIU))
        fragments.add(initFragment(API.YINGCHAO))
        fragments.add(initFragment(API.XIJIA))
        fragments.add(initFragment(API.DEJIA))
        fragments.add(initFragment(API.YIJIA))
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


    fun initFragment(api: String): FragmentNewsZhuanHui {
        val fragment = FragmentNewsZhuanHui()
        val bundle = Bundle()
        bundle.putString("api", api)
        fragment.arguments = bundle
        return fragment
    }
}