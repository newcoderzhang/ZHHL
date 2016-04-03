package com.huilong.zhang.zhhl.menudatil;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.huilong.zhang.zhhl.Base.BaseMenuDetaiPager;

/**专题
 * Created by Mario on 4/3/16.
 */
public class TopicMenuDetailPager extends BaseMenuDetaiPager {
    @Override
    public View initView() {
        TextView textView = new TextView(activity);
        textView.setText("专题");
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    public TopicMenuDetailPager(Activity activity) {
        super(activity);
    }
}
