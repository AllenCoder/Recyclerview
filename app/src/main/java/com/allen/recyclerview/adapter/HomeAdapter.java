/*
******************************* Copyright (c)*********************************\
**
**                 (c) Copyright 2015, Allen, china, shanghai
**                          All Rights Reserved
**
**                          
**                         
**-----------------------------------版本信息------------------------------------
** 版    本: V0.1
**
**------------------------------------------------------------------------------
********************************End of Head************************************\
*/
package com.allen.recyclerview.adapter;

import com.allen.recyclerview.R;
import com.allen.recyclerview.entry.Home;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 文 件 名: HomeAdapter
 * 创 建 人: Allen
 * 创建日期: 16/10/29 13:15
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class HomeAdapter extends BaseQuickAdapter<Home, BaseViewHolder> {
    public HomeAdapter(final List<Home> data) {
        super(R.layout.item_activity, data);
    }

    public HomeAdapter(final int layoutResId, final List<Home> data) {
        super(R.layout.item_activity, data);
    }

    @Override
    protected void convert(final BaseViewHolder baseViewHolder, final Home home) {
        baseViewHolder.setText(R.id.tv_activity_title, home.Name);
    }
}
