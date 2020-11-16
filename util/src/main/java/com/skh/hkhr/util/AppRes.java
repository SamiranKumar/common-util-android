package com.skh.hkhr.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class AppRes {

    public static Drawable getDrawable(int resId, Context context) {
        return ContextCompat.getDrawable(context, resId);
    }

    public static int getColor(int resId, Context context) {
        return ContextCompat.getColor(context, resId);
    }

    public static String getString(int resId, Context context) {
        return context.getResources().getString(resId);
    }
}
