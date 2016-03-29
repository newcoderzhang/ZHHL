package com.huilong.zhang.zhhl.fragments;

import android.view.View;

import com.huilong.zhang.zhhl.R;

/**
 * Created by Mario on 3/29/16.
 */
public class ContentFragment extends  BaseFragment {
    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.fragment_content, null);
        return view;
    }
}
