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

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.allen.recyclerview.R;
import com.allen.recyclerview.entry.News;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.List;

/**
 * 文 件 名: GooglePlayAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/29 10:31
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class GooglePlayAdapter extends BaseQuickAdapter<News, BaseViewHolder> {
    public GooglePlayAdapter(final List<News> data) {
        super(R.layout.item_googleplay,data);
    }

    @Override
    protected void convert(final BaseViewHolder baseViewHolder, final News news) {
        final RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.item_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(baseViewHolder.getConvertView().getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);
        HorizationAdapter   mQuickAdapter = new HorizationAdapter(baseViewHolder.getConvertView().getContext(),3);
        recyclerView.setAdapter(mQuickAdapter);

        recyclerView.addOnItemTouchListener(listener);
    }
    final OnItemClickListener listener = new OnItemClickListener() {
        @Override
        public void onSimpleItemClick(final BaseQuickAdapter baseQuickAdapter, final View view, final int i) {
            Log.d(TAG, "onSimpleItemClick: "+"点击了一次");
        }
    };
}
