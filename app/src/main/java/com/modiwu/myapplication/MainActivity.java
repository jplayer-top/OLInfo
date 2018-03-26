package com.modiwu.myapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.modiwu.myapplication.adapter.AdapterMain;
import com.modiwu.myapplication.mvp.model.bean.DialogInfo;
import com.modiwu.myapplication.mvp.presenter.ShopCartPresenter;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import top.jplayer.baseprolibrary.mvp.contract.IContract;
import top.jplayer.baseprolibrary.mvp.model.bean.CartBean;
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

public class MainActivity extends SuperBaseActivity implements IContract.IView {

    private AdapterMain mAdapter;

    @Override
    protected int initRootLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initRootData(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ArrayList<DialogInfo> beans = new ArrayList<>();
        beans.add(new DialogInfo("提交成功", "广告页,确认页", "http://file.jplayer.top/image/1.jpg"));
        beans.add(new DialogInfo("新手礼包", "新用户礼包，活动", "http://file.jplayer.top/image/2.jpg"));
        beans.add(new DialogInfo("抢红包", "抢红包动画，图片自己配", "http://file.jplayer.top/image/3.png"));
        beans.add(new DialogInfo("签到", "每日签到", "http://file.jplayer.top/image/4.jpg"));
        beans.add(new DialogInfo("分享", "可做成列表类型", "http://file.jplayer.top/image/5.jpg"));
        beans.add(new DialogInfo("输入框", "含有输入框，伴随打开输入法", "http://file.jplayer.top/image/6.png"));
        beans.add(new DialogInfo("加载中", "常见的加载，采用控件spitview", "http://file.jplayer.top/image/1.jpg"));
        beans.add(new DialogInfo("退出登录", "常见图片加文字确认取消类型", "http://file.jplayer.top/image/2.jpg"));
        beans.add(new DialogInfo("订单结算", "常用到的订单Dialog,仿淘宝，Json数据自行修改", "http://file.jplayer.top/image/3.png"));
        beans.add(new DialogInfo("选择器", "", "http://file.jplayer.top/image/4.jpg"));
        beans.add(new DialogInfo("输入法跟随弹出", "具体使用请查看：https://github.com/Bigkoo/Android-PickerView", "http://file.jplayer.top/image/5.jpg"));
        beans.add(new DialogInfo("选择列表", "内嵌RecycleView，常见选择框", "http://file.jplayer.top/image/6.png"));
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
                new ShopCartPresenter(this).getDetailBean();

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

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    public void showDetailBean(CartBean cartBean) {
        DialogFragmentOrder dialogOrder = new DialogFragmentOrder();
        Bundle arguments = new Bundle();
        arguments.putParcelable("cart", cartBean);
        dialogOrder.setArguments(arguments);
        dialogOrder.show(getSupportFragmentManager(), "order");
    }
}
