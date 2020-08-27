package com.skh.hkhr.util;

import android.util.Log;

import timber.log.Timber;

public class PrintLog {
    static {
        LogUtil.initializeLog("skh");
    }

    public static void print(String message) {
        //  Timber.i(message);
        Log.i("skh", message);
    }

    public static void printError(String message) {
        //  Timber.e(message);
        Log.e("skh", message);
    }
}
