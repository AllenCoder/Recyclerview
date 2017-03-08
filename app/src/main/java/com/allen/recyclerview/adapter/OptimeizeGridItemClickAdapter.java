package com.allen.recyclerview.adapter;

import com.allen.recyclerview.R;
import com.allen.recyclerview.data.DataServer;
import com.allen.recyclerview.entry.Status;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class OptimeizeGridItemClickAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    public OptimeizeGridItemClickAdapter() {
        super(R.layout.item_optimeize, DataServer.getSampleData(100));
    }

    public OptimeizeGridItemClickAdapter(int dataSize) {
        super(R.layout.item_optimeize, DataServer.getSampleData(dataSize));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
//        helper.getConvertView().setBackgroundResource(R.drawable.card_click);


        ;
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().placeholder(R.mipmap.def_head).transform(new GlideCircleTransform(mContext)).into((ImageView) helper.getView(R.id.tweetAvatar));
    }

}
