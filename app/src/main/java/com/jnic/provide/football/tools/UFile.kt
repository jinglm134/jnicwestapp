package com.jnic.provide.football.tools

import android.os.Environment
import com.jnic.provide.football.application.BaseApplication
import com.jnic.provide.football.constant.Const
import com.jnic.provide.football.util.FileUtils
import org.jetbrains.annotations.NotNull
import java.io.File
import java.math.BigDecimal

/**
 * Created by ${jaylm}
 * on 2018/1/8.
 */
object UFile {
    /* Environment.getDataDirectory().getPath() :                                      获得根目录/data 内部存储路径
     Environment.getDownloadCacheDirectory().getPath()  :               获得缓存目录/cache
     Environment.getExternalStorageDirectory().getPath():                  获得SD卡目录/mnt/sdcard（获取的是手机外置sd卡的路径）
     Environment.getRootDirectory().getPath() :                                     获得系统目录/system

     通过Context获取的

     Context.getDatabasePath()                                                      返回通过Context.openOrCreateDatabase 创建的数据库文件
     Context.getCacheDir().getPath() :                                            用于获取APP的cache目录 /data/data/<application package>/cache目录
     Context.getExternalCacheDir().getPath()  :                           用于获取APP的在SD卡中的cache目录/mnt/sdcard/Android/data/<application package>/cache
     Context.getFilesDir().getPath()  :                                             用于获取APP的files目录 /data/data/<application package>/files
     Context.getObbDir().getPath():                                                用于获取APPSDK中的obb目录 /mnt/sdcard/Android/obb/<application package>
     Context.getPackageName() :                                                  用于获取APP的所在包目录
     Context.getPackageCodePath()  :                                          来获得当前应用程序对应的 apk 文件的路径
     Context.getPackageResourcePath() :                                   获取该程序的安装包路径*/

    /**
     * 获取SD卡下文件夹路径
     */
    fun getCacheImagePath(@NotNull packageName: String): String {
        var folder: File? = File(Environment.getExternalStorageDirectory().path + "/" + Const.APP_FOLDER + "/" + packageName)

        if (folder == null || !folder.exists() && !folder.mkdirs()) {
            folder = File(BaseApplication.getInstance().filesDir, packageName)
        }

        if (!folder.exists() && !folder.mkdirs()) {
            return ""
        }
        return folder.absolutePath
    }


    /**
     * 获取文件夹大小
     * @param file File实例
     * *
     * @return long
     */
    fun getFolderSize(file: File): Long {

        var size: Long = 0
        try {
            val fileList = file.listFiles()
            for (i in fileList!!.indices) {
                if (fileList[i].isDirectory) {
                    size += getFolderSize(fileList[i])

                } else {
                    size += fileList[i].length()

                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return size
    }


    /**
     * 格式化单位
     */
    fun getFormatSize(size: Double): String {
        val kiloByte = size / 1024
        if (kiloByte < 1) {
            return size.toString() + "Byte(s)"
        }

        val megaByte = kiloByte / 1024
        if (megaByte < 1) {
            val result1 = BigDecimal(java.lang.Double.toString(kiloByte))
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB"
        }

        val gigaByte = megaByte / 1024
        if (gigaByte < 1) {
            val result2 = BigDecimal(java.lang.Double.toString(megaByte))
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB"
        }

        val teraBytes = gigaByte / 1024
        if (teraBytes < 1) {
            val result3 = BigDecimal(java.lang.Double.toString(gigaByte))
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB"
        }
        val result4 = BigDecimal(teraBytes)
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB"
    }

    fun getCacheFiles(): List<File> {
        val files = ArrayList<File>()
        val context = BaseApplication.getInstance().applicationContext
        files.add(context.cacheDir)
        files.add(context.externalCacheDir)
        files.add(FileUtils.getFileByPath(context.filesDir.parent + File.separator + "shared_prefs"))
        files.add(FileUtils.getFileByPath(Environment.getExternalStorageDirectory().path + "/" + Const.APP_FOLDER))

        return files
    }
}