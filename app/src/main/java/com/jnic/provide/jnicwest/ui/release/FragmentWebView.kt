package com.jnic.provide.jnicwest.ui.release

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.base.BaseFragment
import com.jnic.provide.jnicwest.view.ProgressDialog
import kotlinx.android.synthetic.main.activity_webview.*
import org.jetbrains.anko.backgroundColor

/**
 * Created by ${jaylm}
 * on 2017/12/17.
 */
class FragmentWebView : BaseFragment() {

    lateinit var mProgress: ProgressDialog
    override fun bindLayout(): Int {
        return R.layout.activity_webview
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView() {
        super.initView()
        val mUrl = arguments!!.getString("url", "")
        mProgress = ProgressDialog(mActivity, "网页加载中...")
        pb_web.visibility = View.GONE
//        mDialog = new ProgressDialog(getActivity(), "网页加载中...");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }

//        mWebView.getSettings().setDomStorageEnabled(true);
//        mWebView.getSettings().setAppCacheMaxSize(1024 * 1024 * 8);
//        mWebView.getSettings().setAllowFileAccess(true);
//        mWebView.getSettings().setAppCacheEnabled(true);

        webView.settings.domStorageEnabled = true
        //解决图片不显示
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        webView.settings.blockNetworkImage = false

        /*设置编码方式*/
        webView.settings.defaultTextEncodingName = "utf-8"
        /*设置背景透明*/
        webView.backgroundColor = Color.argb(0, 0, 0, 0)
        /*设置支持js*/
        webView.settings.javaScriptEnabled = true
        /*设置支持缩放*/
        webView.settings.setSupportZoom(true)

        webView.webViewClient = ReWebViewClient()
        webView.webChromeClient = MyWebChromeClient()
        val url = mUrl.replace("amp;", "")
        webView.loadUrl(url)
    }

    inner class ReWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            /*打电话*/
            val tag = "tel"
            if (url.contains(tag)) {
                var mobile = url.substring(url.lastIndexOf(":") + 1)
                mobile = mobile.replace("/", "")
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mobile))
                startActivity(intent)
                return true
            }
            webView.loadUrl(url)
            return true
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            mProgress.show()
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            mProgress.dismiss()
            super.onPageFinished(view, url)
        }
    }

    inner class MyWebChromeClient : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            if (newProgress == 100) {
                if (pb_web != null) {
                    pb_web.visibility = View.GONE//加载完网页进度条消失
                }
            } else {
                if (pb_web != null) {
                    pb_web.visibility = View.VISIBLE//开始加载网页时显示进度条
                    pb_web.progress = newProgress//设置进度值
                }
            }
            super.onProgressChanged(view, newProgress)
        }
    }

    fun onBack(): Boolean {
        if (webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return false
    }

    fun refresh() {
        webView.reload()
    }
}