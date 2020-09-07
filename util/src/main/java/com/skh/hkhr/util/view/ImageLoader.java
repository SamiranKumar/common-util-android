package com.skh.hkhr.util.view;

import android.widget.ImageView;

import com.skh.hkhr.util.StringUtil;
import com.squareup.picasso.Picasso;

public class ImageLoader {


    public static void showWithPlaceholder(ImageView imageView, String url) {

        if (StringUtil.getNotNullString(url).isEmpty()) {
            return;
        }

        Picasso.get()
                .load(url)
                .fit()
                //.transform(new RoundedTransformation(35, 0))
                .into(imageView);
    }
}
