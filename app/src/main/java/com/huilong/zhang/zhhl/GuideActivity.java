package com.huilong.zhang.zhhl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.huilong.zhang.zhhl.packages.PrefUtils;

import java.util.ArrayList;

public class GuideActivity extends Activity {
        private ViewPager viewPager;
        private Button button;
        private LinearLayout linearLayout;
        private View viewRedPoint;

        private static  final  int[] mImageIds = new int[]{
                R.mipmap.guide_1,
                R.mipmap.guide_2,
                R.mipmap.guide_3};
    private ArrayList<ImageView> mImageViewList;
    private int mPointWidth; //圆点间的距离

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);
        init();
        initData();
    }
    private void init(){
        viewPager = (ViewPager) findViewById(R.id.vp_guade);
        linearLayout = (LinearLayout) findViewById(R.id.point_group);
        viewRedPoint = findViewById(R.id.viewpoint);
        button = (Button) findViewById(R.id.button1);
    }
    private void initData(){

        mImageViewList = new ArrayList<ImageView>();

        for (int i=0;i<mImageIds.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(mImageIds[i]);
            mImageViewList.add(imageView);
        }



        //动态添加小圆点
        for (int i=0;i<mImageIds.length;i++){
            View view = new View(this);
            view.setBackgroundResource(R.drawable.shape_point_gray);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10,10);
            if(i>0){
                params.leftMargin = 10;
            }
            view.setLayoutParams(params);

            linearLayout.addView(view);
        }
        // 获取视图树, 对layout结束事件进行监听
        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    // 当layout执行结束后回调此方法
                    @Override
                    public void onGlobalLayout() {
                        System.out.println("layout 结束");
                        linearLayout.getViewTreeObserver()
                                .removeGlobalOnLayoutListener(this);
                        mPointWidth = linearLayout.getChildAt(1).getLeft()
                                - linearLayout.getChildAt(0).getLeft();
                        System.out.println("圆点距离:" + mPointWidth);
                    }
                });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefUtils.setBoolean(GuideActivity.this,"is_user_gudide_first_show",true);
                startActivity(new Intent(GuideActivity.this,Main2Activity.class));
                finish();
            }
        });
        viewPager.setAdapter(new GuideAdapter());
        viewPager.setOnPageChangeListener(new GuidePagerListener());

    }
    class GuideAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mImageIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view ==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mImageViewList.get(position));
            return mImageViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    /**
     * 滑动监听类
     */
    class GuidePagerListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            System.out.println("当前位置:" + position + "百分比" + positionOffsetPixels);
            int len = (int) (mPointWidth * positionOffset) + position
                    * mPointWidth;
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewRedPoint.getLayoutParams();// 获取当前红点的布局参数
            params.leftMargin = len;// 设置左边距

            viewRedPoint.setLayoutParams(params);// 重新给小红点设置布局参数

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
