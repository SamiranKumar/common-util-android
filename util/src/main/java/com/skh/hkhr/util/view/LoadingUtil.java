package com.skh.hkhr.util.view;

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


    public static void show(Context context, boolean hideAuto, long mileSec) {
        show(context);

        if (hideAuto) {
            AppHandler.getUiHandlerNew().postDelayed(() -> hide(), mileSec);
        }
    }

    public static void show(Context context) {
        pd = new ProgressDialog(context);
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
