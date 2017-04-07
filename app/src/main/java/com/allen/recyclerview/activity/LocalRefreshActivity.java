package com.allen.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.allen.recyclerview.R;
import com.allen.recyclerview.adapter.RefreshAdapter;
import com.allen.recyclerview.data.DataServer;
import com.allen.recyclerview.entry.News;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LocalRefreshActivity extends AppCompatActivity {
    private RefreshAdapter adapter;
    private RecyclerView recyclerView;
    private String TAG ="LocalRefreshActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<News> list = DataServer.getNews();
        adapter = new RefreshAdapter(list);
        setContentView(R.layout.activity_local_refresh);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(LocalRefreshActivity.this));
        recyclerView.setAdapter(adapter);
        Observable.interval(1000,1000, TimeUnit.MILLISECONDS).create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> e) throws Exception {
                Log.d(TAG, "subscribe: ");
            }




        }).observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread());
    }
    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("s = " + s);         }
        });
//        Observable.interval(1000,1000, TimeUnit.MILLISECONDS).create(new ObservableOnSubscribe<Long>() {
//            @Override
//            public void subscribe(ObservableEmitter<Long> e) throws Exception {
//                System.out.println("s = " + e);
//            }
//        });
        Observable.interval(2000,1000, TimeUnit.MILLISECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("aLong = " + aLong);
            }
        });
        Flowable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("args = " );
                return null;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single());
    }
}
