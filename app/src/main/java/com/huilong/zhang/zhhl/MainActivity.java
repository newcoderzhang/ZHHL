package com.huilong.zhang.zhhl;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.splish_root);
        startAnim();
    }
    private  void startAnim(){
        RotateAnimation rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1*1000);
        rotateAnimation.setFillAfter(true);//保持动画后的状态

        linearLayout.startAnimation(rotateAnimation);
    }

}
