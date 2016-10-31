package com.allen.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.allen.recyclerview.R;
import com.allen.recyclerview.adapter.HomeAdapter;
import com.allen.recyclerview.entry.Home;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayoutManager layoutManager;
    protected RecyclerView recyclerview;
    protected RelativeLayout activityMain;
    private HomeAdapter homeAdapter;
    private List<Home> activityList;
    private String[] activityTitle = {"RecyclerView 滚动定位", "水平调整布局", "垂直调整布局"};
    private Class<?>[] ACTIVITY = {RecyclerClickItemActivity.class, HorizontalAdjustActivity.class, VerticalAdjustActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initData();
        initView();
        initAdapter();
        recyclerview.setAdapter(homeAdapter);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(final BaseQuickAdapter baseQuickAdapter, final View view, final int position) {
                Intent intent = new Intent(MainActivity.this, ACTIVITY[position]);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        activityList = new ArrayList<>();
        for (int i = 0; i < activityTitle.length; i++) {
            Home home = new Home(activityTitle[i]);
            activityList.add(home);
        }


    }

    private void initAdapter() {
        homeAdapter = new HomeAdapter(activityList);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        activityMain = (RelativeLayout) findViewById(R.id.activity_main);
    }
}
