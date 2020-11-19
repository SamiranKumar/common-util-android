package com.skh.hkhr.util;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import timber.log.Timber;

public class WindowUtil {

    /**
     * Making notification bar transparent
     *
     * @param window
     */
    private void changeStatusBarTransparentColor(Window window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * @param activity
     * @param resColor
     */
    public static void changeStatusBarColor(Activity activity, int resColor) { //R.color.resColor

        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(AppRes.getColor(resColor, activity));
        }
    }


    public static void transparentStatusAndNavigation(Activity activity, int resColor) {//R.color.colorName

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window w = activity.getWindow();
                w.setNavigationBarColor(AppRes.getColor(resColor, activity));
            }
        } catch (Exception e) {
            Timber.e("Error:" + e.toString());
        }
    }


}
