package com.allen.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.allen.recyclerview.R;
import com.allen.recyclerview.data.DataServer;
import com.allen.recyclerview.entry.News;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import static com.allen.recyclerview.R.layout.item;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class HorizationAdapter extends BaseQuickAdapter<News,BaseViewHolder> {
    private LayoutInflater layoutInflater;
    private int N ;


    public HorizationAdapter(Context mContex, int N) {
        super(item, DataServer.getNews());
        this.N =N;
        layoutInflater =LayoutInflater.from(mContex);
    }


    @Override
    protected void convert(final BaseViewHolder newsViewHolder, final News news) {
        newsViewHolder.setText(R.id.tv_title,news.title);
    }
    @Override
    protected View getItemView(final int layoutResId, final ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_news_title, parent, false);
        view.setMinimumWidth(parent.getWidth() / N);
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(parent.getWidth() / N, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(parms);
        return view;
    }

}
