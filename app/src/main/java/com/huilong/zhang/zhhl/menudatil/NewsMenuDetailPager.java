package com.huilong.zhang.zhhl.menudatil;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.huilong.zhang.zhhl.Base.BaseMenuDetaiPager;

/**新闻详情页
 * Created by Mario on 4/3/16.
 */
public class NewsMenuDetailPager extends BaseMenuDetaiPager{

    @Override
    public View initView() {
        TextView textView = new TextView(activity);
        textView.setText("首页");
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    public NewsMenuDetailPager(Activity activity) {
        super(activity);
    }
}
