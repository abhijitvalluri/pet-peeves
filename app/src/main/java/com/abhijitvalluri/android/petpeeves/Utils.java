package com.abhijitvalluri.android.petpeeves;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.DisplayMetrics;

/**
 * Utils class for all the useful little utilities for this app
 */
public class Utils {
    private static Utils ourInstance;

    private Boolean mIsPhone;

    public static Utils getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new Utils(context);
        }
        return ourInstance;
    }

    public Bitmap getScaledBitmap(String path, int destWidth, int destHeight) {
        // Read in the dimensions of the image on disk
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        // Figure out how much to scale down by
        int inSampleSize = 1;

        if (srcHeight > destHeight || srcWidth > destWidth) {
            if (srcWidth > srcHeight) {
                inSampleSize = Math.round(srcHeight / destHeight);
            } else {
                inSampleSize = Math.round(srcWidth / destWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        // Read in and create final bitmap
        return BitmapFactory.decodeFile(path, options);
    }

    public Bitmap getScaledBitmap(String path, Activity activity) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path, size.x, size.y);
    }

    private Utils(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metrics);

        float widthInches = metrics.widthPixels / metrics.xdpi;
        float heightInches =  metrics.heightPixels / metrics.ydpi;

        double diagonalInches = Math.sqrt(
                (widthInches*widthInches) + (heightInches*heightInches));

        mIsPhone = (diagonalInches < 7);
    }

    public Boolean isPhone() {
        return mIsPhone;
    }
}
