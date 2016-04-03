package com.huilong.zhang.zhhl.menudatil;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.huilong.zhang.zhhl.Base.BaseMenuDetaiPager;
import com.huilong.zhang.zhhl.R;
import com.huilong.zhang.zhhl.domain.NewsData;
import com.huilong.zhang.zhhl.impl.TabDetailPager;

import java.util.ArrayList;

/**新闻详情页
 * Created by Mario on 4/3/16.
 */
public class NewsMenuDetailPager extends BaseMenuDetaiPager{
    private ViewPager viewPager;

    private ArrayList<TabDetailPager> mPagerList;

    private ArrayList<NewsData.NewsTabData> mNewsTabData;// 页签网络数据
    private MenuDetailAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.news_menu_detail,null);
        viewPager = (ViewPager) view.findViewById(R.id.vp_menu_detail);
        return view;
    }

    public NewsMenuDetailPager(Activity activity) {
        super(activity);
    }

    public NewsMenuDetailPager(Activity activity, ArrayList<NewsData.NewsTabData> mNewsTabData) {
        super(activity);
        this.mNewsTabData = mNewsTabData;
    }

    @Override
    public void initData() {
        adapter = new MenuDetailAdapter();
        mPagerList = new ArrayList<TabDetailPager>();
        for(int i= 0;i<mNewsTabData.size();i++){
            TabDetailPager tabDetailPager = new TabDetailPager(activity,mNewsTabData.get(i));
            mPagerList.add(tabDetailPager);
        }
        viewPager.setAdapter(adapter);

    }

    class MenuDetailAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mPagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TabDetailPager pager = mPagerList.get(position);
            container.addView(pager.mRootView);
            pager.initData();
            return pager.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
