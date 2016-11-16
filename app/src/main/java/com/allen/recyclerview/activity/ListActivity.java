package com.allen.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.allen.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private List<String> news = new ArrayList<>();
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        news.add("A");
        news.add("B");
        news.add("C");
        news.add("A");
        news.add("B");
        news.add("D");
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new CustomAdapter(news));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
//                view.setPressed(true);
                view.findViewById(R.id.tv).setPressed(true);
            }
        });

    }



    public class CustomAdapter extends BaseAdapter{
        private List<String> news;
        LayoutInflater layoutInflater = LayoutInflater.from(ListActivity.this);
        public CustomAdapter(final List<String> news) {
            this.news = news;
        }

        @Override
        public int getCount() {
            return news.size();
        }

        @Override
        public Object getItem(final int position) {
            return news.get(position);
        }

        @Override
        public long getItemId(final int position) {
            return position;
        }

        @Override
        public View getView(final int position,  View convertView, final ViewGroup parent) {

            if (convertView==null){
                convertView =layoutInflater.inflate(R.layout.item_click_view,null);

            }else {
                convertView.getTag();
            }

            return convertView;
        }
    }
}
