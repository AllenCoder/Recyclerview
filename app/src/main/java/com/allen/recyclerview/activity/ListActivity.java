package com.allen.recyclerview.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.allen.recyclerview.R;
import com.allen.recyclerview.data.DataServer;
import com.allen.recyclerview.entry.MarryInfo;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.VISIBLE;

public class ListActivity extends AppCompatActivity {
    private List<String> news = new ArrayList<>();
    private ListView listView;
    private List<MarryInfo> infoList;
    private String TAG = "ListActivity";
    private TextView tv_name;
    private TextView tv_phone;
    private TextView tv_unrepeat;
    private TextView tv_repeat;
    private LinearLayout ly_a;
    private TextView tv_valid;
    private TextView tv_invalid;
    private LinearLayout ly_b;
    private LinearLayout  ly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
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
                Log.d(TAG, "onItemClick: ");
//                view.findViewById(R.id.tv).setPressed(true);

                String movieurl="http://xxx.xxx.xx.xx:8080/play/test.mp4";//在线视频地址
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String type = "video/mpeg";//视频类型
                Uri uri = Uri.parse(movieurl);
                intent.setDataAndType(uri, type);
                startActivity(intent);
            }
        });




//        ly.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View v) {
//                Logger.d(TAG, "onResume: "+(isShown(ly_a)));
//                Logger.d(TAG, "onResume: "+(isShown(ly_a)));
//                Logger.d(TAG, "onResume: "+(isShown(tv_valid)));
//                Logger.d(TAG, "onResume: "+(tv_invalid.isShown()));
//            }
//        });
    }

    @Override
    public void onWindowFocusChanged(final boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            Logger.d(TAG, "onResume: "+(isShown(ly_a)));
            Logger.d(TAG, "onResume: "+(isShown(ly_a)));
            Logger.d(TAG, "onResume: "+(isShown(tv_valid)));
            Logger.d(TAG, "onResume: "+(tv_invalid.isShown()));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d(TAG, "onCreate: "+(tv_unrepeat.getVisibility()== VISIBLE));
        Logger.d(TAG, "onCreate: "+(tv_repeat.getVisibility()== VISIBLE));
        Logger.d(TAG, "onCreate: "+(tv_valid.getVisibility()== VISIBLE));
        Logger.d(TAG, "onCreate: "+(tv_invalid.getVisibility()== VISIBLE));
        Logger.d(TAG, "onResume: "+(isShown(ly_a)));
        Logger.d(TAG, "onResume: "+(isShown(ly_a)));
        Logger.d(TAG, "onResume: "+(isShown(tv_valid)));
        Logger.d(TAG, "onResume: "+(tv_invalid.isShown()));
    }
    static final int VISIBILITY_MASK = 0x0000000C;
    public boolean isShown(View view) {
        View current = view;
        //noinspection ConstantConditions
        Logger.d(TAG, "isShown: ------------------");
        do {
            if (view.getVisibility() != VISIBLE) {
                Logger.d(TAG, "isShown: view.getVisibility() != VISIBLE"+"不可见");
                return false;
            }
            ViewParent parent = current.getParent();
            if (parent == null) {
                Logger.d(TAG, "isShown: parent == null"+"不可见");
                return false; // We are not attached to the view root
            }
            if (!(parent instanceof View)) {
                Logger.d(TAG, "isShown: "+"可见");
                return true;
            }
            current = (View) parent;
        } while (current != null);
        Logger.d(TAG, "isShown: "+"不可见");
        return false;
    }
    public boolean checkViewVisible(View view){
       return  view.getVisibility() == VISIBLE ;
    }

    private void initView() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_unrepeat = (TextView) findViewById(R.id.tv_unrepeat);
        tv_repeat = (TextView) findViewById(R.id.tv_repeat);
        ly_a = (LinearLayout) findViewById(R.id.ly_a);
        tv_valid = (TextView) findViewById(R.id.tv_valid);
        tv_invalid = (TextView) findViewById(R.id.tv_invalid);
        ly_b = (LinearLayout) findViewById(R.id.ly_b);
        ly = (LinearLayout) findViewById(R.id.ly);
    }


    public class CustomAdapter extends BaseAdapter implements View.OnClickListener {
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
                holder.ly_a.setVisibility(VISIBLE);
                holder.ly_b.setVisibility(View.GONE);
            } else {
                holder.ly_a.setVisibility(View.GONE);
                holder.ly_b.setVisibility(VISIBLE);
            }
            final ViewHolder finalHolder = holder;
//            holder.tv_unrepeat.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(final View v) {
//
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_unrepeat.getId()+"可见吗？ " + "" + (finalHolder.tv_unrepeat.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_repeat.getId()+"可见吗？ " + "" + (finalHolder.tv_repeat.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_invalid.getId()+"可见吗？ " + "" + (finalHolder.tv_invalid.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_valid.getId() +"可见吗？ "+ "" + (finalHolder.tv_valid.isShown()));
//
//                    infoList.get(position).isShow = false;
//                    notifyDataSetChanged();
//                }
//            });
//
//            holder.tv_repeat.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(final View v) {
//
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_unrepeat.getId()+"可见吗？ " + "" + (finalHolder.tv_unrepeat.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_repeat.getId()+"可见吗？ " + "" + (finalHolder.tv_repeat.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_invalid.getId()+"可见吗？ " + "" + (finalHolder.tv_invalid.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_valid.getId() +"可见吗？ "+ "" + (finalHolder.tv_valid.isShown()));
//
//                    infoList.get(position).isShow = false;
//                    notifyDataSetChanged();
//                }
//            });
//            holder.tv_valid.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(final View v) {
//
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_unrepeat.getId()+"可见吗？ " + "" + (finalHolder.tv_unrepeat.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_repeat.getId()+"可见吗？ " + "" + (finalHolder.tv_repeat.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_invalid.getId()+"可见吗？ " + "" + (finalHolder.tv_invalid.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_valid.getId() +"可见吗？ "+ "" + (finalHolder.tv_valid.isShown()));
//
//                    infoList.get(position).isShow = true;
//                    notifyDataSetChanged();
//                }
//            });
//            holder.tv_invalid.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(final View v) {
//
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_unrepeat.getId()+"可见吗？ " + "" + (finalHolder.tv_unrepeat.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_repeat.getId()+"可见吗？ " + "" + (finalHolder.tv_repeat.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_invalid.getId()+"可见吗？ " + "" + (finalHolder.tv_invalid.isShown()));
//                    Logger.e(TAG, "onClick: " + finalHolder.tv_valid.getId() +"可见吗？ "+ "" + (finalHolder.tv_valid.isShown()));
//
//                    infoList.get(position).isShow = true;
//                    notifyDataSetChanged();
//                }
//            });


            return convertView;
        }

        @Override
        public void onClick(final View v) {

            Logger.e("onClick", "onClick: ");
            switch (v.getId()) {

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
