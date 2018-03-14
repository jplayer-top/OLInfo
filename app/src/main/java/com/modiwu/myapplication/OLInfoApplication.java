package com.modiwu.myapplication;

import android.support.multidex.MultiDexApplication;
import android.util.ArrayMap;

import java.util.Map;

import top.jplayer.baseprolibrary.BaseInitApplication;

/**
 * Created by Obl on 2018/3/13.
 * com.modiwu.myapplication
 */

public class OLInfoApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Map<String, String> map = new ArrayMap<>();
        map.put("cai_url", "https://m.leader001.cn/");
        map.put("jplayer_url", "https://jplayer.top/");
        BaseInitApplication.init(this)
                //网络请求
                .retrofit()
                //管理activity
                .lifecycle()
                //动态Url
                .urlMap(map);
    }
}
