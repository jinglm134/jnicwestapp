package com.jnic.provide.football.application

import android.app.Application
import cn.jpush.android.api.JPushInterface
import com.jnic.provide.football.BuildConfig
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheEntity
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.cookie.CookieJarImpl
import com.lzy.okgo.cookie.store.DBCookieStore
import com.lzy.okgo.interceptor.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * Created by ${jaylm}
 * on 2017/12/30.
 */
class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        mApplication = this
        initOkGo()
        JPushInterface.init(this)
//        initJpush();
    }

    fun initOkGo() {
        val builder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor("OkGo")
        if (BuildConfig.LOG_DEBUG) {
            //log打印级别，决定了log显示的详细程度
            loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY)
            //log颜色级别，决定了log在控制台显示的颜色
            loggingInterceptor.setColorLevel(Level.INFO)
            builder.addInterceptor(loggingInterceptor)
        }
        //全局的读取超时时间
        builder.readTimeout(60000, TimeUnit.MILLISECONDS)
        //全局的写入超时时间
        builder.writeTimeout(60000, TimeUnit.MILLISECONDS)
        //全局的连接超时时间
        builder.connectTimeout(60000, TimeUnit.MILLISECONDS)

        //使用sp保持cookie，如果cookie不过期,则一直有效
        //builder.cookieJar(new CookieJarImpl(new SPCookieStore(this)));
        //使用数据库保持cookie，如果cookie不过期，则一直有效
        builder.cookieJar(CookieJarImpl(DBCookieStore(this)))
        //使用内存保持cookie，app退出后，cookie消失
        //  builder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));

        OkGo.getInstance().init(this)                       //必须调用初始化
                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE).retryCount = 0                              //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
    }

    companion object {
        private lateinit var mApplication: BaseApplication
        @JvmStatic fun getInstance(): BaseApplication {
            return mApplication
        }
    }

}