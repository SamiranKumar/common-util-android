package com.skh.hkhr.util.log;

import android.util.Log;

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
