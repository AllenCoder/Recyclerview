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
import com.allen.recyclerview.data.DataServer;
import com.allen.recyclerview.entry.MarryInfo;
import com.allen.recyclerview.entry.News;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 文 件 名: GooglePlayAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/29 10:31
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class GooglePlayAdapter extends BaseQuickAdapter<News, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemClickListener {
    public GooglePlayAdapter(final List<News> data) {
        super(R.layout.item_googleplay,data);
    }

    @Override
    protected void convert(final BaseViewHolder baseViewHolder, final News news) {
        final RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.item_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(baseViewHolder.getConvertView().getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
//        HorizationAdapter   mQuickAdapter = new HorizationAdapter(baseViewHolder.getConvertView().getContext(),5, (int) (Math.random()*10));
        final List<MarryInfo> marray = DataServer.getMarray(10);
        final HideAdapter mQuickAdapter = new HideAdapter(marray);
        mQuickAdapter.setOnItemClickListener(this);
        mQuickAdapter.setOnItemChildClickListener(this);
        recyclerView.setAdapter(mQuickAdapter);
        baseViewHolder.addOnClickListener(R.id.item_recyclerview);
//        recyclerView.addOnItemTouchListener(listener);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Log.e(TAG, "嵌套层收到点击事件: "+"点击了-次");
    }

    @Override
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Log.e(TAG, "嵌套层ItemChild点击事件: "+"点击了-次");



    }
//    final OnItemClickListener listener = new OnItemClickListener() {
//        @Override
//        public void onSimpleItemClick(final BaseQuickAdapter baseQuickAdapter, final View view, final int i) {
//            Log.e(TAG, "嵌套层收到点击事件: "+"点击了-次");
//        }
//
//        @Override
//        public void onItemChildClick(final BaseQuickAdapter adapter, final View view, final int position) {
//            super.onItemChildClick(adapter, view, position);
//            Log.e(TAG, "嵌套层ItemChild点击事件: "+"点击了-次");
//        }
//    };
}
