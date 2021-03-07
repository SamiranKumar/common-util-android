package com.skh.hkhr.util.image;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

import com.squareup.picasso.Transformation;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 23/06/2018.
 */
public class RoundedTransformation implements Transformation {
    private final int margin;
    private final int radius;

    public String key() {
        return "rounded";
    }

    public RoundedTransformation(int radius, int margin) {
        this.radius = radius;
        this.margin = margin;
    }

    public Bitmap transform(Bitmap bitmap) {
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
        return createBitmap;
    }
}