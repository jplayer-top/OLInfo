package top.jplayer.baseprolibrary;

import android.app.Application;
import android.content.Context;
import android.util.ArrayMap;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;

import okhttp3.Interceptor;
import top.jplayer.baseprolibrary.net.RetrofitManager;

/**
 * Created by Obl on 2018/1/9.
 * top.jplayer.baseprolibrary
 */

public class BaseInitApplication {


    private static BaseInitApplication mInit;
    public static WeakReference<Context> mWeakReference;
    public static Map<String, String> mUrlMap;
    public static final String urlHeardHost = "url_heard_host";
    public static final Long TIME_OUT = 30L;

    private BaseInitApplication(Application application) {
        mWeakReference = new WeakReference<>(application.getApplicationContext());
        mUrlMap = new ArrayMap<>();
    }

    public BaseInitApplication retrofit() {
        RetrofitManager.init().client(mWeakReference.get()).build(BuildConfig.HOST);
        return this;
    }

    public BaseInitApplication retrofit(Interceptor... interceptors) {
        RetrofitManager.init().client(mWeakReference.get(), Arrays.asList(interceptors)).build(BuildConfig.HOST);
        return this;
    }


    public static Context getContext() {
        return mWeakReference.get();
    }

    public synchronized static BaseInitApplication init(Application application) {
        if (mInit == null) {
            synchronized (BaseInitApplication.class) {
                if (mInit == null) {
                    mInit = new BaseInitApplication(application);
                }
            }
        }
        return mInit;
    }

    public BaseInitApplication addUrl(String key, String value) {
        mUrlMap.put(key, value);
        return this;
    }

    public BaseInitApplication urlMap(Map<String, String> map) {
        mUrlMap.putAll(map);
        return this;
    }

    public static final int DEF_REQUEST = 1;
}
