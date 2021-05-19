package com.skh.hkhr.util.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.skh.hkhr.util.StringUtil;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;

import timber.log.Timber;

public class ImageLoader {

    private static boolean initializedPicasso = false;

    public static void init(Context context) {
        Timber.e("initializedPicasso:%s", initializedPicasso);
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
        Timber.e("initializedPicasso:%s", initializedPicasso);
        if (!initializedPicasso) {
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
        Timber.e("initializedPicasso:%s", initializedPicasso);
        if (!initializedPicasso) {
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


    //==========================================================================================================================
    public static void showWithPlaceholder(ImageView imageView, String url, int maxWidth, int maxHeight, int radius, int margin) {
        Timber.e("initializedPicasso:%s", initializedPicasso);
        if (!initializedPicasso) {
            return;
        }

        if (StringUtil.getNotNullString(url).isEmpty()) {
            return;
        }

        int size = (int) Math.ceil(Math.sqrt(maxWidth * maxHeight));

        Picasso.get()
                .load(url)
                .transform(new ScaleRoundedTransformation(maxWidth, maxHeight, radius, margin))
                .resize(size, size)
                .onlyScaleDown()
                .into(imageView);
    }


    //============================================================================================
    public static void showWithPlaceholder(String imageUrl, IImageLoad iImageLoad) {

        Picasso.get()
                .load(imageUrl)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        Timber.e("onBitmapLoaded success");
                        iImageLoad.finnish(bitmap);
                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                        Timber.e("onBitmapFailed:" + e.toString());
                        iImageLoad.finnish(null);
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        Timber.e("onPrepareLoad");
                    }
                });
    }
    //===========================================================================================

    public interface IImageLoad {
        void finnish(Bitmap bitmap);
    }


}
