package com.jnic.provide.football.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import butterknife.ButterKnife
import butterknife.Unbinder
import com.jnic.provide.football.util.permission.MPermission

/**
 * Created by ${jaylm}
 * on 2017/12/30.
 */
abstract class BaseFragment : Fragment() {

    private var bind: Unbinder? = null
    private var rootView: View? = null
    lateinit var mActivity: BaseActivity
    protected var hasConfig = false//是否已调用过setListeners/setValues

    protected abstract fun bindLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity as BaseActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (rootView == null) {
            rootView = inflater.inflate(bindLayout(), container, false)
            bind = ButterKnife.bind(this, rootView!!)
        }

        //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        val parent: ViewParent? = rootView!!.parent
        if (parent != null) {
            parent as ViewGroup
            parent.removeView(rootView)
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!hasConfig) {
            initView()
            setListener()
            setValue()
            hasConfig = true
        }

    }

    open fun initView() {}

    open fun setListener() {}

    open fun setValue() {}

    override fun onDestroy() {
        super.onDestroy()
        rootView = null
        bind?.unbind()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        MPermission.onRequestPermissionsResult(this, requestCode, permissions, grantResults)
    }
}