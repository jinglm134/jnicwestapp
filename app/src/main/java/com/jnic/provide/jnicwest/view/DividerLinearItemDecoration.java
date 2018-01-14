package com.jnic.provide.jnicwest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jnic.provide.jnicwest.R;
import com.jnic.provide.jnicwest.application.BaseApplication;
import com.jnic.provide.jnicwest.util.SizeUtils;


/**
 * Created by ${jaylm}
 * on 2017/12/5.
 */
public class DividerLinearItemDecoration extends RecyclerView.ItemDecoration {

    private int dividerHeight;
    private Paint dividerPaint;

    public DividerLinearItemDecoration() {
        this(R.color.c10, 1);
    }

    public DividerLinearItemDecoration(@ColorRes int color, int height) {
        Context context = BaseApplication.getInstance().getApplicationContext();
        dividerPaint = new Paint();
        dividerPaint.setColor(context.getResources().getColor(color));
        dividerHeight = SizeUtils.dp2px(context, height);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            float top = view.getTop();
            float bottom = view.getBottom() + dividerHeight;
            c.drawRect(left, top, right, bottom, dividerPaint);
        }
    }
}
