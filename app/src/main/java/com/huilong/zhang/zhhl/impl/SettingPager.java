package com.huilong.zhang.zhhl.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.huilong.zhang.zhhl.Base.BasePager;

/**
 * Created by Mario on 4/1/16.
 */
public class SettingPager extends BasePager {
    public SettingPager(Activity myActivity) {
        super(myActivity);
    }

    @Override
    public void initData() {
        tvtitle.setText("设置");
        TextView textView = new TextView(myActivity);
        textView.setText("设置");
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        frameLayout.addView(textView);
    }
}
