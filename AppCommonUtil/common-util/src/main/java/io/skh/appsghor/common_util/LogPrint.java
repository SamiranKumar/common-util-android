package io.skh.appsghor.common_util;

import android.util.Log;

public class LogPrint implements ILogPrint {
    private static final String LOG_NAME = "SKH_LOG";
    private static LogPrint logPrint;

    public static synchronized LogPrint getInstances() {
        if (logPrint != null) {
            return logPrint;
        } else {
            logPrint = new LogPrint();
            return logPrint;
        }
    }

    private LogPrint() {
        new LogPrint();
    }

    @Override
    public void print(String message) {
        print(LOG_NAME, message);
    }

    @Override
    public void print(String tag, String message) {
        Log.i(tag, message);
    }
}
