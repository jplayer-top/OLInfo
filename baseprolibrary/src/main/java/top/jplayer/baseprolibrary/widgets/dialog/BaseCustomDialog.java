package top.jplayer.baseprolibrary.widgets.dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import top.jplayer.baseprolibrary.R;
import top.jplayer.baseprolibrary.utils.ScreenUtils;


/**
 * Created by PEO on 2017/2/24.
 * d
 */

public abstract class BaseCustomDialog extends Dialog {

    public Context mContext;
    public View mContentView;


    public BaseCustomDialog(Context context) {
        this(context, R.style.dialog_custom);
        mContext = context;
    }

    public BaseCustomDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        mContentView = View.inflate(context, initLayout(), null);
        initView(mContentView);
        super.setContentView(mContentView);
    }

    protected abstract void initView(View view);


    public abstract int initLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        assert window != null;
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lp.dimAmount = 0.5f;
        lp.width = setWidth(7);
        window.setGravity(setGravity());
        window.setWindowAnimations(setAnim());
        window.setAttributes(lp);
        setCanceledOnTouchOutside(true);// 点击Dialog外部消失
    }

    public int setAnim() {
        return R.style.AnimFade;
    }

    public int setGravity() {
        return Gravity.CENTER;
    }

    public int setWidth(int i) {
        return ScreenUtils.getScreenWidth() / 10 * i;
    }

    public void show(@IdRes int ids) {
        show(ids, v -> cancel());
    }

    public void show(@IdRes int ids, View.OnClickListener listener) {
        show();
        mContentView.findViewById(ids).setOnClickListener(listener);
    }

    @Override
    public void show() {
        if (!isShowing()) {
            super.show();
        }
    }
}
