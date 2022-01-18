package com.skh.hkhr.util.log;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.skh.hkhr.util.ContextUtil;
import com.skh.hkhr.util.NullRemoveUtil;
import com.skh.hkhr.util.thread.AppHandler;


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
        if (ContextUtil.isContextNull(context, "Provide Context! Call ToastUtil.init(context);")) {
            return;
        }
        showToastMessage(context, NullRemoveUtil.getNotNull(message), true);
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
        Handler handler = AppHandler.getUiHandlerNew();
        handler.post(() -> {
                    Toast.makeText(context, message, finalShowTime).show();
                    AppHandler.destroyHandler(handler);
                }
        );
    }


    //==============================================================================================

}

