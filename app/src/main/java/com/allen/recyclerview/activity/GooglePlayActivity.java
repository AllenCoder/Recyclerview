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
package com.allen.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.allen.recyclerview.R;
import com.allen.recyclerview.adapter.GooglePlayAdapter;
import com.allen.recyclerview.data.DataServer;
import com.chad.library.adapter.base.BaseQuickAdapter;

/**
 * 文 件 名: GooglePlayActivity
 * 创 建 人: Allen
 * 创建日期: 16/12/29 10:28
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class GooglePlayActivity extends AppCompatActivity {
    private RecyclerView mRootRecyclerviewRecyclerView;
    private String TAG="GooglePlayActivity";

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_nest);
        mRootRecyclerviewRecyclerView = (RecyclerView) findViewById(R.id.root_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRootRecyclerviewRecyclerView.setLayoutManager(layoutManager);
        mRootRecyclerviewRecyclerView.setHasFixedSize(true);
        initAdapter();
    }

    private void initAdapter() {
        GooglePlayAdapter   mQuickAdapter = new GooglePlayAdapter(DataServer.getNews());
        mQuickAdapter.openLoadAnimation();
        mRootRecyclerviewRecyclerView.setAdapter(mQuickAdapter);
        mQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Log.d(TAG, "onSimpleItemClick: "+"父层onItemChildClick收到点击事件");
            }
        });
//        mRootRecyclerviewRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
//            @Override
//            public void onSimpleItemClick(final BaseQuickAdapter baseQuickAdapter, final View view, final int i) {
//                Log.d(TAG, "onSimpleItemClick: "+"父层item收到点击事件");
//            }
//
//                                                                 @Override
//                                                                 public void onItemChildClick(final BaseQuickAdapter adapter, final View view, final int position) {
//                                                                     super.onItemChildClick(adapter, view, position);
//                                                                     Log.d(TAG, "onSimpleItemClick: "+"父层onItemChildClick收到点击事件");
//                                                                 }
//                                                             }
//        );
    }
}
