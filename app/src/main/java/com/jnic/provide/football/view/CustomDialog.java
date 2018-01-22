package com.jnic.provide.football.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jnic.provide.football.R;


/**
 * Created by ${jaylm}
 * on 2017/12/4.
 */

public class CustomDialog {

    private Context mContext;
    private Dialog mDialog;
    private ImageView mDivideLine;

    private boolean alreadyHaveOneBtn;

    public static final int CONTENT_TEXT_TYPE = 0;//default,文本框
    public static final int CONTENT_EDIT_TYPE = 1;//可选择,输入框

    public CustomDialog(Context context) {
        super();
        this.mContext = context;
        initDialog();
        setListener();
    }

    private void initDialog() {
        mDialog = new Dialog(mContext, R.style.CustomerDialogStyle);
        mDialog.setCancelable(false);
        mDialog.setContentView(R.layout.dialog_custom);
        mDivideLine = mDialog.findViewById(R.id.center_line);
    }

    private void setListener() {
        mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (KeyEvent.KEYCODE_BACK == keyCode && event.getAction() == KeyEvent.ACTION_DOWN) {
                    dialog.dismiss();
                    return true;
                }
                return false;
            }
        });
    }

    public void setTitle(int title) {
        if (mContext != null) {
            setTitle(mContext.getString(title));
        }
    }

    public void setTitle(String title) {
        TextView textView = mDialog.findViewById(R.id.tv_dialog_title);
        textView.setText(title);
    }


    public void setMessage(String message,  int type) {
        TextView textView = mDialog.findViewById(R.id.tx_dialog_content);
        EditText editText = mDialog.findViewById(R.id.et_dialog_content);
        switch (type) {
            case CONTENT_TEXT_TYPE:
                textView.setVisibility(View.VISIBLE);
                editText.setVisibility(View.GONE);
                textView.setText(message);
                break;
            case CONTENT_EDIT_TYPE:
                editText.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
                editText.setHint(message);
                break;
        }
    }

    public void addPositiveButton(String title, final View.OnClickListener listener) {

        LinearLayout layout = mDialog.findViewById(R.id.dialog_footer);
        layout.setVisibility(View.VISIBLE);
        Button btn_ok = mDialog.findViewById(R.id.btn_dialog_ok);
        btn_ok.setVisibility(View.VISIBLE);
        btn_ok.setText(title);
        btn_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dismiss();
            }
        });
        if (alreadyHaveOneBtn) {
            mDivideLine.setVisibility(View.VISIBLE);
        } else {
            alreadyHaveOneBtn = true;
        }
    }

    public void addPositiveButton(String title, final OnEditClickListener listener) {

        LinearLayout layout = mDialog.findViewById(R.id.dialog_footer);
        layout.setVisibility(View.VISIBLE);
        Button btn_ok = mDialog.findViewById(R.id.btn_dialog_ok);
        btn_ok.setVisibility(View.VISIBLE);
        btn_ok.setText(title);
        btn_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText editText = mDialog.findViewById(R.id.et_dialog_content);
                listener.onPositiveClick(v,editText.getText().toString().trim());
                dismiss();
            }
        });
        if (alreadyHaveOneBtn) {
            mDivideLine.setVisibility(View.VISIBLE);
        } else {
            alreadyHaveOneBtn = true;
        }
    }

    public void addCancelButton(String title, final View.OnClickListener listener) {

        LinearLayout layout = mDialog.findViewById(R.id.dialog_footer);
        layout.setVisibility(View.VISIBLE);
        Button btn_cancel = mDialog.findViewById(R.id.btn_dialog_cancel);
        btn_cancel.setVisibility(View.VISIBLE);
        btn_cancel.setText(title);
        btn_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dismiss();
            }
        });
        if (alreadyHaveOneBtn) {
            mDivideLine.setVisibility(View.VISIBLE);
        } else {
            alreadyHaveOneBtn = true;
        }
    }

    public void addCancelButton(String title) {
        addCancelButton(title, cancelListener);
    }

    public void show() {
        if (mDialog != null) {
            if (mContext instanceof Activity && ((Activity) mContext).isFinishing()) {
                return;
            }
            mDialog.show();
        }
    }

    private void dismiss() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    private View.OnClickListener cancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View p0) {
        }
    };

    public interface OnEditClickListener {
        void onPositiveClick(View view, String text);
    }

}
