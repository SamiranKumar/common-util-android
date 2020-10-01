package com.skh.hkhr.util;

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

}
