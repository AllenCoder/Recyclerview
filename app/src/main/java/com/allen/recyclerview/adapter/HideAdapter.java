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
import com.allen.recyclerview.entry.MarryInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 文 件 名: HideAdapter
 * 创 建 人: Allen
 * 创建日期: 17/1/6 22:41
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class HideAdapter extends BaseQuickAdapter<MarryInfo, BaseViewHolder> {
    public HideAdapter(final List<MarryInfo> data) {
        super(R.layout.item_marray, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MarryInfo item) {
        helper
                .addOnClickListener(R.id.tv_unrepeat).
        addOnClickListener(R.id.tv_repeat).
                addOnClickListener(R.id.tv_valid).
                addOnClickListener(R.id.tv_invalid)
//                .setVisible(R.id.ly_a, item.isShow)
//                .setVisible(R.id.ly_b, !item.isShow)
//                .setVisible(R.id.tv_unrepeat, item.isShow)
//                .setVisible(R.id.tv_repeat, item.isShow)
//                .setVisible(R.id.tv_valid, !item.isShow)
//                .setVisible(R.id.tv_invalid, !item.isShow)
                .setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_phone, item.getPhone());

    }
}
