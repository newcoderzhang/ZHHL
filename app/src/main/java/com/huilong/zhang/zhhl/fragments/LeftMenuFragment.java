package com.huilong.zhang.zhhl.fragments;

import android.view.View;

import com.huilong.zhang.zhhl.R;

/**侧边栏
 * Created by Mario on 3/29/16.
 */
public class LeftMenuFragment extends BaseFragment {
    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.fragment_left_menu, null);
        return view;
    }
}
