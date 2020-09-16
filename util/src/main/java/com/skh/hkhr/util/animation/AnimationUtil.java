package com.skh.hkhr.util.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;

import androidx.recyclerview.widget.RecyclerView;


/***
 * @DEV #SamiranKumar11
 * @Created by Samiran on 1/02/2018.
 */
public class AnimationUtil {

    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown) {

        //    getHandler().post(() -> {
        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(
                holder.itemView, "translationY",
                goesDown == true ? 100 : 100, 0
        );

        animatorTranslateY.setDuration(300);
        ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView, "translationX", 0);
        animatorTranslateX.setDuration(800);
        animatorSet.playTogether(animatorTranslateX, animatorTranslateY);
        animatorSet.start();
        // }

    }

}
