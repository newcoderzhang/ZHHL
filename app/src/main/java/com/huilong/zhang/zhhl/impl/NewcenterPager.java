package com.huilong.zhang.zhhl.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.huilong.zhang.zhhl.Base.BaseMenuDetaiPager;
import com.huilong.zhang.zhhl.Base.BasePager;
import com.huilong.zhang.zhhl.Main2Activity;
import com.huilong.zhang.zhhl.domain.NewsData;
import com.huilong.zhang.zhhl.fragments.LeftMenuFragment;
import com.huilong.zhang.zhhl.global.GlobalContants;
import com.huilong.zhang.zhhl.menudatil.InteractMenuDetailPager;
import com.huilong.zhang.zhhl.menudatil.NewsMenuDetailPager;
import com.huilong.zhang.zhhl.menudatil.PhotoMenuDetailPager;
import com.huilong.zhang.zhhl.menudatil.TopicMenuDetailPager;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;

/**
 * Created by Mario on 4/1/16.
 */
public class NewcenterPager extends BasePager {
    private String result;

    private ArrayList<BaseMenuDetaiPager> mPagers;// 4个菜单详情页的集合

    public NewcenterPager(Activity myActivity) {
        super(myActivity);
    }

    @Override
    public void initData() {
        setSlidingMenuEnable(true);//
        tvtitle.setText("新闻中心");
        getDataFromServer();

    }

    //从服务器获取数据
    private void getDataFromServer() {
        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.POST, GlobalContants.CATEGORIES_URL, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                result = responseInfo.result;
                System.out.println(result);
                parseData(result);


            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(myActivity,s,Toast.LENGTH_LONG).show();
                e.printStackTrace();

            }
        });

    }
    protected  void parseData(String result){
        Gson gson = new Gson();
        NewsData newdData = gson.fromJson(result,NewsData.class);
        System.out.print("解析结果 + " + newdData);

        Main2Activity main2Activity = (Main2Activity) myActivity;
        LeftMenuFragment leftMenuFragement = main2Activity.getLeftMenuFragement();
        leftMenuFragement.setMenudata(newdData);

        mPagers = new ArrayList<BaseMenuDetaiPager>();
        mPagers.add(new NewsMenuDetailPager(main2Activity));
        mPagers.add(new InteractMenuDetailPager(main2Activity));
        mPagers.add(new PhotoMenuDetailPager(main2Activity));
        mPagers.add(new TopicMenuDetailPager(main2Activity));
    }
    /**
     * 设置当前菜单详情
     */
    public  void setCurrentMenuDetailPager(int position){
        BaseMenuDetaiPager pager = mPagers.get(position);//获取当前显示的菜单详情
        frameLayout.removeAllViews();
        frameLayout.addView(pager.mRootView);//当前布局设置给真布局


    }

}
