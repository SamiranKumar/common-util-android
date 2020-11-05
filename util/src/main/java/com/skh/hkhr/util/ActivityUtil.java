package com.skh.hkhr.util;

import android.app.Activity;
import android.content.Intent;

public class ActivityUtil {

    private void changeLayout(Class activityClass, Activity activity) {
        activity.startActivity(new Intent(activity, activityClass).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        activity.finish();
    }

    private void changeLayout1(Class activityClass, Activity activity) {
        activity.startActivity(new Intent(activity, activityClass));
        activity.finish();
    }

    private void changeLayout2(Class activityClass, Activity activity) {
        activity.startActivity(new Intent(activity, activityClass));
    }
}
