package com.skh.hkhr.util.thread;

import com.badoo.mobile.util.WeakHandler;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class AppHandler {
    private static WeakHandler handler = new WeakHandler();

    public static WeakHandler getHandler() {
        if (handler == null) {
            handler = new WeakHandler();
        }
        return handler;
    }

    public static void destroyHandler() {
        handler.removeCallbacksAndMessages(null);
    }

    public static WeakHandler getHandlerNew() {
        return new WeakHandler();
    }

}
