package com.allen.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.allen.recyclerview.R;
import com.allen.recyclerview.data.DataServer;
import com.allen.recyclerview.entry.MarryInfo;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private List<String> news = new ArrayList<>();
    private ListView listView;
    private List<MarryInfo> infoList;
    private String TAG="ListActivity";

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
         infoList = DataServer.getMarray(10);
        listView.setAdapter(new CustomAdapter(infoList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
//                view.setPressed(true);
                view.findViewById(R.id.tv).setPressed(true);
            }
        });

    }


    public class CustomAdapter extends BaseAdapter implements View.OnClickListener{
        private List<MarryInfo> news;
        LayoutInflater layoutInflater = LayoutInflater.from(ListActivity.this);

        public CustomAdapter(final List<MarryInfo> news) {
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
        public View getView(final int position, View convertView, final ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.item_marray, null);
            } else {
                convertView.getTag();
            }
            holder = new ViewHolder(convertView);
            holder.tv_name.setText(news.get(position).getName());
            holder.tv_phone.setText(news.get(position).getPhone());
            if (news.get(position).isShow) {
                holder.ly_a.setVisibility(View.VISIBLE);
                holder.ly_b.setVisibility(View.GONE);
            } else {
                holder.ly_a.setVisibility(View.GONE);
                holder.ly_b.setVisibility(View.VISIBLE);
            }
            final ViewHolder finalHolder = holder;
            holder.tv_unrepeat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    Log.e(TAG, "onClick: "+finalHolder.tv_unrepeat.getId()+""+ (finalHolder.tv_unrepeat.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_repeat.getId()+""+ (finalHolder.tv_repeat.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_invalid.getId()+""+ (finalHolder.tv_invalid.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_valid.getId()+""+ (finalHolder.tv_valid.getVisibility()==View.VISIBLE));

                    infoList.get(position).isShow =false;
                    notifyDataSetChanged();
                }
            });

            holder.tv_repeat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    Log.e(TAG, "onClick: "+finalHolder.tv_unrepeat.getId()+""+ (finalHolder.tv_unrepeat.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_repeat.getId()+""+ (finalHolder.tv_repeat.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_invalid.getId()+""+ (finalHolder.tv_invalid.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_valid.getId()+""+ (finalHolder.tv_valid.getVisibility()==View.VISIBLE));

                    infoList.get(position).isShow =false;
                    notifyDataSetChanged();
                }
            });
            holder.tv_valid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    Log.e(TAG, "onClick: "+finalHolder.tv_unrepeat.getId()+""+ (finalHolder.tv_unrepeat.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_repeat.getId()+""+ (finalHolder.tv_repeat.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_invalid.getId()+""+ (finalHolder.tv_invalid.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_valid.getId()+""+ (finalHolder.tv_valid.getVisibility()==View.VISIBLE));

                    infoList.get(position).isShow =true;
                    notifyDataSetChanged();
                }
            });
            holder.tv_invalid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    Log.e(TAG, "onClick: "+finalHolder.tv_unrepeat.getId()+""+ (finalHolder.tv_unrepeat.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_repeat.getId()+""+ (finalHolder.tv_repeat.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_invalid.getId()+""+ (finalHolder.tv_invalid.getVisibility()==View.VISIBLE));
                    Log.e(TAG, "onClick: "+finalHolder.tv_valid.getId()+""+ (finalHolder.tv_valid.getVisibility()==View.VISIBLE));

                    infoList.get(position).isShow =true;
                    notifyDataSetChanged();
                }
            });


            return convertView;
        }

        @Override
        public void onClick(final View v) {

            Log.e("onClick", "onClick: ");
            switch (v.getId()){

            }
        }

        public class ViewHolder {
            public View rootView;
            public TextView tv_name;
            public TextView tv_phone;
            public TextView tv_unrepeat;
            public TextView tv_repeat;
            public LinearLayout ly_a;
            public TextView tv_valid;
            public TextView tv_invalid;
            public LinearLayout ly_b;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
                this.tv_phone = (TextView) rootView.findViewById(R.id.tv_phone);
                this.tv_unrepeat = (TextView) rootView.findViewById(R.id.tv_unrepeat);
                this.tv_repeat = (TextView) rootView.findViewById(R.id.tv_repeat);
                this.ly_a = (LinearLayout) rootView.findViewById(R.id.ly_a);
                this.tv_valid = (TextView) rootView.findViewById(R.id.tv_valid);
                this.tv_invalid = (TextView) rootView.findViewById(R.id.tv_invalid);
                this.ly_b = (LinearLayout) rootView.findViewById(R.id.ly_b);
            }

        }
    }
}
