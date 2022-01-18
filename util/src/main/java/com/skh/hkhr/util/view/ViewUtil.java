package com.skh.hkhr.util.view;

import android.graphics.Typeface;
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

public class ViewUtil {

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
                ViewUtil.setVisibility(view, View.VISIBLE);
                view.animate().alpha(1.0f);
            } else {
                view.animate().alpha(0.0f);
                ViewUtil.setVisibility(view, View.GONE);
            }

            AppHandler.destroyHandler(handler);
        });
    }


    //==========================================================================
    public static void setTextBold(TextView textView, boolean isBold) {
        if (isBold) {
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        } else {
            textView.setTypeface(textView.getTypeface(), Typeface.NORMAL);
        }
    }


    public static void setTextViewColor(TextView textView, int color) {
        textView.setTextColor(color);
    }
}
