package com.huilong.zhang.zhhl.impl;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.huilong.zhang.zhhl.Base.BaseMenuDetaiPager;
import com.huilong.zhang.zhhl.R;
import com.huilong.zhang.zhhl.domain.NewsData;
import com.huilong.zhang.zhhl.domain.TabData;
import com.huilong.zhang.zhhl.global.GlobalContants;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

/**页签详情页
 * Created by Mario on 4/3/16.
 */
public class TabDetailPager extends BaseMenuDetaiPager  implements ViewPager.OnPageChangeListener{



    NewsData.NewsTabData mTabData;
    private TextView textView;
    String url;
    private String tapresult;
    private TabData tabDataprase;

    @ViewInject(R.id.vp_news)
    private ViewPager mviewpager;

    @ViewInject(R.id.title_text)
    private TextView texttitle;

    private TopNewsAdapter topnewadapter;

    private BitmapUtils bitmapUtils;

    @ViewInject(R.id.indicator)
    private CirclePageIndicator mindicator;

    private ArrayList<TabData.TopNewsData> mTopNewsList;// 头条新闻数据集合
    public TabDetailPager(Activity activity, NewsData.NewsTabData newsTabData) {
        super(activity);
        this.mTabData = newsTabData;
        url = GlobalContants.SERVER_URL + newsTabData.url;
    }

    @Override
    public View initView() {

        View view = View.inflate(activity, R.layout.tab_detail_pager,null);
        ViewUtils.inject(this,view);
        mviewpager.setOnPageChangeListener(this);

        return view;

    }

    @Override
    public void initData() {
        getDataFromeServer();
    }

    private void getDataFromeServer() {
        HttpUtils httputils = new HttpUtils();
        httputils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                tapresult = responseInfo.result;
                System.out.println(" TabDetailPager" +tapresult);
                parseData(tapresult);

            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(activity,s,Toast.LENGTH_LONG).show();
                e.printStackTrace();

            }
        });

    }

    private void parseData(String tapresult) {
        Gson gson = new Gson();
        tabDataprase = gson.fromJson(tapresult, TabData.class);
        System.out.println("页面详情" + tabDataprase);
        mTopNewsList = tabDataprase.data.topnews;
        topnewadapter = new TopNewsAdapter();
        mviewpager.setAdapter(topnewadapter);
        mindicator.setViewPager(mviewpager);
        mindicator.setSnap(true);//支持快照模式



    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        texttitle.setText(mTopNewsList.get(position).title);

    }

    @Override
    public void onPageScrollStateChanged(int state) {


    }

    class TopNewsAdapter extends PagerAdapter{

        public TopNewsAdapter() {
             bitmapUtils = new BitmapUtils(activity);
        }

        @Override
        public int getCount() {
            return tabDataprase.data.topnews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageview = new ImageView(activity);
            imageview.setImageResource(R.mipmap.topnews_item_default);
            imageview.setScaleType(ImageView.ScaleType.FIT_XY);

            TabData.TopNewsData topNewsData = tabDataprase.data.topnews.get(position);
            bitmapUtils.display(imageview,topNewsData.topimage);
            container.addView(imageview);
            return imageview;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            //super.destroyItem(container, position, object);
        }
    }
}
