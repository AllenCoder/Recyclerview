package com.allen.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.allen.recyclerview.R;
import com.allen.recyclerview.adapter.HideAdapter;
import com.allen.recyclerview.data.DataServer;
import com.allen.recyclerview.entry.MarryInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.List;

public class HideActivity extends AppCompatActivity {
    RecyclerView mRootRecyclerviewRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide);
    mRootRecyclerviewRecyclerView = (RecyclerView) findViewById(R.id.activity_hide);

    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    mRootRecyclerviewRecyclerView.setLayoutManager(layoutManager);
    mRootRecyclerviewRecyclerView.setHasFixedSize(true);
    initAdapter();
}

    private void initAdapter() {
        final List<MarryInfo> marray = DataServer.getMarray(10);
        final HideAdapter mQuickAdapter = new HideAdapter(marray);
        mQuickAdapter.openLoadAnimation();
        mRootRecyclerviewRecyclerView.setAdapter(mQuickAdapter);

        Log.e("SimpleClickListener", "convert: 不重复按钮ID "+R.id.tv_unrepeat);
        Log.e("SimpleClickListener", "convert: 重复按钮ID "+R.id.tv_repeat);
        Log.e("SimpleClickListener", "convert: 有效按钮ID "+R.id.tv_valid);
        Log.e("SimpleClickListener", "convert: 无效按钮ID "+R.id.tv_invalid);
        mRootRecyclerviewRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter baseQuickAdapter, final View view, final int i) {
                Log.d(TAG, "onSimpleItemClick: "+"父层item收到点击事件");
            }

            @Override
            public void onItemChildClick(final BaseQuickAdapter adapter, final View view, final int position) {
                super.onItemChildClick(adapter, view, position);
                switch (view.getId()){
                    case R.id.tv_repeat:
                        Log.d(TAG, "onItemChildClick: "+"点击了重复按钮");
                        marray.get(position).isShow =false;
                        break;
                    case R.id.tv_unrepeat:
                        Log.d(TAG, "onItemChildClick: "+"点击了不重复按钮");
                        marray.get(position).isShow =false;
                        break;
                    case R.id.tv_valid:
                        Log.d(TAG, "onItemChildClick: "+"点击了有效按钮");
                        marray.get(position).isShow =true;
                        break;
                    case R.id.tv_invalid:
                        Log.d(TAG, "onItemChildClick: "+"点击了无效按钮");
                        marray.get(position).isShow =true;
                        break;
                }
                mQuickAdapter.notifyDataSetChanged();
            }
        });
    }
}
