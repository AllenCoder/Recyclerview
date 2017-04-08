package com.allen.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.allen.recyclerview.R;
import com.allen.recyclerview.view.ScrollByView;

public class TestActivity extends AppCompatActivity {

    ScrollByView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mScrollView = (ScrollByView) findViewById(R.id.scrollView);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScrollView.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
