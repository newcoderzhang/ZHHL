package com.huilong.zhang.zhhl.fragments;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.huilong.zhang.zhhl.Base.BasePager;
import com.huilong.zhang.zhhl.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by Mario on 3/29/16.
 */
public class ContentFragment extends  BaseFragment {

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

         for (int i = 0; i < 5; i++) {
         BasePager pager = new BasePager(activity);
             mpPagerlist.add(pager);
         }

        viewPager.setAdapter(contentAdapter);

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
            container.addView(mpPagerlist.get(position).mRootView);
            return mpPagerlist.get(position).mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
