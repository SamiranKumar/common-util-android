package com.skh.hkhr.util.thread;

import android.os.Handler;
import android.os.Looper;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class AppHandler {
    private static Handler uiHandler;
    private static Handler backgroundHandler;


    //==============================================================================================
    public static Handler getActivityHandler() {
        if (uiHandler == null) {
            uiHandler = getUiHandlerNew();
        }
        return uiHandler;
    }

    public static void destroyActivityHandler() {
        destroyHandler(uiHandler);
    }


    //==============================================================================================
    public static Handler getBackgroundHandler() {
        if (backgroundHandler == null) {
            backgroundHandler = getBackgroundHandlerNew();
        }
        return backgroundHandler;
    }

    public static void destroyBackgroundHandler() {
        destroyHandler(backgroundHandler);
    }


    //==============================================================================================

    public static void destroyHandler(Handler handler) {
        handler.removeCallbacksAndMessages(null);
        handler = null;
    }
    //==============================================================================================

    public static Handler getUiHandlerNew() {
        return new Handler(Looper.getMainLooper());
    }


    public static Handler getBackgroundHandlerNew() {
        return new Handler(Looper.myLooper());
    }


}
