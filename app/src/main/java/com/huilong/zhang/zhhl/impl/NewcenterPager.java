package com.huilong.zhang.zhhl.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.huilong.zhang.zhhl.Base.BasePager;
import com.huilong.zhang.zhhl.global.GlobalContants;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by Mario on 4/1/16.
 */
public class NewcenterPager extends BasePager {
    public NewcenterPager(Activity myActivity) {
        super(myActivity);
    }

    @Override
    public void initData() {
        setSlidingMenuEnable(true);//
        tvtitle.setText("新闻中心");
        TextView textView = new TextView(myActivity);
        textView.setText("首页");
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        frameLayout.addView(textView);
        getDataFromServer();
    }

    //从服务器获取数据
    private void getDataFromServer() {
        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.POST, GlobalContants.CATEGORIES_URL, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                System.out.println(result);

            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(myActivity,s,Toast.LENGTH_LONG).show();
                e.printStackTrace();

            }
        });

    }
}
