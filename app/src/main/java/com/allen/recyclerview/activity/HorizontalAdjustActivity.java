package com.allen.recyclerview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import com.allen.recyclerview.R;
import com.allen.recyclerview.adapter.HorizationAdapter;

/**
 * create by AllenCoder
 */
public class HorizontalAdjustActivity extends Activity {

    private HorizationAdapter horizationAdapter;
    private LinearLayoutManager layoutManager1;
    private LinearLayoutManager layoutManager2;
    private LinearLayoutManager layoutManager3;
    private RecyclerView recyclerview1;
    private RecyclerView recyclerview2;
    private RecyclerView recyclerview3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_adjust);
        initView();

        layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager3 = new LinearLayoutManager(this);
        layoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview1.setLayoutManager(layoutManager1);
        recyclerview2.setLayoutManager(layoutManager2);
        recyclerview3.setLayoutManager(layoutManager3);
        initAdapter();
    }


    private void initAdapter() {
        horizationAdapter = new HorizationAdapter(this, 3);
        horizationAdapter.openLoadAnimation();
        recyclerview1.setAdapter(horizationAdapter);
        horizationAdapter = new HorizationAdapter(this,5);
        recyclerview2.setAdapter(horizationAdapter);
        horizationAdapter = new HorizationAdapter(this, 7);
        recyclerview3.setAdapter(horizationAdapter);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    private void initView() {
        recyclerview1 = (RecyclerView) findViewById(R.id.recyclerview1);
        recyclerview2 = (RecyclerView) findViewById(R.id.recyclerview2);
        recyclerview3 = (RecyclerView) findViewById(R.id.recyclerview3);
    }
}
