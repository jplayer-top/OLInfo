package com.modiwu.myapplication;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import top.jplayer.baseprolibrary.mvp.model.bean.SampleBean;
import top.jplayer.baseprolibrary.ui.SuperBaseActivity;
import top.jplayer.baseprolibrary.ui.adapter.SampleAdapter;

public class MainActivity extends SuperBaseActivity {

    @Override
    protected int initRootLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initRootData(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ArrayList<SampleBean.DataBean.ListBean> beans = new ArrayList<>();
        beans.add(new SampleBean.DataBean.ListBean());
        beans.add(new SampleBean.DataBean.ListBean());
        beans.add(new SampleBean.DataBean.ListBean());
        beans.add(new SampleBean.DataBean.ListBean());
        beans.add(new SampleBean.DataBean.ListBean());
        beans.add(new SampleBean.DataBean.ListBean());
        beans.add(new SampleBean.DataBean.ListBean());
        beans.add(new SampleBean.DataBean.ListBean());
        beans.add(new SampleBean.DataBean.ListBean());
        recyclerView.setAdapter(new SampleAdapter(beans));
    }

}
