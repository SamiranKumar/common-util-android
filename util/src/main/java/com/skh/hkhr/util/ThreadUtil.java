package com.skh.hkhr.util;

import android.os.Handler;

import timber.log.Timber;

public class ThreadUtil {

    private static Handler handler;
    private static Runnable runnable;

    public static void startTask(IThreadTask iThreadTask, long delayTime) {
        stopTask();
        handler = new Handler();
        runnable = () -> {
            iThreadTask.doTask();
        };

        if (handler == null || runnable == null) {
            return;
        }

        handler.postDelayed(runnable, delayTime);

    }

    public static void stopTask() {
        try {
            handler.removeCallbacks(runnable);
            handler.removeCallbacksAndMessages(null);
            handler = null;
            runnable = null;

        }catch (Exception e){
            Timber.e("Error:"+e.toString());
        }

    }


    public interface IThreadTask {
        void doTask();
    }


}
