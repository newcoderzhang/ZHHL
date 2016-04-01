package com.huilong.zhang.zhhl.fragments;

import android.view.View;
import android.widget.RadioGroup;

import com.huilong.zhang.zhhl.R;

/**
 * Created by Mario on 3/29/16.
 */
public class ContentFragment extends  BaseFragment {
    private RadioGroup radioGroup;
    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.fragment_content, null);
        radioGroup = (RadioGroup) view.findViewById(R.id.rg_group)；
        return view;
    }

    @Override
    public void initData() {
        radioGroup.check(R.id.rb_home);

    }
}
