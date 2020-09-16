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


}
