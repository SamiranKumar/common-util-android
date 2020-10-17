package com.skh.hkhr.util.view;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.skh.hkhr.util.thread.AppHandler;

import timber.log.Timber;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 15/07/2019.
 */
public class ViewTextUtil {

    public static String getTextFromView(TextView textView) {
        return textView.getText().toString().trim();
    }

    public static String getTextFromView(EditText editText) {
        return editText.getText().toString().trim();
    }


    //@Deprecated
    public static void setVisibility(View view, int visibility) {
        if (view == null) {
            Timber.e("view==null");
            return;
        }
        AppHandler.getUiHandler().post(() -> {
            if (view.getVisibility() != visibility) {
                view.setVisibility(visibility);
            }
        });

    }


    //==========================================================================
    public static void setVisibility(View view, boolean isVisible) {
        if (view == null) {
            Timber.e("view==null");
            return;
        }

        AppHandler.getUiHandler().post(() -> {
            if (isVisible) {
                ViewTextUtil.setVisibility(view, View.VISIBLE);
                view.animate().alpha(1.0f);
            } else {
                view.animate().alpha(0.0f);
                ViewTextUtil.setVisibility(view, View.GONE);
            }

        });
    }


}
