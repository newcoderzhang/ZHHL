package com.huilong.zhang.zhhl;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class GuideActivity extends Activity {
        private ViewPager viewPager;
        private Button button;

        private static  final  int[] mImageIds = new int[]{
                R.mipmap.guide_1,
                R.mipmap.guide_2,
                R.mipmap.guide_3};
    private ArrayList<ImageView> mImageViewList;

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
    }
    private void initData(){
        mImageViewList = new ArrayList<ImageView>();
        for (int i=0;i<mImageIds.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(mImageIds[i]);
            mImageViewList.add(imageView);
        }
        viewPager.setAdapter(new GuideAdapter());

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
}
