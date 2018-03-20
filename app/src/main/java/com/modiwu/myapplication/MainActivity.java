package com.modiwu.myapplication;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.modiwu.myapplication.adapter.AdapterMain;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import top.jplayer.baseprolibrary.ui.SuperBaseActivity;
import top.jplayer.baseprolibrary.utils.LogUtil;
import top.jplayer.baseprolibrary.utils.PickerUtils;
import top.jplayer.baseprolibrary.widgets.dialog.DialogEdit;
import top.jplayer.baseprolibrary.widgets.dialog.DialogEditBottom;
import top.jplayer.baseprolibrary.widgets.dialog.DialogFragmentFilter;
import top.jplayer.baseprolibrary.widgets.dialog.DialogLoading;
import top.jplayer.baseprolibrary.widgets.dialog.DialogLogout;
import top.jplayer.baseprolibrary.widgets.dialog.DialogNoviceGuide;
import top.jplayer.baseprolibrary.widgets.dialog.DialogFragmentOrder;
import top.jplayer.baseprolibrary.widgets.dialog.DialogRedHb;
import top.jplayer.baseprolibrary.widgets.dialog.DialogShare;
import top.jplayer.baseprolibrary.widgets.dialog.DialogSign;
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
        beans.add("签到");
        beans.add("分享");
        beans.add("输入框");
        beans.add("加载中");
        beans.add("退出登录");
        beans.add("订单结算");
        beans.add("选择器");
        beans.add("输入法跟随弹出");
        beans.add("选择列表");
        mAdapter = new AdapterMain(beans);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((adapter, v, position) -> {
            if (position == 0) {
                new DialogSubmitSure(this).show(R.id.iv_sure);
            } else if (position == 1) {
                new DialogNoviceGuide(this).show(R.id.ivFree);
            } else if (position == 2) {
                DialogRedHb dialogRedHb = new DialogRedHb(this);
                dialogRedHb.show(R.id.ivOpen, v1 -> {
                    Disposable disposable = dialogRedHb.looperAnim(v1);
                    //模拟网络请求
                    Observable.timer(2000, TimeUnit.MILLISECONDS).subscribe(new Observer<Long>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            LogUtil.method();

                        }

                        @Override
                        public void onNext(Long aLong) {
                            LogUtil.method();


                        }

                        @Override
                        public void onError(Throwable e) {
                            LogUtil.method();

                        }

                        @Override
                        public void onComplete() {
                            LogUtil.method();
                            if (!disposable.isDisposed()) {
                                disposable.dispose();
                            }
                        }
                    });
                });
            } else if (position == 3) {
                new DialogSign(this).show();
            } else if (position == 4) {
                new DialogShare(this).show();
            } else if (position == 5) {
                new DialogEdit(this).show();
            } else if (position == 6) {
                new DialogLoading(this).show();
            } else if (position == 7) {
                new DialogLogout(this).show();
            } else if (position == 8) {
                DialogFragmentOrder dialogOrder = new DialogFragmentOrder();
                dialogOrder.show(getSupportFragmentManager(), "order");
            } else if (position == 9) {
                //具体使用请查看：https://github.com/Bigkoo/Android-PickerView
                PickerUtils pickerUtils = new PickerUtils();
                pickerUtils.initTimePicker(this);
                pickerUtils.pvTime.show();
            } else if (position == 10) {
                new DialogEditBottom(this).show();
            } else if (position == 11) {
                DialogFragmentFilter filter = new DialogFragmentFilter();
                filter.show(getSupportFragmentManager(), "filter");
            }
        });
    }
}
