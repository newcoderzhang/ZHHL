package com.huilong.zhang.zhhl.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.huilong.zhang.zhhl.Base.BasePager;

/**
 * Created by Mario on 4/1/16.
 */
public class GovAffairPager extends BasePager {
    public GovAffairPager(Activity myActivity) {
        super(myActivity);
    }

    @Override
    public void initData() {
        setSlidingMenuEnable(true);// 打开侧边栏
        tvtitle.setText("政务服务");
        TextView textView = new TextView(myActivity);
        textView.setText("人口管理");
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        frameLayout.addView(textView);
    }
}
