package com.allen.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allen.recyclerview.R;
import com.allen.recyclerview.entry.News;

import java.util.List;

/**
 * Created by Allen on 2017/3/24.
 */

public class RefreshAdapter extends RecyclerView.Adapter<RefreshAdapter.MyViewHolder> {
    private List<News> list;

    public RefreshAdapter(List<News> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  static class  MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

//
//    public  static class  MyViewHolder extends RecyclerView.ViewHolder implements AnimateViewHolder {
//
//        public ImageView imageView;
//        public MyViewHolder(View itemView) {
//            super(itemView);
//        }
//
//        @Override
//        public void preAnimateRemoveImpl(RecyclerView.ViewHolder holder) {
//
//        }
//
//        @Override
//        public void animateRemoveImpl(RecyclerView.ViewHolder holder, ViewPropertyAnimatorListener listener) {
//            ViewCompat.animate(itemView)
//                    .translationY(-itemView.getHeight() * 0.3f)
//                    .alpha(0)
//                    .setDuration(300)
//                    .setListener(listener)
//                    .start();
//        }
//
//        @Override
//        public void preAnimateAddImpl(RecyclerView.ViewHolder holder) {
//            ViewCompat.setTranslationY(itemView, -itemView.getHeight() * 0.3f);
//            ViewCompat.setAlpha(itemView, 0);
//        }
//
//        @Override
//        public void animateAddImpl(RecyclerView.ViewHolder holder, ViewPropertyAnimatorListener listener) {
//            ViewCompat.animate(itemView)
//                    .translationY(0)
//                    .alpha(1)
//                    .setDuration(300)
//                    .setListener(listener)
//                    .start();
//        }
//    }
}
