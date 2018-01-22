package com.jnic.provide.football.ui.release

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.jnic.provide.football.R
import com.jnic.provide.football.base.BaseActivity
import com.jnic.provide.football.bean.APIServiceBean
import com.jnic.provide.football.util.SnackbarUtils
import com.jnic.provide.football.util.glide.GlideUtils
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

@Suppress("DEPRECATION")
open
/**
 * Created by ${jaylm}
 * on 2018/1/4.
 */
class ActivityHome : BaseActivity() {

    companion object {
        @JvmField val MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION"
        @JvmField val KEY_TITLE = "title"
        @JvmField val KEY_MESSAGE = "message"
        @JvmField val KEY_EXTRAS = "extras"
        @JvmField var isForeground = false
    }

    private lateinit var mData: APIServiceBean
    private var lists_img = ArrayList<ImageView>()
    private var lists_tv = ArrayList<TextView>()
    private lateinit var mAdapter: MyPagerAdapter
    private var exitTime: Long = 0


    override fun bindLayout(): Int {
        return R.layout.activity_home
    }

    override fun initParams(params: Bundle?) {
        super.initParams(params)
        if (params != null) {
            mData = params.getSerializable("data") as APIServiceBean
        }
    }

    override fun initView(contentView: View) {
        super.initView(contentView)
        hideHeader()

        lists_img.add(iv_icon1)
        lists_img.add(iv_icon3)
        lists_img.add(iv_icon4)

        lists_tv.add(tv_icon1)
        lists_tv.add(tv_icon3)
        lists_tv.add(tv_icon4)

        invalidateView()
    }

    private fun invalidateView() {


        val title = mData.buttonArr
        val titles = title.split(",".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()

        val url = mData.buttonImage
        val urls = url.split(",".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()

        tv_icon1.text = titles[0]
        tv_icon2.text = titles[1]
        tv_icon3.text = titles[2]
        tv_icon4.text = titles[3]
        tv_icon5.text = titles[4]

        iv_icon1.setColorFilter(mActivity.resources.getColor(R.color.c2))
        tv_icon1.setTextColor(mActivity.resources.getColor(R.color.c2))
        GlideUtils.loadImg(mActivity, urls[0], iv_icon1)
        GlideUtils.loadImg(mActivity, urls[1], iv_icon2)
        GlideUtils.loadImg(mActivity, urls[2], iv_icon3)
        GlideUtils.loadImg(mActivity, urls[3], iv_icon4)
        GlideUtils.loadImg(mActivity, urls[4], iv_icon5)

        viewpager.offscreenPageLimit = 1
        mAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager.adapter = mAdapter

    }

    override fun setListener() {
        super.setListener()
        rl_icon1.setOnClickListener(this)
        rl_icon2.setOnClickListener(this)
        rl_icon3.setOnClickListener(this)
        rl_icon4.setOnClickListener(this)
        rl_icon5.setOnClickListener(this)

        viewpager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                changeIconColor(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    override fun setValue() {
        super.setValue()
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)
        when (p0!!.id) {
            R.id.rl_icon1 -> viewpager.currentItem = 0
            R.id.rl_icon2 -> {
                val isBack = mAdapter.currentFragment.onBack()
                if (!isBack) {
                    SnackbarUtils.showSnackbar(mContentView, "已经是第一页了")
                }
            }
            R.id.rl_icon3 -> viewpager.currentItem = 1
            R.id.rl_icon4 -> viewpager.currentItem = 2
            R.id.rl_icon5 -> mAdapter.currentFragment.refresh()
        }
    }

    internal inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        lateinit var currentFragment: FragmentWebView

        override fun getItem(position: Int): Fragment {
            val url: String
            when (position) {
                0 -> url = mData.home_url
                1 -> url = mData.service_url
                else -> url = mData.kc_url
            }
            return getFragment(url)
        }

        override fun getCount(): Int {
            return lists_img.size
        }

        override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
            currentFragment = `object` as FragmentWebView
            super.setPrimaryItem(container, position, `object`)
        }

    }


    private fun changeIconColor(index: Int) {
        for (i in lists_img.indices) {
            if (index == i) {
                lists_img[i].setColorFilter(mActivity.resources.getColor(R.color.c2))
                lists_tv[i].setTextColor(mActivity.resources.getColor(R.color.c2))
            } else {
                lists_img[i].setColorFilter(mActivity.resources.getColor(R.color.c6))
                lists_tv[i].setTextColor(mActivity.resources.getColor(R.color.c6))
            }
        }
    }

    private fun getFragment(url: String): FragmentWebView {
        val fragment = FragmentWebView()
        val bundle = Bundle()
        bundle.putString("url", url)
        fragment.arguments = bundle
        return fragment
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN) {
            val consumpted = mAdapter.currentFragment.onBack()
            if (!consumpted) {
                if (System.currentTimeMillis() - exitTime > 2000) {
                    SnackbarUtils.showSnackbar(mContentView, "再按一次退出程序")
                    exitTime = System.currentTimeMillis()
                } else {
                    finish()
                }
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onResume() {
        isForeground = true
        super.onResume()
    }


    override fun onPause() {
        isForeground = false
        super.onPause()
    }
}