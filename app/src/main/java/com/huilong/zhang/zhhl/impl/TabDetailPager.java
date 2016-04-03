package com.huilong.zhang.zhhl.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.huilong.zhang.zhhl.Base.BaseMenuDetaiPager;
import com.huilong.zhang.zhhl.domain.NewsData;

/**页签详情页
 * Created by Mario on 4/3/16.
 */
public class TabDetailPager extends BaseMenuDetaiPager {
    NewsData.NewsTabData mTabData;
    private TextView textView;
    public TabDetailPager(Activity activity, NewsData.NewsTabData newsTabData) {
        super(activity);
        this.mTabData = newsTabData;
    }

    @Override
    public View initView() {
        textView = new TextView(activity);
        textView.setText("页签详情页面");
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        return textView;

    }

    @Override
    public void initData() {
        textView.setText(mTabData.title);
    }
}
