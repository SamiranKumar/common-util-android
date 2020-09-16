package com.skh.hkhr.util.view;

import android.widget.ImageView;

import com.skh.hkhr.util.StringUtil;
import com.skh.hkhr.util.animation.RoundedTransformation;
import com.squareup.picasso.Picasso;

public class ImageLoader {


    public static void showWithPlaceholder(ImageView imageView, String url) {

        if (StringUtil.getNotNullString(url).isEmpty()) {
            return;
        }

        Picasso.get()
                .load(url)
                .fit()
                .into(imageView);
    }


    public static void showWithPlaceholder(ImageView imageView, String url, int radius, int margin) {

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
