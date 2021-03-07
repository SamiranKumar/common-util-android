package com.skh.hkhr.util.image;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

import com.skh.hkhr.util.log.PrintLog;
import com.squareup.picasso.Transformation;

import timber.log.Timber;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 23/06/2021.
 */
public class ScaleRoundedTransformation implements Transformation {
    private final int margin;
    private final int radius;
    private final int maxWidth;
    private final int maxHeight;


    public String key() {
        return "rounded";
    }

    public ScaleRoundedTransformation(int maxWidth, int maxHeight, int radius, int margin) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.radius = radius;
        this.margin = margin;
    }

    public Bitmap transform(Bitmap source) {

        int targetWidth, targetHeight;
        double aspectRatio;
        PrintLog.print("===================================");
        PrintLog.print("Width:" + source.getWidth());
        PrintLog.print("Height:" + source.getHeight());


        if (source.getWidth() > source.getHeight()) {
            targetWidth = maxWidth;
            aspectRatio = (double) source.getHeight() / (double) source.getWidth();
            targetHeight = (int) (targetWidth * aspectRatio);
        } else {
            targetHeight = maxHeight;
            aspectRatio = (double) source.getWidth() / (double) source.getHeight();
            targetWidth = (int) (targetHeight * aspectRatio);
        }

        Bitmap bitmap = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, true);
        if (bitmap != source) {
            source.recycle();
        }


        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int margin = this.margin;
        RectF rectF = new RectF((float) margin, (float) margin, (float) (bitmap.getWidth() - this.margin), (float) (bitmap.getHeight() - this.margin));
        int radius = this.radius;
        canvas.drawRoundRect(rectF, (float) radius, (float) radius, paint);
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }

        PrintLog.print("Width:" + createBitmap.getWidth());
        PrintLog.print("Height:" + createBitmap.getHeight());

        PrintLog.print("===================================");
        return createBitmap;
    }
}