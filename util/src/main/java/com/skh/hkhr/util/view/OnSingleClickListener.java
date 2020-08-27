package com.skh.hkhr.util.view;

import android.os.SystemClock;
import android.view.View;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 25/04/2019.
 */
public abstract class OnSingleClickListener implements View.OnClickListener {

    private static final long MIN_CLICK_INTERVAL = 1000;
    private long mLastClickTime;


    @Override
    public final void onClick(View v) {

        long currentClickTime = SystemClock.uptimeMillis();
        long elapsedTime = currentClickTime - mLastClickTime;
        mLastClickTime = currentClickTime;

        if (elapsedTime <= MIN_CLICK_INTERVAL)
            return;

        onSingleClick(v);
    }

    public abstract void onSingleClick(View v);

}