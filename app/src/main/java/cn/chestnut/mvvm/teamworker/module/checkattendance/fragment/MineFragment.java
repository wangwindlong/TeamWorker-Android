package cn.chestnut.mvvm.teamworker.module.checkattendance.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.chestnut.mvvm.teamworker.R;
import cn.chestnut.mvvm.teamworker.databinding.FragmentMineBinding;
import cn.chestnut.mvvm.teamworker.main.common.BaseFragment;
import cn.chestnut.mvvm.teamworker.module.checkattendance.activity.CheckAttendanceActivity;

/**
 * Copyright (c) 2018, Chestnut All rights reserved
 * Author: Chestnut
 * CreateTime：at 2018/1/3 12:13:22
 * Description：
 * Email: xiaoting233zhang@126.com
 */

public class MineFragment extends BaseFragment {

    private FragmentMineBinding binding;

    @Override
    protected void setBaseTitle(TextView titleView) {
        titleView.setText("我的");
    }

    @Override
    protected void addContainerView(ViewGroup viewGroup, LayoutInflater inflater) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, viewGroup, true);
        initData();
        initView();
        addListener();
    }

    /**
     * 初始化数据
     */
    private void initData() {

    }

    /**
     * 初始化界面
     */
    private void initView() {

    }

    /**
     * 添加监听器
     */
    private void addListener() {
        binding.btnCheckAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CheckAttendanceActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }
}
