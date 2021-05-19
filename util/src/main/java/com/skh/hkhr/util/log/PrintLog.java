package com.skh.hkhr.util.log;

import android.util.Log;

import com.skh.hkhr.util.BuildConfig;

public class PrintLog {
    static {
        LogUtil.initializeLog("skh");
    }

    public static void print(String message) {
        //  Timber.i(message);
        if(BuildConfig.DEBUG){
            Log.i("skh", message);
        }

    }

    public static void printError(String message) {
        //  Timber.e(message);
        if(BuildConfig.DEBUG){
            Log.e("skh", message);
        }
    }



}
