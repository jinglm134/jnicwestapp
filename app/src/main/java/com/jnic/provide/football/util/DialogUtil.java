package com.jnic.provide.football.util;

import android.content.Context;
import android.view.View;

import com.jnic.provide.football.view.CustomDialog;

/**
 * Created by ${jaylm}
 * on 2017/12/4.
 */

public class DialogUtil {


    public static void showSingleDialog(Context context, String message, View.OnClickListener clickListener) {
        CustomDialog builder = new CustomDialog(context);
        builder.setTitle("提示");
        builder.addPositiveButton("确定", clickListener);
        builder.setMessage(message, CustomDialog.CONTENT_TEXT_TYPE);
        builder.show();
    }

    public static void showSingleDialog(Context context, String message, String positiveBtnName, View.OnClickListener clickListener) {
        CustomDialog builder = new CustomDialog(context);
        builder.setTitle("提示");
        builder.addPositiveButton(positiveBtnName, clickListener);
        builder.setMessage(message, CustomDialog.CONTENT_TEXT_TYPE);
        builder.show();
    }

    public static void showTwoDialog(Context context, String message, View.OnClickListener clickListener) {
        CustomDialog builder = new CustomDialog(context);
        builder.setTitle("提示");
        builder.addPositiveButton("确定", clickListener);
        builder.setMessage(message, CustomDialog.CONTENT_TEXT_TYPE);
        builder.addCancelButton("取消");
        builder.show();

    }

    public static void showTwoDialog(Context context, String message, String positiveBtnName, View.OnClickListener clickListener) {
        CustomDialog builder = new CustomDialog(context);
        builder.setTitle("提示");
        builder.addPositiveButton(positiveBtnName, clickListener);
        builder.setMessage(message, CustomDialog.CONTENT_TEXT_TYPE);
        builder.addCancelButton("取消");
        builder.show();
    }

    public static void showTwoDialog(Context context, String message, String positiveBtnName, View.OnClickListener positiveListener, View.OnClickListener cancelListener) {
        CustomDialog builder = new CustomDialog(context);
        builder.setTitle("提示");
        builder.addPositiveButton(positiveBtnName, positiveListener);
        builder.setMessage(message, CustomDialog.CONTENT_TEXT_TYPE);
        builder.addCancelButton("取消", cancelListener);
        builder.show();
    }

    public static void showEditDialog(Context context, String message, CustomDialog.OnEditClickListener positiveListener) {
        CustomDialog builder = new CustomDialog(context);
        builder.setTitle("提示");
        builder.addPositiveButton("确定", positiveListener);
        builder.setMessage(message, CustomDialog.CONTENT_EDIT_TYPE);
        builder.addCancelButton("取消");
        builder.show();
    }

    public static void showEditDialog(Context context, String message, String positiveBtnName, CustomDialog.OnEditClickListener positiveListener, View.OnClickListener cancelListener) {
        CustomDialog builder = new CustomDialog(context);
        builder.setTitle("提示");
        builder.addPositiveButton(positiveBtnName, positiveListener);
        builder.setMessage(message, CustomDialog.CONTENT_EDIT_TYPE);
        builder.addCancelButton("取消", cancelListener);
        builder.show();
    }
}
