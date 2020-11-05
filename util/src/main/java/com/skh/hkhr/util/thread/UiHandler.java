package com.skh.hkhr.util.thread;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class UiHandler extends Handler {

    public UiHandler(@NonNull Looper looper) {
        super(looper);
    }

    public UiHandler(@NonNull Looper looper, @Nullable Callback callback) {
        super(looper, callback);
    }



}
