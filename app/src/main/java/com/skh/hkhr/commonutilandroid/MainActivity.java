package com.skh.hkhr.commonutilandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.skh.hkhr.util.StringUtil;


import com.skh.hkhr.util.log.LogUtil;
import com.skh.hkhr.util.log.PrintLog;
import com.skh.hkhr.util.log.ToastUtil;
import com.skh.hkhr.util.image.ImageLoader;
import com.skh.hkhr.util.view.OnSingleClickListener;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        LogUtil.initializeLog("HHHKKK");
        ToastUtil.init(this);
        PrintLog.print("hkhr");
        ImageLoader.init(getApplicationContext());
        String capitalizeSentences = StringUtil.getCapitalizeSentences("hkhkhrhr hkhkhrhr");
        PrintLog.print(capitalizeSentences);

         ImageLoader.showWithPlaceholder(imageView, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTEB-0Ce1lQdCmrXLFSIhOP8-SHL1Amuq54Jg&usqp=CAU");
        // ImageLoader.showWithPlaceholder(imageView, "https://cdn.icon-icons.com/icons2/2119/PNG/512/google_icon_131222.png");
        // ImageLoader.showWithPlaceholder(imageView, "https://developer.android.com/guide/practices/ui_guidelines/images/Single_Icon_Parallax_Demo_01_2x_ext.gif");
       // ImageLoader.showWithPlaceholder(imageView1, "https://www.selectfashion.co.uk/templates/selectfashion.co.uk.new/assets/images/landing/plussize/banner.jpg",2000,800,15,0);//big image
        // ImageLoader.showWithPlaceholder1(imageView, "https://images.unsplash.com/photo-1512850183-6d7990f42385?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",1000,1000);//big image

        imageView.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                ImageLoader.init(getApplicationContext());
                ToastUtil.showToastMessage("Click");
                ImageLoader.showWithPlaceholder(imageView, "https://developer.android.com/guide/practices/ui_guidelines/images/Single_Icon_Parallax_Demo_01_2x_ext.gif");

                // Logg
            }
        });
    }
}
