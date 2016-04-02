package com.huilong.zhang.zhhl.fragments;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.huilong.zhang.zhhl.R;
import com.huilong.zhang.zhhl.domain.NewsData;
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

    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.fragment_left_menu, null);
        ViewUtils.inject(this,view);
        return view;
    }

    @Override
    public void initData() {

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
            return view;
        }
    }
}
