package com.skh.hkhr.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.skh.hkhr.util.log.PrintLog;
import com.skh.hkhr.util.thread.AppHandler;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class ContextUtil {

    //==============================================================================================
    public static boolean isContextNull(Context context, String message) {
        if (context == null) {
            PrintLog.printError(message);
            return true;
        }
        return false;
    }


    public static boolean isSharedPreferencesNull(SharedPreferences preferences) {
        if (preferences == null) {
            PrintLog.printError("Provide Context! Call CacheDataUtil.init(context);");
            return true;
        }
        return false;
    }

}

