package com.modiwu.myapplication.mvp;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import top.jplayer.baseprolibrary.mvp.model.bean.CartBean;

/**
 * Created by Obl on 2018/3/20.
 * com.modiwu.myapplication.mvp
 */

public interface AppServer {

    @Headers({"url_heard_host:test_url"})
    @GET("tools/mockapi/2247/cart")
    Observable<CartBean> getDetialBean();
}
