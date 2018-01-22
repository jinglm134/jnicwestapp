package com.jnic.provide.football.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.text.Html;

import com.jnic.provide.football.R;
import com.jnic.provide.football.util.ScreenUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ${jaylm}
 * on 2017/12/6.
 */

public class MyImageGetter implements Html.ImageGetter {
    private Context mContext;

    public MyImageGetter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Drawable getDrawable(String s) {

        LevelListDrawable drawable = new LevelListDrawable();
        Drawable empty = mContext.getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.addLevel(0, 0, empty);
        drawable.setBounds(0, 0, ScreenUtils.getScreenWidth(mContext),
                empty.getIntrinsicHeight());
        new LoadImage().execute(s);


        return drawable;

     /*   Drawable drawable;
        URL url;
        try {
            url = new URL(s);
//            drawable = Drawable.createFromStream(url.openStream(), "");
            drawable = new BitmapDrawable(BitmapFactory.decodeStream(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;*/
    }


    class LoadImage extends AsyncTask<Object, Void, Bitmap> {

        private LevelListDrawable mDrawable;

        @Override
        protected Bitmap doInBackground(Object... params) {
            String source = (String) params[0];
            mDrawable = (LevelListDrawable) params[1];
            try {
                InputStream is = new URL(source).openStream();
                return BitmapFactory.decodeStream(is);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * 图片下载完成后执行
         */
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                BitmapDrawable d = new BitmapDrawable(bitmap);
                mDrawable.addLevel(1, 1, d);
                /**
                 * 适配图片大小 <br/>
                 * 默认大小：bitmap.getWidth(), bitmap.getHeight()<br/>
                 * 适配屏幕：getDrawableAdapter
                 */
                mDrawable = getDrawableAdapter(mContext, mDrawable,
                        bitmap.getWidth(), bitmap.getHeight());

                // mDrawable.setBounds(0, 0, bitmap.getWidth(),
                // bitmap.getHeight());

                mDrawable.setLevel(1);

              /*  mtvActNewsContent.invalidate();
                CharSequence t = mtvActNewsContent.getText();
                mtvActNewsContent.setText(t);*/
            }
        }

        /**
         * 加载网络图片,适配大小
         */
        public LevelListDrawable getDrawableAdapter(Context context,
                                                    LevelListDrawable drawable, int oldWidth, int oldHeight) {
            LevelListDrawable newDrawable = drawable;
            long newHeight;// 未知数
            int newWidth = ScreenUtils.getScreenWidth(context);// 默认屏幕宽
            newHeight = (newWidth * oldHeight) / oldWidth;
            newDrawable.setBounds(0, 0, newWidth, (int) newHeight);
            return newDrawable;
        }
    }
}
