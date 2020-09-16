package com.skh.hkhr.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static com.skh.hkhr.util.AppHandler.getHandler;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2017.
 */
public class KeyBoardUtility {

    /**
     * hide the soft keyboard for activity edittext of input field
     */
    public static void hideSoftKeyboard(Activity activity) {
        getHandler().post(() -> {

            if (activity.getCurrentFocus() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        });
    }


    /**
     * @param activity
     * @param view     when hide from dialog,alartDialog,fragments (edittext,Autocomplete)
     */
    public static void hideSoftKeyboard(Activity activity, View view) {
        getHandler().post(() -> {
            if (view != null && activity != null) {
                InputMethodManager im = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(view.getWindowToken(), 0);
            } else {
                //  Log.i("SKH","null");
            }
        });
    }

    /**
     * Shows the soft keyboard
     */
    public static void showSoftKeyboard(Activity activity, View view) {
        getHandler().post(() -> {
            if (activity.getCurrentFocus() == null) {

                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
                        view.requestFocus();
                        inputMethodManager.showSoftInput(view, 0);
                    }
                }, 100);

            }
        });
    }

    public static void showKeyboard(Activity activity, final View ettext) {
        ettext.requestFocus();
        ettext.postDelayed(() -> {
                    InputMethodManager keyboard = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    keyboard.showSoftInput(ettext, 0);
                }
                , 200);
    }

}
