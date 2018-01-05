package cn.chestnut.mvvm.teamworker.module.massage.bean;

import cn.chestnut.mvvm.teamworker.BR;
import cn.chestnut.mvvm.teamworker.R;
import cn.chestnut.mvvm.teamworker.main.adapter.BindingItem;

/**
 * Copyright (c) 2018, Chestnut All rights reserved
 * Author: Chestnut
 * CreateTime：at 2018/1/2 22:03:53
 * Description：部门
 * Email: xiaoting233zhang@126.com
 */

public class Department extends BindingItem{
    private String departmentId;

    private String departmentName;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public int getViewType() {
        return R.layout.item_department;
    }

    @Override
    public int getViewVariableId() {
        return BR.department;
    }
}
