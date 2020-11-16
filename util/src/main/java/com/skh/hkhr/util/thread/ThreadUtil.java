package com.skh.hkhr.util.thread;

import android.os.Handler;


import timber.log.Timber;

/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 15/07/2019.
 */
public class ThreadUtil {
    private static Handler handler;
    private static Runnable runnable;

    public static void startTask(IThreadTask iThreadTask, long delayTime, boolean isRepeat) {
        handler = AppHandler.getBackgroundHandler();
        startTask(iThreadTask, delayTime, isRepeat, handler);
    }

    public static void startUiTask(IThreadTask iThreadTask, long delayTime, boolean isRepeat) {
        handler = AppHandler.getUiHandlerNew();
        startTask(iThreadTask, delayTime, isRepeat, handler);
    }


    private static void startTask(IThreadTask iThreadTask, long delayTime, boolean isRepeat, final Handler handler) {
        stopTask();

        runnable = () -> {
            iThreadTask.doTask();

            if (isRepeat) {
                handler.postDelayed(runnable, delayTime);
            }
        };

        if (handler == null || runnable == null) {
            return;
        }

        handler.postDelayed(runnable, delayTime);
    }


    public static void stopTask() {
        if (handler == null) return;
        try {
            handler.removeCallbacks(runnable);
            AppHandler.destroyHandler(handler);
            runnable = null;

        } catch (Exception e) {
            Timber.e("Error:" + e.toString());
        }

    }


    public interface IThreadTask {
        void doTask();
    }


}
