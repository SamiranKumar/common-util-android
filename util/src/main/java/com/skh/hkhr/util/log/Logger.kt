package com.skh.hkhr.util.log

import android.util.Log

object Logg {
    private fun tag(): String? {
        return Thread.currentThread().stackTrace[4].let {
            "App# ${it.className.substringAfterLast(".")}.${it.methodName}(${it.fileName}:${it.lineNumber})"
        }
    }

    fun v(msg: String?) {
        Log.v(tag(), "" + msg)
    }

    fun d(msg: String?) {
        Log.d(tag(), "" + msg)
    }

    fun i(msg: String?) {
        Log.i(tag(), "" + msg)
    }

    fun w(msg: String?) {
        Log.w(tag(), "" + msg)
    }

    fun w(e: Throwable?) {
        Log.w(tag(), "" + e?.localizedMessage)
    }

    fun w(e: Exception?) {
        Log.w(tag(), "" + e?.localizedMessage)
    }

    fun e(msg: String?) {
        Log.e(tag(), "" + msg)
    }
}