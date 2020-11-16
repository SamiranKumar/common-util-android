package com.skh.hkhr.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class DeviceInfo {

    @SuppressLint("HardwareIds")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

}
