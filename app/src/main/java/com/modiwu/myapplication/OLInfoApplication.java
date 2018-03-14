package com.modiwu.myapplication;

import android.support.multidex.MultiDexApplication;

import top.jplayer.baseprolibrary.BaseInitApplication;

/**
 * Created by Obl on 2018/3/13.
 * com.modiwu.myapplication
 */

public class OLInfoApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        BaseInitApplication.init(this).retrofit()
                .addUrl("cai_url", "https://m.leader001.cn/")
                .addUrl("jplayer_url", "https://jplayer.top/");
    }
}
