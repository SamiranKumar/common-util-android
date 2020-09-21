package com.skh.hkhr.util.thread;

import com.badoo.mobile.util.WeakHandler;

import timber.log.Timber;

/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 15/07/2019.
 */
public class ThreadUtil {
    private static WeakHandler handler;
    private static Runnable runnable;

    public static void startTask(IThreadTask iThreadTask, long delayTime, boolean isRepeat) {
        stopTask();
        handler = new WeakHandler();
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
            handler.removeCallbacksAndMessages(null);
            handler = null;
            runnable = null;

        } catch (Exception e) {
            Timber.e("Error:" + e.toString());
            Timber.e("Error:" + e.toString());
        }

    }


    public interface IThreadTask {
        void doTask();
    }


}
