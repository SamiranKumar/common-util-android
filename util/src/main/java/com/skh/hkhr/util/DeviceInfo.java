package com.skh.hkhr.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;

public class DeviceInfo {

    @SuppressLint("HardwareIds")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

}
