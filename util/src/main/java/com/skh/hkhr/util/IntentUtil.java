package com.skh.hkhr.util;

import android.app.Activity;
import android.content.Intent;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class IntentUtil {

    public static String getIntentValue(String intentKeyName, Intent intent) {
        String intentValue = intent == null ? "" : intent.getStringExtra(intentKeyName);
        return StringUtil.getNotNullString(intentValue);
    }

    public static int getIntentIntValue(String intentKeyName, Intent intent) {
        int intentValue = intent == null ? 0 : intent.getIntExtra(intentKeyName, 0);
        return intentValue;
    }

    public static boolean getIntentBooleanValue(String intentKeyName, Intent intent) {
        boolean intentValue = intent == null ? false : intent.getBooleanExtra(intentKeyName, false);
        return intentValue;
    }

    public static void addClearActivity(Intent intent) {
        if (intent != null)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    }





    public static String INTENT_DATA_MODEL = "data_model";

    public static void goActivity(Activity activity, Class activityClass) {
        activity.startActivity(new Intent(activity, activityClass));
    }

    public static <T> void goActivity(Activity activity, Class<T> model, Class activityClass) {
        String json = JsonUtil.getJsonStringFromObject(model);
        Intent intent = new Intent(activity, activityClass);
        intent.putExtra(INTENT_DATA_MODEL, json);
        activity.startActivity(intent);
    }


    public static void goActivityWithFinnish(Activity activity, Class activityClass) {
        activity.startActivity(new Intent(activity, activityClass));
        activity.finish();
    }

    public static void goActivityCleatAllTop(Activity activity, Class activityClass) {
        Intent intent = new Intent(activity, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

}
