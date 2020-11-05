package com.skh.hkhr.util.thread;

import android.os.Looper;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class AppHandler {
    private static UiHandler uiHandler;

    public static UiHandler getUiHandler() {
        if (uiHandler == null) {
            uiHandler = new UiHandler(Looper.myLooper());
        }
        return uiHandler;
    }

    public static void destroyHandler() {
        uiHandler.removeCallbacksAndMessages(null);
    }

    public static UiHandler getHandlerNew() {
        return new UiHandler(Looper.getMainLooper());
    }

}
