package com.huilong.zhang.zhhl.menudatil;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.huilong.zhang.zhhl.Base.BaseMenuDetaiPager;

/**组图
 * Created by Mario on 4/3/16.
 */
public class PhotoMenuDetailPager extends BaseMenuDetaiPager {
    @Override
    public View initView() {
        TextView textView = new TextView(activity);
        textView.setText("组图");
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    public PhotoMenuDetailPager(Activity activity) {
        super(activity);
    }
}
