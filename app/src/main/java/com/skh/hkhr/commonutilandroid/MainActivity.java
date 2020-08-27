package com.skh.hkhr.commonutilandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.skh.hkhr.util.LogUtil;
import com.skh.hkhr.util.PrintLog;
import com.skh.hkhr.util.StringUtil;
import com.skh.hkhr.util.view.ImageLoader;
import com.skh.hkhr.util.view.OnSingleClickListener;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        LogUtil.initializeLog("HHHKKK");
        PrintLog.print("hkhr");

        String capitalizeSentences = StringUtil.getCapitalizeSentences("hkhkhrhr hkhkhrhr");
        PrintLog.print(capitalizeSentences);

       // ImageLoader.showWithPlaceholder(imageView, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTEB-0Ce1lQdCmrXLFSIhOP8-SHL1Amuq54Jg&usqp=CAU");
        ImageLoader.showWithPlaceholder(imageView, "https://cdn.icon-icons.com/icons2/2119/PNG/512/google_icon_131222.png");
        ImageLoader.showWithPlaceholder(imageView, "https://developer.android.com/guide/practices/ui_guidelines/images/Single_Icon_Parallax_Demo_01_2x_ext.gif");

        imageView.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                PrintLog.print("Click");
            }
        });
    }
}
