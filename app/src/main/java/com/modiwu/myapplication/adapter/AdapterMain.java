package com.modiwu.myapplication.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.modiwu.myapplication.R;

import java.util.List;

/**
 * Created by Obl on 2018/3/15.
 * com.modiwu.myapplication.adapter
 */

public class AdapterMain extends BaseQuickAdapter<String, BaseViewHolder> {
    public AdapterMain(List<String> beans) {
        super(R.layout.adapter_main,beans);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
