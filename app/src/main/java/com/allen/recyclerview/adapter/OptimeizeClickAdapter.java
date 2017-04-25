package com.allen.recyclerview.adapter;

import com.allen.recyclerview.R;
import com.allen.recyclerview.data.DataServer;
import com.allen.recyclerview.entry.Status;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class OptimeizeClickAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    public OptimeizeClickAdapter() {
        super(R.layout.item_optimeize, DataServer.getSampleData(100));
    }

    public OptimeizeClickAdapter(int dataSize) {
        super(R.layout.item_optimeize, DataServer.getSampleData(dataSize));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
//        helper.getConvertView().setBackgroundResource(R.drawable.card_click);
//        helper
//                .addOnClickListener(R.id.button)
//                .addOnClickListener(R.id.button2)
//                .addOnClickListener(R.id.button3)
//                .addOnClickListener(R.id.button4)
//                .addOnClickListener(R.id.button5)
//                .addOnClickListener(R.id.button6)
//                .addOnClickListener(R.id.button7)
//                .addOnClickListener(R.id.button8)
//                .addOnClickListener(R.id.button9)
//                .addOnClickListener(R.id.button10)
//                .addOnClickListener(R.id.button11)
//                .addOnClickListener(R.id.button12)
//                .addOnClickListener(R.id.button13)
//                .addOnClickListener(R.id.button14)
//                .addOnClickListener(R.id.button15)
//                .addOnClickListener(R.id.button16)
//                .addOnClickListener(R.id.button17)
//                .addOnClickListener(R.id.button18)
//                .addOnClickListener(R.id.button19)
//                .addOnClickListener(R.id.button20)
//                .addOnClickListener(R.id.button21)
//                .addOnClickListener(R.id.button22)
//                .addOnClickListener(R.id.button23)
//                .addOnClickListener(R.id.button25)
//                .addOnClickListener(R.id.button26)
//                .addOnClickListener(R.id.button27)
//                .addOnClickListener(R.id.button28)
//                .addOnClickListener(R.id.button29)
//                .addOnClickListener(R.id.button30)
//                .addOnClickListener(R.id.button31)
//                .addOnClickListener(R.id.button32)
//                .addOnClickListener(R.id.button33)
//                .addOnClickListener(R.id.button34)
//                .addOnClickListener(R.id.button35)
//                .addOnClickListener(R.id.button36)
//
//        ;
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().placeholder(R.mipmap.def_head).transform(new GlideCircleTransform(mContext)).into((ImageView) helper.getView(R.id.tweetAvatar));
    }

}
