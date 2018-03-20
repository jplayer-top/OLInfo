package com.modiwu.myapplication.mvp.model;

import com.modiwu.myapplication.mvp.AppServer;

import io.reactivex.Observable;
import top.jplayer.baseprolibrary.mvp.model.bean.CartBean;
import top.jplayer.baseprolibrary.net.IoMainSchedule;
import top.jplayer.baseprolibrary.net.RetrofitManager;

/**
 * Created by Obl on 2018/3/20.
 * com.modiwu.myapplication.mvp.model
 */

public class ShopCartModel {
    public Observable<CartBean> getDetailBean() {
        return RetrofitManager.init()
                .create(AppServer.class)
                .getDetialBean().compose(new IoMainSchedule<>());
    }
}
