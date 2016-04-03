package com.huilong.zhang.zhhl.menudatil;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.huilong.zhang.zhhl.Base.BaseMenuDetaiPager;

/**互动
 * Created by Mario on 4/3/16.
 */
public class InteractMenuDetailPager extends BaseMenuDetaiPager {
    @Override
    public View initView() {
        TextView textView = new TextView(activity);
        textView.setText("互动");
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    public InteractMenuDetailPager(Activity activity) {
        super(activity);
    }
}
