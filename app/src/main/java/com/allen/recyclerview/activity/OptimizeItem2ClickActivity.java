package com.allen.recyclerview.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.allen.recyclerview.R;
import com.allen.recyclerview.adapter.OptimeizeClickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

public class OptimizeItem2ClickActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private OptimeizeClickAdapter mQuickAdapter;
    private static final int PAGE_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimize_item_click);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        mRecyclerView.setLayoutManager(layoutManager);
        initAdapter();

//        /**
//         * Item  clcik
//         */
//
//        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
//
//            @Override
//            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
//            }
//
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                Logger.d("当前时间  "+System.currentTimeMillis());
//                super.onItemChildClick(adapter, view, position);
//                switch (view.getId()) {
//
//                    default:
//                        break;
//                }
//            }
//
//
//            @Override
//            public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
//                super.onItemLongClick(adapter, view, position);
//
//            }
//
//            @Override
//            public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
//                super.onItemChildLongClick(adapter, view, position);
//
//            }
//        });
    }

    private void initAdapter() {
        mQuickAdapter = new OptimeizeClickAdapter(PAGE_SIZE);
        mQuickAdapter.openLoadAnimation();
        mQuickAdapter.notifyItemChanged(1,1);
        mRecyclerView.setAdapter(mQuickAdapter);
        mQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Toast.makeText(OptimizeItem2ClickActivity.this,"onItemClick",Toast.LENGTH_SHORT).show();
            }
        });
        mQuickAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Toast.makeText(OptimizeItem2ClickActivity.this,"onItemLongClick",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        mQuickAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Toast.makeText(OptimizeItem2ClickActivity.this,"onItemChildLongClick",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        mQuickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Toast.makeText(OptimizeItem2ClickActivity.this,"onItemChildClick",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
