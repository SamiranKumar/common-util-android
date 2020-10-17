package com.skh.hkhr.util.thread;

import com.badoo.mobile.util.WeakHandler;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class AppHandler {
    private static UiHandler uiHandler = new UiHandler();

    public static WeakHandler getUiHandler() {
        if (uiHandler == null) {
            uiHandler = new UiHandler();
        }
        return uiHandler;
    }

    public static void destroyHandler() {
        uiHandler.removeCallbacksAndMessages(null);
    }

    public static UiHandler getHandlerNew() {
        return new UiHandler();
    }

}
