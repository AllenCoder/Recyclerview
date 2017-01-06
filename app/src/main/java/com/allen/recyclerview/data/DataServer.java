package com.allen.recyclerview.data;


import com.allen.recyclerview.entry.MarryInfo;
import com.allen.recyclerview.entry.News;
import com.allen.recyclerview.entry.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class DataServer {

    private static final String HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK = "https://avatars1.githubusercontent.com/u/7698209?v=3&s=460";
    private static final String CYM_CHAD = "CymChad";

    private DataServer() {
    }

    public static List<Status> getSampleData(int lenth) {
        List<Status> list = new ArrayList<>();
        for (int i = 0; i < lenth; i++) {
            Status status = new Status();
            status.setUserName("Chad" + i);
            status.setCreatedAt("04/05/" + i);
            status.setRetweet(i % 2 == 0);
            status.setUserAvatar("https://avatars1.githubusercontent.com/u/7698209?v=3&s=460");
            status.setText("BaseRecyclerViewAdpaterHelper https://www.recyclerview.org");
            list.add(status);
        }
        return list;
    }

    public static List<News> getNews() {
        List<News> list = new ArrayList<>();
        News news = new News("头条");
        list.add(news);
         news = new News("热点");
        list.add(news);
        news = new News("精选");
        list.add(news);
        news = new News("上海");
        list.add(news);
        news = new News("财经");
        list.add(news);
        news = new News("科技");
        list.add(news);
        news = new News("段子");
        list.add(news);
        news = new News("视频");
        list.add(news);
        news = new News("网易");
        list.add(news);
        news = new News("图片");
        list.add(news);
        news = new News("直播");
        list.add(news);
        news = new News("汽车");
        list.add(news);
        for (int i = 0; i < 1000; i++) {
            news = new News("汽车"+i);
            list.add(news);
        }
        return list;
    }
    public static List<News> getNews(int j) {
        List<News> list = new ArrayList<>();
        News news = new News("头条");
//        list.add(news);
//        news = new News("热点");
//        list.add(news);
//        news = new News("精选");
//        list.add(news);
//        news = new News("上海");
//        list.add(news);
//        news = new News("财经");
//        list.add(news);
//        news = new News("科技");
//        list.add(news);
//        news = new News("段子");
//        list.add(news);
//        news = new News("视频");
//        list.add(news);
//        news = new News("网易");
//        list.add(news);
//        news = new News("图片");
//        list.add(news);
//        news = new News("直播");
//        list.add(news);
//        news = new News("汽车");
        list.add(news);
        for (int i = 0; i < j; i++) {
            news = new News("汽车"+i);
            list.add(news);
        }
        return list;
    }
    public static List<MarryInfo> getMarray(int j) {
        List<MarryInfo> list = new ArrayList<>();
        for (int i = 0; i < j; i++) {
            MarryInfo news = new MarryInfo("小明","137****5872",true,true);
            list.add(news);
        }

        return list;
    }

    public static List<Status> addData(List list, int dataSize) {
        for (int i = 0; i < dataSize; i++) {
            Status status = new Status();
            status.setUserName("Chad" + i);
            status.setCreatedAt("04/05/" + i);
            status.setRetweet(i % 2 == 0);
            status.setUserAvatar("https://avatars1.githubusercontent.com/u/7698209?v=3&s=460");
            status.setText("Powerful and flexible RecyclerAdapter https://github.com/CymChad/BaseRecyclerViewAdapterHelper");
            list.add(status);
        }

        return list;
    }


}
