package com.jnic.provide.jnicwest.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jnic.provide.jnicwest.R;
import com.jnic.provide.jnicwest.util.ConvertUtils;

import java.util.ArrayList;
import java.util.List;

public class ActionSheet extends Dialog {

    public interface OnActionSheetSelected {

        /**
         * 当单击sheet时触发（只有ButtonSheet被点击时会触发该事件）
         *
         * @param v
         * @param index 从0开始，除CancelSheet外，所有sheet都会被计算在内
         */
        void onClickContentSheet(View v, int index);

        void onClickCancelSheet(View v);
    }

    public static abstract class OnContentSheetSelected implements OnActionSheetSelected {

        public abstract void onClickContentSheet(View v, int index);

        public void onClickCancelSheet(View v) {

        }

    }

    private TextView mCancel;

    private LinearLayout mContent;

    private Context mContext;

    private OnActionSheetSelected onActionSheetSelected;

    private List<TextView> views;

    public ActionSheet(Context context) {
        super(context, R.style.Dialog);
        views = new ArrayList<>();
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.actionsheet, null);
        final int cFullFillWidth = 10000;
        layout.setMinimumWidth(cFullFillWidth);

        mCancel = layout.findViewById(R.id.cancel);
        mCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
                if (onActionSheetSelected != null)
                    onActionSheetSelected.onClickCancelSheet(v);
            }
        });

        mContent = layout.findViewById(R.id.content);

        mContent.setBackgroundColor(mContext.getResources().getColor(R.color.c10));


        Window w = getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.x = 0;
        final int cMakeBottom = -1000;
        lp.y = cMakeBottom;
        lp.gravity = Gravity.BOTTOM;
        onWindowAttributesChanged(lp);
        setCanceledOnTouchOutside(true);

        setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    dismiss();
                    if (onActionSheetSelected != null)
                        onActionSheetSelected.onClickCancelSheet(mCancel);
                    return true;
                }
                return false;
            }
        });

        setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dismiss();
                if (onActionSheetSelected != null)
                    onActionSheetSelected.onClickCancelSheet(mCancel);
            }
        });

        setContentView(layout);
    }

    public ActionSheet addButtonSheets(CharSequence... items) {
        for (int i = 0; i < items.length; i++) {
            views.add(createItem(items[i], false, views.size()));
        }
        return this;
    }

    public ActionSheet addButtonSheets(int... items) {
        for (int i = 0; i < items.length; i++) {
            views.add(createItem(items[i], false, views.size()));
        }
        return this;
    }

    public ActionSheet addTextSheets(CharSequence... items) {
        for (int i = 0; i < items.length; i++) {
            views.add(createItem(items[i], true, views.size()));
        }
        return this;
    }

    public ActionSheet addTextSheets(int... items) {
        for (int i = 0; i < items.length; i++) {
            views.add(createItem(items[i], true, views.size()));
        }
        return this;
    }

    public ActionSheet removeCancelSheet() {
        mCancel.setVisibility(View.GONE);
        return this;
    }

    public ActionSheet addCancelSheet() {
        mCancel.setVisibility(View.VISIBLE);
        return this;
    }

    public ActionSheet clear() {
        views.clear();
        mContent.removeAllViews();
        return this;
    }

    public ActionSheet submit(OnActionSheetSelected li) {
        submit();
        setOnActionSheetSelected(li);
        return this;
    }

    public ActionSheet submit() {

        for (int i = 0; i < views.size(); i++) {
            TextView item = views.get(i);

            if (i == 0) {
                item.setBackgroundResource(R.drawable.selector_actionsheet);
            } else if (i == views.size() - 1)
                item.setBackgroundResource(R.drawable.selector_actionsheet);
            else
                item.setBackgroundResource(R.drawable.selector_actionsheet);


            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.topMargin = ConvertUtils.dp2px(mContext, 0.5f);
            mContent.addView(item, params);
        }
        return this;
    }

    @Override
    public void setTitle(CharSequence str) {
        if (views.size() > 0)
            views.get(0).setText(str);
    }

    @Override
    public void setTitle(int resid) {
        if (views.size() > 0)
            views.get(0).setText(resid);
    }

    public void setOnActionSheetSelected(OnActionSheetSelected onActionSheetSelected) {
        this.onActionSheetSelected = onActionSheetSelected;
    }

    @Override
    public void show() {
        // 如果处于锁屏状态则不显示
        if (!isShowing()) {
            super.show();
        }
    }

    @Override
    public void dismiss() {
        if (isShowing()) {
            super.dismiss();
        }
    }

    private TextView createItem(CharSequence str, boolean isText, final int index) {
        TextView btn = new TextView(mContext);
        btn.setText(str);
        btn.setTextSize(16);
        btn.setTextColor(isText ? mContext.getResources().getColor(R.color.c4) : mContext.getResources().getColor(R.color.c1));
        btn.setGravity(Gravity.CENTER);
        if (!isText)
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dismiss();
                    if (onActionSheetSelected != null)
                        onActionSheetSelected.onClickContentSheet(v, index);
                }
            });
        return btn;
    }

    private TextView createItem(int resId, boolean isText, final int index) {
        return createItem(mContext.getString(resId), isText, index);
    }

    public static ActionSheet defaultActionSheetSelecter(Context context, int title, final String[] items, final TextView item) {
        return defaultActionSheet(context, title, items, new OnContentSheetSelected() {

            @Override
            public void onClickContentSheet(View v, int index) {
                if (index > 0)
                    item.setText(items[index - 1]);
            }
        });
    }

    public static ActionSheet defaultActionSheetSelecter(Context context, String title, final String[] items, final TextView item) {
        return defaultActionSheet(context, title, items, new OnContentSheetSelected() {

            @Override
            public void onClickContentSheet(View v, int index) {
                item.setText(items[index]);
            }
        });
    }

    /**
     * @param context
     * @param title   实际为一项TextSheet
     * @param items
     * @param li
     * @return
     */
    public static ActionSheet defaultActionSheet(Context context, int title, String[] items, OnActionSheetSelected li) {
        ActionSheet actionSheet = new ActionSheet(context);
        actionSheet.addTextSheets(title).addButtonSheets(items).submit();
        actionSheet.setOnActionSheetSelected(li);
        return actionSheet;
    }

    /**
     * @param context
     * @param title   实际为一项TextSheet
     * @param items
     * @param li
     * @return
     */
    public static ActionSheet defaultActionSheet(Context context, int title, int[] items, OnActionSheetSelected li) {
        ActionSheet actionSheet = new ActionSheet(context);
        actionSheet.addTextSheets(title).addButtonSheets(items).submit();
        actionSheet.setOnActionSheetSelected(li);
        return actionSheet;
    }

    /**
     * @param context
     * @param title   实际为一项TextSheet
     * @param items
     * @param li
     * @return
     */
    public static ActionSheet defaultActionSheet(Context context, String title, String[] items, OnActionSheetSelected li) {
        ActionSheet actionSheet = new ActionSheet(context);
        actionSheet.addTextSheets(title).addButtonSheets(items).submit();
        actionSheet.setOnActionSheetSelected(li);
        return actionSheet;
    }

    /**
     * @param context
     * @param title   实际为一项TextSheet
     * @param items
     * @param li
     * @return
     */
    public static ActionSheet defaultActionSheet(Context context, String title, int[] items, OnActionSheetSelected li) {
        ActionSheet actionSheet = new ActionSheet(context);
        actionSheet.addTextSheets(title).addButtonSheets(items).submit();
        actionSheet.setOnActionSheetSelected(li);
        return actionSheet;
    }

    /**
     * 无title的
     *
     * @param context
     * @param items
     * @param li
     * @return
     */
    public static ActionSheet defaultActionSheet(Context context, String[] items, OnActionSheetSelected li) {
        ActionSheet actionSheet = new ActionSheet(context);
        actionSheet.addButtonSheets(items).submit();
        actionSheet.setOnActionSheetSelected(li);
        return actionSheet;
    }

    public TextView getItemText(int position) {
        TextView tv = (TextView) mContent.getChildAt(position);
        return tv;
    }
}
