package com.huilong.zhang.zhhl.Base;

import android.app.Activity;
import android.view.View;

/**
 * Created by Mario on 4/3/16.
 */
public abstract class BaseMenuDetaiPager {
    public Activity activity;
    public View mRootView;

    public BaseMenuDetaiPager(Activity activity) {
        this.activity = activity;
        mRootView = initView();
    }


    /**
     * 初始化界面
     * @return
     */
    public abstract View initView();

    /**
     * 初始化数据
     */
    public void initData(){}
}
