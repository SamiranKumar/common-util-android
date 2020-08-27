package com.skh.hkhr.util.view;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.skh.hkhr.util.AppController;

import timber.log.Timber;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 15/07/2019.
 */
public interface ViewTextUtil {

    static String getTextFromView(TextView textView) {
        return textView.getText().toString().trim();
    }

    static String getTextFromView(EditText editText) {
        return editText.getText().toString().trim();
    }


    static void setVisibility(View view, int visibility) {
        if (view == null) {
            Timber.e("view==null");
            return;
        }
        AppController.getHandler().post(() -> {
            if (view.getVisibility() != visibility) {
                view.setVisibility(visibility);
            }
        });

    }
}
