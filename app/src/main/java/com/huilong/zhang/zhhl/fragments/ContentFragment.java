package com.huilong.zhang.zhhl.fragments;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.huilong.zhang.zhhl.Base.BasePager;
import com.huilong.zhang.zhhl.R;
import com.huilong.zhang.zhhl.impl.GovAffairPager;
import com.huilong.zhang.zhhl.impl.HomePager;
import com.huilong.zhang.zhhl.impl.NewcenterPager;
import com.huilong.zhang.zhhl.impl.SettingPager;
import com.huilong.zhang.zhhl.impl.SmartService;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by Mario on 3/29/16.
 */
public class ContentFragment extends BaseFragment {

    private static final String TAG = "ContentFragment";
    @ViewInject(R.id.rg_group)
    private RadioGroup radioGroup;

    @ViewInject(R.id.vp_content)
    private ViewPager viewPager;


    private ArrayList<BasePager> mpPagerlist;
    private ContentAdapter contentAdapter;
    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.fragment_content, null);
        ViewUtils.inject(this,view);//注入当前view和事件
        return view;
    }

    @Override
    public void initData() {
        mpPagerlist = new ArrayList<BasePager>();
        contentAdapter = new ContentAdapter();
        radioGroup.check(R.id.rb_home);


         /*for (int i = 0; i < 5; i++) {
         BasePager pager = new BasePager(activity);
             mpPagerlist.add(pager);
         }*/
        mpPagerlist.add(new HomePager(activity));
        mpPagerlist.add(new NewcenterPager(activity));
        mpPagerlist.add(new SmartService(activity));
        mpPagerlist.add(new GovAffairPager(activity));
        mpPagerlist.add(new SettingPager(activity));


        viewPager.setAdapter(contentAdapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        viewPager.setCurrentItem(0);
                        Log.v(TAG,"home");
                        break;
                    case R.id.rb_news:
                        viewPager.setCurrentItem(1);
                        Log.v(TAG,"rb_news");
                        break;
                    case R.id.rb_smart:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb_gov:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.rb_settings:
                        viewPager.setCurrentItem(4);
                        break;
                    default:break;

                }

            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                mpPagerlist.get(position).initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mpPagerlist.get(0).initData();


    }
    class ContentAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mpPagerlist.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //return super.instantiateItem(container, position);

            BasePager basePager = mpPagerlist.get(position);
            container.addView(mpPagerlist.get(position).mRootView);
            //basePager.initData();
            return mpPagerlist.get(position).mRootView;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
