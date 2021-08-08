package com.skh.hkhr.util.view;

import android.view.View;

import timber.log.Timber;

public abstract class DoubleClickListener implements View.OnClickListener {

    private static final long DOUBLE_CLICK_TIME_DELTA = 300;//milliseconds
    private static final long MIN_CLICK_INTERVAL = 500;

    long lastClickTime = 0;

    @Override
    public void onClick(View v) {
        long clickTime = System.currentTimeMillis();
        long elapsedTime = clickTime - lastClickTime;


        if (elapsedTime < DOUBLE_CLICK_TIME_DELTA) {
            lastClickTime = 0;
            Timber.e("elapsedTime time:" + elapsedTime);


            onDoubleClick(v);
        } else {
            lastClickTime = clickTime;
        }
        //  Timber.e("===================================");
    }


    public abstract void onDoubleClick(View v);
}
