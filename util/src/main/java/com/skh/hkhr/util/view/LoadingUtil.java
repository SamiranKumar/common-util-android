package com.skh.hkhr.util.view;

import android.app.ProgressDialog;
import android.content.Context;

import timber.log.Timber;


public class LoadingUtil {

        private static ProgressDialog pd;

        public static void show(String message, Context context) {
            pd = new ProgressDialog(context);
            pd.setMessage(message);
            pd.setCancelable(false);
            pd.show();
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
                if(pd.isShowing()){
                    pd.dismiss();
                }
            }

        }catch (Exception e){
            Timber.e("Error:"+e.toString());
        }

    }
}
