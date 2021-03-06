package com.skh.hkhr.util.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

import com.skh.hkhr.util.thread.AppHandler;

import timber.log.Timber;


public class LoadingUtil {

    private static ProgressDialog pd;

    public static void show(String message, Context context) {
        pd = new ProgressDialog(context);
        pd.setMessage(message);
        pd.setCancelable(false);
        pd.show();
    }


    public static void show(Activity activity, boolean hideAuto, long mileSec) {
        show(activity);

        if (hideAuto) {
            AppHandler.getUiHandlerNew().postDelayed(() -> hide(), mileSec);
        }
    }

    public static void show(Activity activity) {
        pd = new ProgressDialog(activity);
        pd.setMessage("Please Wait..");
        pd.setCancelable(false);
        pd.show();
    }

    public static void hide() {
        try {
            if (pd != null) {
                if (pd.isShowing()) {
                    pd.dismiss();
                    pd.cancel();
                }
            }

        } catch (Exception e) {
            Timber.e("Error:" + e.toString());
        }
    }

}
