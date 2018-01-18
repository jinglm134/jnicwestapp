package com.jnic.provide.jnicwest.ui.main

import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.base.BaseActivity
import com.jnic.provide.jnicwest.ui.host.board.FragmentBoardYC
import com.jnic.provide.jnicwest.ui.host.info.FragmentInfo
import com.jnic.provide.jnicwest.ui.host.jiao.FragmentJiaoQiu
import com.jnic.provide.jnicwest.ui.host.news.FragmentNews
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * Created by ${jaylm}
 * on 2018/1/14.
 */
class ActivityMain : BaseActivity() {
    private lateinit var fragments: MutableList<Class<out Fragment>>

    private val TAB_TITLE = arrayOf("新闻", "数据", "榜单", "角球")
    private val TAB_ICON = intArrayOf(R.mipmap.icon_news, R.mipmap.icon_data, R.mipmap.icon_board, R.mipmap.icon_ball)

    override fun bindLayout(): Int {
        return R.layout.activity_main
    }


    override fun initView(contentView: View) {
        super.initView(contentView)
        hideHeader()

        fragments = ArrayList<Class<out Fragment>>()
        fragments.add(FragmentNews::class.java)
        fragments.add(FragmentInfo::class.java)
        fragments.add(FragmentBoardYC::class.java)
        fragments.add(FragmentJiaoQiu::class.java)

        tabHost.setup(mActivity, supportFragmentManager, R.id.frameLayout)
        tabHost.tabWidget.dividerDrawable = null
        initTab()
    }

    fun initTab() {
        for (i in TAB_TITLE.indices) {

            val rootView = LayoutInflater.from(mActivity).inflate(R.layout.view_tab_host, null)
            val tv_title = rootView.findViewById<TextView>(R.id.tv_icon)
            tv_title.text = TAB_TITLE[i]
            val iv_icon = rootView.findViewById<ImageView>(R.id.iv_icon)
            iv_icon.setImageResource(TAB_ICON[i])
            if (i == 0) {
                iv_icon.setColorFilter(mActivity.resources.getColor(R.color.c2))
                tv_title.setTextColor(mActivity.resources.getColor(R.color.c2))
            } else {
                iv_icon.setColorFilter(mActivity.resources.getColor(R.color.c6))
                tv_title.setTextColor(mActivity.resources.getColor(R.color.c6))
            }

            val tabSpec = tabHost.newTabSpec(TAB_TITLE[i]).setIndicator(rootView)
            tabHost.addTab(tabSpec, fragments[i], null)
            tabHost.tag = i
        }
    }


    override fun setListener() {
        super.setListener()
        tabHost.setOnTabChangedListener({
            p0 ->
            /*if (p0 == TAB_TITLE[1]) {
                if (!UIHelper.checkIsLogin(mActivity)) {
                    return@setOnTabChangedListener
                }
            }*/

            val tab = tabHost.tabWidget
            for (i in 0..tab.childCount - 1) {
                val view = tab.getChildAt(i)
                val iv = view.findViewById<ImageView>(R.id.iv_icon)
                val tv = view.findViewById<TextView>(R.id.tv_icon)
                if (i == tabHost.currentTab) {
                    iv.setColorFilter(mActivity.resources.getColor(R.color.c2))
                    tv.setTextColor(mActivity.resources.getColor(R.color.c2))
                } else {
                    iv.setColorFilter(mActivity.resources.getColor(R.color.c6))
                    tv.setTextColor(mActivity.resources.getColor(R.color.c6))
                }
            }
        })
    }
}