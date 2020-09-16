package com.skh.hkhr.util;

import android.content.Context;
import android.widget.Toast;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class ToastUtil {

    private static Context context;

    public static void init(Context context) {
        ToastUtil.context = context;
    }


    public static void showToastMessageShort(Context context, String message) {
        showToastMessage(context, message, false);
    }


    public static void showToastMessage(String message) {
        if (context == null) {
            PrintLog.printError("Provide Context! Call ToastUtil.int(context);");
            return;
        }
        showToastMessage(context, message, true);
    }


    static void showToastMessage(Context context, String message, boolean isLongTime) {

        if (message.length() == 0) {
            return;
        }

        int showTime = Toast.LENGTH_SHORT;
        if (isLongTime) {
            showTime = Toast.LENGTH_LONG;
        }

        int finalShowTime = showTime;
        AppHandler.getHandler().post(() -> Toast.makeText(context, message, finalShowTime).show());
    }


}

