package com.modiwu.myapplication.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.modiwu.myapplication.R;
import com.modiwu.myapplication.mvp.model.bean.DialogInfo;

import java.util.List;

import top.jplayer.baseprolibrary.glide.GlideUtils;

/**
 * Created by Obl on 2018/3/15.
 * com.modiwu.myapplication.adapter
 */

public class AdapterMain extends BaseQuickAdapter<DialogInfo, BaseViewHolder> {


    public AdapterMain(List<DialogInfo> beans) {
        super(R.layout.adapter_main, beans);
    }

    @Override
    protected void convert(BaseViewHolder helper, DialogInfo item) {
        helper.setText(R.id.tvTitle, item.title)
                .setText(R.id.tvSub, item.subTitle);
        ImageView imageView = helper.itemView.findViewById(R.id.iv_logo);
        Glide.with(mContext)
                .load(item.src)
                .apply(GlideUtils.init().options())
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
    }
}
