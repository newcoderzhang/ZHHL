package com.huilong.zhang.zhhl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.huilong.zhang.zhhl.packages.PrefUtils;

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

        AnimationSet set = new AnimationSet(false);
        //旋转动画 
        RotateAnimation rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1*1000);
        rotateAnimation.setFillAfter(true);//保持动画后的状态
        //缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(1*1000);
        scaleAnimation.setFillAfter(true);//保持动画后的状态
        //缩放动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(1*1000);
        alphaAnimation.setFillAfter(true);//保持动画后的状态

        set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("SplishActivity","动画播放完了");
                jumpNextPage();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        linearLayout.startAnimation(set);
    }
    /**
     * 跳转到下一个页面
     *
     */
    private  void jumpNextPage(){
        boolean userGuide = PrefUtils.getBoolean(getApplicationContext(),"is_user_gudide_first_show",false);
        if(!userGuide){
            startActivity(new Intent(MainActivity.this,GuideActivity.class));
        }else {
            startActivity(new Intent(MainActivity.this,Main2Activity.class));
        }
        finish();
    }

}
