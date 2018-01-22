

package com.jnic.provide.football.tools

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import android.graphics.Bitmap
import android.net.Uri
import android.provider.Settings
import android.support.annotation.RawRes
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.checkSelfPermission
import com.jnic.provide.football.R
import com.jnic.provide.football.constant.Const
import com.jnic.provide.football.constant.RequestConfig
import com.jnic.provide.football.util.DialogUtil
import com.jnic.provide.football.util.FileUtils
import com.jnic.provide.football.util.ImageUtils
import com.jnic.provide.football.util.LogUtils
import com.jnic.provide.football.util.permission.MPermission
import com.yanzhenjie.album.Album
import org.jetbrains.annotations.NotNull
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream

/**
 * Created by ${jaylm}
 * on 2017/12/30.
 */
object UIHelper {
    private val normalSize: Float = 0.8F//1M
    private val iconSize: Float = 0.2F//0.2M
    private val iconWidth = 200//px
    private val normalWidth = 800//px

    fun getAppMetaData(context: Context, channel: String): String {
        var channelNumber: String = ""
        try {
            val packageManager = context.packageManager
            if (packageManager != null) {
                val applicationInfo = packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        channelNumber = applicationInfo.metaData.getString(channel)
                    }
                }
            }
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }

        return channelNumber
    }

   /* fun checkIsLogin(context: Context): Boolean {
        if (!BaseApplication.getInstance().isUserLogin()) {
            DialogUtil.showTwoDialog(context, "您还没登录，是否前去登录？", {
                val intent = Intent(context, ActivityLogin::class.java)
                context.startActivity(intent)
            })
            return false
        }
        return true
    }*/

    fun createImage(activity: Activity, limitCount: Int = 1) {
        if (limitCount < 1) {
            return
        }
        Album.startAlbum(activity, RequestConfig.REQUEST_PHOTO, limitCount, activity.resources.getColor(R.color.colorPrimaryDark), activity.resources.getColor(R.color.colorPrimaryDark))
    }

    fun createImage(fragment: Fragment, limitCount: Int = 1) {
        if (limitCount < 1) {
            return
        }
        Album.startAlbum(fragment, RequestConfig.REQUEST_PHOTO, limitCount, fragment.resources.getColor(R.color.colorPrimaryDark), fragment.resources.getColor(R.color.colorPrimaryDark))
    }

    fun compressImageNormal(paths: List<String>): List<String> {
        if (paths.isEmpty()) {
            return paths
        }

        val mLists: Array<String> = Array(paths.size, { _ -> "" })
        paths.forEachIndexed { index, s ->
            val bitmap = ImageUtils.getBitmap(s)
            LogUtils.e("原第 $index 张图片的大小" + (bitmap.byteCount.toFloat() / (1024 * 1024 * 8)) + "M,宽度为"
                    + bitmap.width + "px,高度为" + bitmap.height + "px")

            val scaleBitmap = ImageUtils.compressByScale(bitmap, normalWidth, normalWidth
                    /*ScreenUtils.getScreenWidth(activity), ScreenUtils.getScreenHeight(activity)*/)
            LogUtils.e("尺寸压缩后第 $index 张图片的大小" + (scaleBitmap.byteCount.toFloat() / (1024 * 1024 * 8)) + "M,宽度为"
                    + scaleBitmap.width + "px,高度为" + scaleBitmap.height + "px")
            val compressedBitmap = ImageUtils.compressByQuality(scaleBitmap, (normalSize * 1024 * 1024).toLong())

            val format: Bitmap.CompressFormat
            val type = ImageUtils.getImageType(s)
            when (type) {
                "PNG" -> format = Bitmap.CompressFormat.PNG
                else -> format = Bitmap.CompressFormat.JPEG
            }
            val imagePath = getImageAbsPath(s)

            if (ImageUtils.save(compressedBitmap, imagePath, format))
                mLists[index] = imagePath
            else
                mLists[index] = s
        }
        return mLists.toList()
    }

    fun compressImageIcon(@NotNull paths: List<String>): List<String> {
        if (paths.isEmpty()) {
            return paths
        }

        val mLists: Array<String> = Array(paths.size, { _ -> "" })
        paths.forEachIndexed { index, s ->
            val bitmap = ImageUtils.getBitmap(s)
            LogUtils.e("原第 $index 张图片的大小" + (bitmap.byteCount.toFloat() / (1024 * 1024 * 8)) + "M,宽度为"
                    + bitmap.width + "px,高度为" + bitmap.height + "px")

            val scaleBitmap = ImageUtils.compressByScale(bitmap, iconWidth, iconWidth)
            LogUtils.e("尺寸压缩后第 $index 张图片的大小" + (scaleBitmap.byteCount.toFloat() / (1024 * 1024 * 8)) + "M,宽度为"
                    + scaleBitmap.width + "px,高度为" + scaleBitmap.height + "px")
            val compressedBitmap = ImageUtils.compressByQuality(scaleBitmap, (iconSize * 1024 * 1024).toLong())

            val format: Bitmap.CompressFormat
            val type = ImageUtils.getImageType(s)
            when (type) {
                "PNG" -> format = Bitmap.CompressFormat.PNG
                else -> format = Bitmap.CompressFormat.JPEG
            }
            val imagePath = getImageAbsPath(s)

            if (ImageUtils.save(compressedBitmap, imagePath, format, false))
                mLists[index] = imagePath
            else
                mLists[index] = s
        }
        return mLists.toList()
    }

    /*获取压缩后的图片绝对路径*/
    private fun getImageAbsPath(oldPath: String): String {
        val rootPath = UFile.getCacheImagePath(Const.IMAGE_FILE)
        val ct = System.currentTimeMillis()

        return rootPath + "/$ct." + FileUtils.getFileExtension(oldPath)
    }


    fun callPhone(activity: Activity, phoneNum: String) {

        DialogUtil.showTwoDialog(activity, "确认拨打电话:$phoneNum", {
            if (checkSelfPermission(activity, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                /**已经授权**/
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNum))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                activity.startActivity(intent)

            } else {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CALL_PHONE)) {
                    /*用户选择了不再提示*/
                    DialogUtil.showTwoDialog(activity, "获取拨打电话权限失败,导致部分功能无法正常使用，请到设置页面手动授权", {
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        val uri = Uri.fromParts("package", activity.applicationContext.packageName, null)
                        intent.data = uri
                        activity.startActivity(intent)
                    })
                } else {
                    /*未授权*/
                    MPermission.needPermission(activity, RequestConfig.REQUEST_CALL_PHONE, Manifest.permission.CALL_PHONE)
                }
            }
        })
    }


    fun getReadRaw(activity: Activity, @RawRes id: Int): String {
        val input = activity.resources.openRawResource(id)
        val buffer = readByteDataFromInputStream(input)
        return String(buffer, 0, buffer.size)
    }

    private fun readByteDataFromInputStream(input: InputStream): ByteArray {
        val bis = BufferedInputStream(input)
        val baos = ByteArrayOutputStream()
        val BUFFER_SIZE = 1024
        val buffer = ByteArray(BUFFER_SIZE)
        // 写成baos.write(buffer, 0, c)的原因是读多少写多少
        while (true) {
            val c = bis.read(buffer)
            if (c == -1) {
                break
            }
            baos.write(buffer, 0, c)
            baos.flush()
        }

        val data = baos.toByteArray()
        baos.flush()
        baos.close()
        input.close()
        return data

    }
}