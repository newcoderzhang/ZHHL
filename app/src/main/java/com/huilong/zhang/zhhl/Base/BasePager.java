package com.huilong.zhang.zhhl.Base;

import android.app.Activity;
import android.view.View;

import com.huilong.zhang.zhhl.R;

/**
 * Created by Mario on 4/1/16.
 * 主页面下5个子页面的基类
 */
public class BasePager {
    public Activity myActivity;
    public View mRootView;// 布局对象

    public BasePager(Activity myActivity) {
        this.myActivity = myActivity;
        initView();
    }
    public void initView(){
        mRootView = View.inflate(myActivity, R.layout.base_pager,null);


    }
    public void initData(){

    }
}
