package com.skh.hkhr.util;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

import timber.log.Timber;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class FontsOverrideUtil {

    public static void setDefaultFont(String staticTypefaceFieldName, String fontAssetName, Context context) {
        try {
            final Typeface regular = Typeface.createFromAsset(context.getAssets(), fontAssetName);
            replaceFont(staticTypefaceFieldName, regular);
        } catch (Exception e) {
            Timber.e("Error:" + e.toString());
        }

    }

    protected static void replaceFont(String staticTypefaceFieldName, final Typeface newTypeface) {
        try {

            final Field staticField = Typeface.class.getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);

        } catch (NoSuchFieldException e) {
            Timber.d("Error:" + e.toString());
        } catch (IllegalAccessException e) {
            Timber.d("Error:" + e.toString());
        }
    }

}

