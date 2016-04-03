package com.huilong.zhang.zhhl.fragments;

import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.huilong.zhang.zhhl.Main2Activity;
import com.huilong.zhang.zhhl.R;
import com.huilong.zhang.zhhl.domain.NewsData;
import com.huilong.zhang.zhhl.impl.NewcenterPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**侧边栏
 * Created by Mario on 3/29/16.
 */
public class LeftMenuFragment extends BaseFragment {
    private static final String TAG = " LeftMenuFragment";
    @ViewInject(R.id.lv_list)
    private ListView listView;

    TextView title;
    private ArrayList<NewsData.NewsMenuData> arrayList;

    private  MenuAdapter menuAdapter;

    private  int mCurrentpos;//当前被点击的菜单项

    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.fragment_left_menu, null);
        ViewUtils.inject(this,view);
        return view;
    }

    @Override
    public void initData() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCurrentpos = position;
                menuAdapter.notifyDataSetChanged();
                setCruuentMenuDetailPager(position);
                toggleSlidinmMenu();

            }
        });

    }

    private void toggleSlidinmMenu() {
        //Main2Activity mainui = (Main2Activity) activity;
        SlidingMenu slidingMenu = ((Main2Activity) activity).getSlidingMenu();
        slidingMenu.toggle();
    }

    public void setMenudata(NewsData newdData) {
        Log.v(TAG,"侧边栏得到数据啦" + newdData);
        arrayList = newdData.data;
        menuAdapter = new MenuAdapter();
        listView.setAdapter(menuAdapter);
    }

    class MenuAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(activity,R.layout.list_menu_item,null);
            title = (TextView) view.findViewById(R.id.textView1);
            NewsData.NewsMenuData newsMenuData = (NewsData.NewsMenuData) getItem(position);
            title.setText(newsMenuData.title);
            if(mCurrentpos == position){
                title.setEnabled(true);
            }else {
                title.setEnabled(false);
            }
            return view;
        }
    }




    /**
     * 设置当前菜单详情页
     */
     protected void setCruuentMenuDetailPager(int position){
         Main2Activity main2Activity = (Main2Activity) activity;
         ContentFragment contentFragment = ((Main2Activity) activity).getContentFragement();
         NewcenterPager newcenterPager = contentFragment.getNewCenperPager();
         newcenterPager.setCurrentMenuDetailPager(position);

     }
}
