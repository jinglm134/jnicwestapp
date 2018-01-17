package com.jnic.provide.jnicwest.util.glide

import android.content.Context
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.util.ScreenUtils

/**
 * Created by ${jaylm}
 * on 2018/1/9.
 */
@GlideModule
class GlideUtils : AppGlideModule() {
    companion object {
        @JvmStatic fun loadImg(context: Context, url: String, imageView: ImageView) {
            Glide.with(context).load(url)/*.fitCenter()*/.into(imageView)//默认内存缓存 fitCenter

        }

        /* @JvmStatic fun loadImg(context: Context, url: String, @DrawableRes errorResource: Int, imageView: ImageView) {
             Glide.with(context).load(url).error(errorResource).into(imageView)
         }

         @JvmStatic fun loadImageSize(context: Context, url: String, imageView: ImageView, width: Int = ScreenUtils.getScreenWidth(context),
                                      height: Int = ScreenUtils.getScreenHeight(context), errorResource: Int = R.mipmap.bg_load_error) {
             Glide.with(context).load(url).override(width, height).fitCenter().error(errorResource).into(imageView)
         }*/
    }
}