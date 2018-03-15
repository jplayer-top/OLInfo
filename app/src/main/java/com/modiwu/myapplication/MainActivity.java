package com.modiwu.myapplication;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.florent37.viewanimator.ViewAnimator;
import com.modiwu.myapplication.adapter.AdapterMain;

import java.util.ArrayList;

import top.jplayer.baseprolibrary.ui.SuperBaseActivity;
import top.jplayer.baseprolibrary.widgets.dialog.DialogNoviceGuide;
import top.jplayer.baseprolibrary.widgets.dialog.DialogRedHb;
import top.jplayer.baseprolibrary.widgets.dialog.DialogSubmitSure;

public class MainActivity extends SuperBaseActivity {

    private AdapterMain mAdapter;

    @Override
    protected int initRootLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initRootData(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ArrayList<String> beans = new ArrayList<>();
        beans.add("提交成功");
        beans.add("新手礼包");
        beans.add("抢红包");
        beans.add(getString(R.string.app_name));
        beans.add(getString(R.string.app_name));
        beans.add(getString(R.string.app_name));
        beans.add(getString(R.string.app_name));
        beans.add(getString(R.string.app_name));
        beans.add(getString(R.string.app_name));
        mAdapter = new AdapterMain(beans);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((adapter, v, position) -> {
            if (position == 0) {

                new DialogSubmitSure(this).show(R.id.iv_sure);
            } else if (position == 1) {
                new DialogNoviceGuide(this).show(R.id.ivFree);
            } else if (position == 2) {
                new DialogRedHb(this).show(R.id.ivOpen, v1 -> ViewAnimator.animate(v1).duration(1000).flipHorizontal().start());
            }
        });
    }
}
