package com.skh.hkhr.util.view;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.skh.hkhr.util.thread.AppHandler;


import timber.log.Timber;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 15/07/2019.
 */
@Deprecated
public class ViewTextUtil {

    public static String getTextFromView(TextView textView) {
        return textView.getText().toString().trim();
    }

    public static String getTextFromView(EditText editText) {
        return editText.getText().toString().trim();
    }


    public static void setText(EditText editText, String text) {
        if (editText == null) {
            Timber.e("view==null");
            return;

        }
        Handler handler = AppHandler.getUiHandlerNew();
        handler.post(() -> {
            editText.setText(text);
            placeCursorAtLast(editText);

            AppHandler.destroyHandler(handler);
        });
    }

    public static void placeCursorAtLast(EditText editText) {
        if (editText == null) {
            Timber.e("view==null");
            return;

        }
        Handler handler = AppHandler.getUiHandlerNew();
        handler.post(() -> {
            String string = getTextFromView(editText);
            editText.setSelection(string.length());
            AppHandler.destroyHandler(handler);
        });
    }


    //==============================================================================================
    //@Deprecated
    public static void setVisibility(View view, int visibility) {
        if (view == null) {
            Timber.e("view==null");
            return;
        }
        Handler handler = AppHandler.getUiHandlerNew();
        handler.post(() -> {
            if (view.getVisibility() != visibility) {
                view.setVisibility(visibility);
            }
            AppHandler.destroyHandler(handler);
        });

    }


    //==========================================================================
    public static void setVisibility(View view, boolean isVisible) {
        if (view == null) {
            Timber.e("view==null");
            return;
        }

        Handler handler = AppHandler.getUiHandlerNew();
        handler.post(() -> {
            if (isVisible) {
                ViewTextUtil.setVisibility(view, View.VISIBLE);
                view.animate().alpha(1.0f);
            } else {
                view.animate().alpha(0.0f);
                ViewTextUtil.setVisibility(view, View.GONE);
            }

            AppHandler.destroyHandler(handler);
        });
    }


}
