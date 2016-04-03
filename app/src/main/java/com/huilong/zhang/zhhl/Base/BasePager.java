package com.huilong.zhang.zhhl.Base;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.huilong.zhang.zhhl.Main2Activity;
import com.huilong.zhang.zhhl.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by Mario on 4/1/16.
 * 主页面下5个子页面的基类
 */
public class BasePager {
    private static final String TAG = "BasePager";
    public Activity myActivity;
    public View mRootView;// 布局对象


    public TextView tvtitle;
    public FrameLayout frameLayout;
    public ImageButton btnMenu;// 菜单按钮


    public BasePager(Activity myActivity) {
        this.myActivity = myActivity;
        initView();
    }
    public void initView(){
        mRootView = View.inflate(myActivity, R.layout.base_pager,null);

        tvtitle = (TextView) mRootView.findViewById(R.id.tv_title);
        frameLayout = (FrameLayout) mRootView.findViewById(R.id.fr_content);
        btnMenu = (ImageButton) mRootView.findViewById(R.id.btn_menu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"here");
                toggleSlidingMenu();
            }
        });
    }

    public void toggleSlidingMenu() {
        Main2Activity mainUi = ((Main2Activity) myActivity);
        SlidingMenu slidingMenu = mainUi.getSlidingMenu();
        slidingMenu.toggle();// 切换状态, 显示时隐藏, 隐藏时显示
    }
    public void initData(){

    }
    /**
     * 设置侧边栏开启或关闭
     *
     * @param enable
     */
    public void setSlidingMenuEnable(boolean enable) {
        Main2Activity mainUi = (Main2Activity) myActivity;

        SlidingMenu slidingMenu = mainUi.getSlidingMenu();

        if (enable) {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        } else {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
    }
}
