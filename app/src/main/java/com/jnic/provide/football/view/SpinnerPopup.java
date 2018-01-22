package com.jnic.provide.football.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jnic.provide.football.R;
import com.jnic.provide.football.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${jaylm}
 * on 2017/12/10.
 */
public class SpinnerPopup extends PopupWindow {
    private Context mContext;
    protected final int LIST_PADDING = 0;

    private Rect mRect = new Rect();
    private final int[] mLocation = new int[2];
    private int mScreenWidth;

    private boolean mIsDirty;

    private int popupGravity = Gravity.NO_GRAVITY;

    private OnItemClickListener mOnItemClickListener;
    private ListView mListView;
    private ArrayList<String> mItems = new ArrayList<>();

    public SpinnerPopup(Context context) {
        this(context, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @SuppressLint("InflateParams")
    @SuppressWarnings("deprecation")
    public SpinnerPopup(Context context, int width, int height) {
        this.mContext = context;

        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);

        mScreenWidth = ScreenUtils.getScreenWidth(mContext);

        setWidth(width);
        setHeight(height);

        setBackgroundDrawable(new BitmapDrawable());
        setContentView(LayoutInflater.from(mContext).inflate(R.layout.popup_spinner, null));
        initUI();
    }

    private void initUI() {
        mListView = getContentView().findViewById(R.id.title_list);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                dismiss();
                if (mOnItemClickListener != null)
                    mOnItemClickListener.onItemClick(arg2);
            }
        });
    }


    public void showBottom(View view) {
        view.getLocationOnScreen(mLocation);

        mRect.set(mLocation[0], mLocation[1], mLocation[0] + view.getWidth(), mLocation[1] + view.getHeight());

        if (mIsDirty) {
            populateActions();
        }
        showAtLocation(view, popupGravity, /*LIST_PADDING + (getWidth() / 2) +*/ mLocation[0], mRect.bottom + 5);
    }

    private void populateActions() {
        mIsDirty = false;

        mListView.setAdapter(new BaseAdapter() {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView;

                if (convertView == null) {
//                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//                    layoutParams.leftMargin = ConvertUtils.px2dp(mContext, 20);
                    textView = new TextView(mContext);
//                    textView.setLayoutParams(layoutParams);
                    textView.setTextColor(mContext.getResources().getColor(R.color.c6));
                    textView.setTextSize(16);
                    textView.setGravity(Gravity.LEFT);
                    textView.setPadding(20, 20, 20, 20);
                    textView.setSingleLine(true);
                } else {
                    textView = (TextView) convertView;
                }

                textView.setText(mItems.get(position));
                return textView;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public Object getItem(int position) {
                return mItems.get(position);
            }

            @Override
            public int getCount() {
                return mItems.size();
            }
        });
    }

    public void addAction(String action) {
        if (action != null) {
            mItems.add(action);
            mIsDirty = true;
        }
    }

    public void addListAction(List<String> actions) {
        if (actions != null && actions.size() > 0) {
            mItems.addAll(actions);
            mIsDirty = true;
        }
    }

    public void cleanAction() {
        if (mItems.isEmpty()) {
            mItems.clear();
            mIsDirty = true;
        }
    }

    public String getAction(int position) {
        if (position < 0 || position > mItems.size())
            return null;
        return mItems.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
