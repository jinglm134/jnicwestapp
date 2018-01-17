package com.jnic.provide.jnicwest.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.Window
import android.view.WindowManager
import butterknife.ButterKnife
import butterknife.Unbinder
import com.jnic.provide.jnicwest.BuildConfig
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.constant.RequestConfig
import com.jnic.provide.jnicwest.util.permission.MPermission
import com.jnic.provide.jnicwest.util.permission.annotation.OnMPermissionNeverAskAgain
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.layout_title.*
import java.util.*


/**
 * Created by ${jaylm}
 * on 2017/12/30.
 */
abstract class BaseActivity : AppCompatActivity(), OnClickListener {
    /**activity**/
    lateinit var mActivity: BaseActivity
    /** 是否沉浸状态栏 **/
    private val isSetStatusBar = false
    /** 是否允许全屏 **/
    private val mAllowFullScreen = false
    /** 是否禁止旋转屏幕 **/
    open var isAllowScreenRotate = false
    /** 当前Activity渲染的视图View **/
    lateinit var mContentView: View
    /** 是否输出日志信息 **/
    private var isDebug: Boolean = false
    private lateinit var TAG: String
    private var bind: Unbinder? = null

    /** 记录上次点击按钮的时间  */
    private var lastClickTime: Long = 0
    /** 按钮连续点击最低间隔时间 单位：毫秒  */
    private val CLICK_TIME = 500

    /** 用来保存所有已打开的Activity  */
    private val listActivity = Stack<Activity>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        TAG = this::class.java.simpleName
        isDebug = BuildConfig.LOG_DEBUG

        if (mAllowFullScreen) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            requestWindowFeature(Window.FEATURE_NO_TITLE)
        }
        if (isSetStatusBar) {
            steepStatusBar()
        }

        setContentView(R.layout.activity_base)
        mContentView = LayoutInflater.from(mActivity).inflate(bindLayout(), fl_content, true)

//        LayoutInflater.from(this).inflate(bindLayout(), parentLinearLayout, true)
        // 将activity推入栈中
        listActivity.push(this)
        bind = ButterKnife.bind(this)

        val bundle = intent.extras
        initParams(bundle)
        if (isAllowScreenRotate) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        } else {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        initView(mContentView)
        setListener()
        setValue()
    }


    protected abstract fun bindLayout(): Int
    open protected fun initParams(params: Bundle?) {}
    open protected fun initView(contentView: View) {}
    open protected fun setListener() {
        iv_back.setOnClickListener(this)
        view_shade.setOnClickListener(this)
    }

    open protected fun setValue() {}
    protected fun setHeader(header: String) {
        tv_title.text = header
    }

    protected fun hideHeader() {
        layout_title.visibility = View.GONE
    }


    /**
     * 沉浸状态栏
     */
    private fun steepStatusBar(): Unit {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            window.addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            // 透明导航栏
            window.addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
    }


    /**
     * 页面跳转
     *
     * @param clz class
     */
    fun startActivity(clz: Class<*>) {
        startActivity(clz, null)
    }

    /**
     * 携带数据的页面跳转
     *
     * @param clz class
     * @param bundle bundle
     */
    fun startActivity(clz: Class<*>, bundle: Bundle?) {
        val intent = Intent()
        intent.setClass(this, clz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    /**
     * 含有Bundle通过Class打开编辑界面
     *
     * @param cls class
     * @param bundle bundle
     * @param requestCode requestCode
     */
    fun startActivityForResult(cls: Class<*>, bundle: Bundle?, requestCode: Int) {
        val intent = Intent()
        intent.setClass(this, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }

    /** 验证上次点击按钮时间间隔，防止重复点击  */
    fun verifyFastClick(): Boolean {
        if (System.currentTimeMillis() - lastClickTime <= CLICK_TIME) {
            return false
        }
        lastClickTime = System.currentTimeMillis()
        return true
    }

    /**
     * 日志输出

     * @param msg
     */
    protected fun log(msg: String) {
        if (isDebug) {
            Log.d(TAG, msg)
        }
    }

    fun getRootView(): View {
        return mContentView
    }

    override fun onDestroy() {
        super.onDestroy()
        bind?.unbind()
        if (listActivity.contains(this)) {
            listActivity.remove(this)
        }
    }


    /*
     * ************Fragement相关方法************************************************
     *
     */
    private var currentFragment: Fragment? = null

    /** Fragment替换(当前destroy,新的create)  */
    fun fragmentReplace(target: Int, toFragment: Fragment, backStack: Boolean) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val toClassName = toFragment::class.java.simpleName
        if (manager.findFragmentByTag(toClassName) == null) {
            transaction.replace(target, toFragment, toClassName)
            if (backStack) {
                transaction.addToBackStack(toClassName)
            }
            transaction.commit()
        }
    }

    /** Fragment替换(核心为隐藏当前的,显示现在的,用过的将不会destrory与create)  */
    fun smartFragmentReplace(target: Int, toFragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        // 如有当前在使用的->隐藏当前的
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }
        val toClassName = toFragment::class.java.simpleName
        // toFragment之前添加使用过->显示出来
        if (manager.findFragmentByTag(toClassName) != null) {
            transaction.show(toFragment)
        } else {// toFragment还没添加使用过->添加上去
            transaction.add(target, toFragment, toClassName)
        }
        transaction.commit()
        // toFragment更新为当前的
        currentFragment = toFragment
    }

    override fun onClick(p0: View?) {
        if (p0 == null) {
            return
        }
        when (p0.id) {
            R.id.iv_back -> finish()
            R.id.view_shade -> view_shade.visibility = View.GONE
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        MPermission.onRequestPermissionsResult(mActivity, requestCode, permissions, grantResults)
    }

    override fun shouldShowRequestPermissionRationale(permission: String?): Boolean {
        return super.shouldShowRequestPermissionRationale(permission)
    }

    @OnMPermissionNeverAskAgain(value = RequestConfig.REQUEST_CALL_PHONE)
    fun permissionNeverAskAgain() {
        //TODO 不再提示
        startActivity(getAppDetailSettingIntent())
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun getAppDetailSettingIntent(): Intent {
        val localIntent = Intent()
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.action = "android.settings.APPLICATION_DETAILS_SETTINGS"
            localIntent.data = Uri.fromParts("package", packageName, null)
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.action = Intent.ACTION_VIEW
            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails")
            localIntent.putExtra("com.android.settings.ApplicationPkgName", packageName)
        }
        return localIntent
    }
}