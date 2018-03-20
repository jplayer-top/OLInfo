package com.modiwu.myapplication.mvp.presenter;

import com.modiwu.myapplication.MainActivity;
import com.modiwu.myapplication.mvp.model.ShopCartModel;

import top.jplayer.baseprolibrary.mvp.contract.BasePresenter;
import top.jplayer.baseprolibrary.mvp.model.bean.CartBean;
import top.jplayer.baseprolibrary.net.SampleShowDialogObserver;

/**
 * Created by Obl on 2018/3/20.
 * com.modiwu.myapplication.mvp.presenter
 */

public class ShopCartPresenter extends BasePresenter<MainActivity> {

    private final ShopCartModel mModel;

    public ShopCartPresenter(MainActivity iView) {
        super(iView);
        mModel = new ShopCartModel();
    }

    public void getDetailBean() {
        mModel.getDetailBean().subscribe(new SampleShowDialogObserver<CartBean>(mIView) {
            @Override
            protected void onSuccess(CartBean cartBean) throws Exception {
                mIView.showDetailBean(cartBean);
            }
        });
    }
}
