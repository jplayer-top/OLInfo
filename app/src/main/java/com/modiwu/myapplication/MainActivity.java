package com.modiwu.myapplication;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.modiwu.myapplication.adapter.AdapterMain;

import java.util.ArrayList;

import top.jplayer.baseprolibrary.ui.SuperBaseActivity;
import top.jplayer.baseprolibrary.widgets.dialog.DialogFlowSure;

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
        beans.add("");
        beans.add("");
        beans.add("");
        beans.add("");
        beans.add("");
        beans.add("");
        beans.add("");
        beans.add("");
        beans.add("");
        mAdapter = new AdapterMain(beans);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((adapter, view1, position) -> {
            DialogFlowSure dialogFlowSure = new DialogFlowSure(this);
            dialogFlowSure.show();
        });
    }

}
