package com.skh.hkhr.util.view;

import android.content.Context;
import android.widget.ImageView;

import com.skh.hkhr.util.StringUtil;
import com.skh.hkhr.util.animation.RoundedTransformation;
import com.skh.hkhr.util.log.ToastUtil;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

public class ImageLoader {

    private static boolean initializedPicasso = false;

    public static void init(Context context) {
        Timber.e("initializedPicasso:" + initializedPicasso);
        if (initializedPicasso) {
            return;
        }
        try {
            Picasso.setSingletonInstance(new Picasso.Builder(context).build());
        } catch (Exception e) {
            Timber.e("Error:" + e.toString());
        }

        initializedPicasso = true;
    }

    public static void showWithPlaceholder(ImageView imageView, String url) {
        if (initializedPicasso == false) {
            Timber.e("initializedPicasso:" + initializedPicasso);
            return;
        }

        if (StringUtil.getNotNullString(url).isEmpty()) {
            return;
        }

        Picasso.get()
                .load(url)
                .fit()
                .into(imageView);
    }


    public static void showWithPlaceholder(ImageView imageView, String url, int radius, int margin) {
        if (initializedPicasso == false) {
            Timber.e("initializedPicasso:" + initializedPicasso);
            return;
        }

        if (StringUtil.getNotNullString(url).isEmpty()) {
            return;
        }

        Picasso.get()
                .load(url)
                .fit()
                .transform(new RoundedTransformation(radius, margin))
                .into(imageView);
    }
}
