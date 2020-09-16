package com.skh.hkhr.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.view.View;

import timber.log.Timber;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class NetUtil {

    public static final String CONNECTION_MOBILE = "Mobile";
    public static final String CONNECTION_WIFI = "Wifi";

    public static Context context;

    public static void initNetUtil(Context context) {
        NetUtil.context = context;
    }


    // Check Internet Connection Method
    public static boolean isNetworkAvailable(Context context, View view) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }

  /*      if (activeNetworkInfo == null) {
            Snackbar.make(view, "No internet connection!", Snackbar.LENGTH_LONG).setAction("Go To Settings", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setGoToSettings(context);
                }
            }).show();
        }*/
        return activeNetworkInfo != null;
    }


    public static boolean isNetworkAvailable() {
        if (context == null) return false;

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;

        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }

        return activeNetworkInfo != null;
    }


    public static void setGoToSettings(Context context) {
        context.startActivity(new Intent(Settings.ACTION_SETTINGS));
    }


    public static String getConnectionType() {
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        String state = "";
        if (conMan == null) return "";
        if (conMan.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                conMan.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING) {
            Timber.v(CONNECTION_MOBILE);
            state = CONNECTION_MOBILE;
            return state;

            //mobile
        } else if (conMan.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ||
                conMan.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING) {
            //wifi
            Timber.v(CONNECTION_MOBILE);
            state = CONNECTION_WIFI;
            return state;

        }
        return state;
    }

}
