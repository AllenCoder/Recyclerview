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

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.allen.recyclerview.R;
import com.allen.recyclerview.adapter.QuickClickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

/**
 * 文 件 名: VerticalAdjustActivity
 * 创 建 人: Allen
 * 创建日期: 16/10/29 13:28
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class VerticalAdjustActivity extends Activity {
    private RecyclerView mRecyclerView;
    private QuickClickAdapter mQuickAdapter;
    private static final int PAGE_SIZE = 100;
    private static String TAG = "RecyclerClickItemActivity";
    private EditText etnum;
    private Button btnGo;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_click);
        this.btnGo = (Button) findViewById(R.id.btn_go);
        this.etnum = (EditText) findViewById(R.id.et_num);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        initAdapter();

//        /**
//         * Item  clcik
//         */
//
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {

            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(VerticalAdjustActivity.this, "" + Integer.toString(position), Toast.LENGTH_SHORT).show();
            }


        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (!TextUtils.isEmpty(etnum.getText().toString())) {
                    layoutManager.scrollToPositionWithOffset(Integer.valueOf(etnum.getText().toString()), 0);
                    layoutManager.setStackFromEnd(true);
                }
            }
        });
    }


    private void initAdapter() {
        mQuickAdapter = new QuickClickAdapter(PAGE_SIZE);
        mQuickAdapter.openLoadAnimation();
        mRecyclerView.setAdapter(mQuickAdapter);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


}
