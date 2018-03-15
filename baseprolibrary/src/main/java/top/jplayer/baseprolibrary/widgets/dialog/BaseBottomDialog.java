package top.jplayer.baseprolibrary.widgets.dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
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

public abstract class BaseBottomDialog extends Dialog {

    public Context mContext;

    public BaseBottomDialog(Context context) {
        this(context, R.style.dialog_custom);
        mContext = context;
    }

    public BaseBottomDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        View view = View.inflate(getContext(), initLayout(), null);
        initView(view);
        super.setContentView(view);
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
        lp.width = setWidth();
        window.setGravity(setGravity());
        window.setWindowAnimations(setAnim());
        window.setAttributes(lp);
        setCanceledOnTouchOutside(true);// 点击Dialog外部消失
    }

    public void setGravityAnim() {

    }

    public int setAnim() {
        return R.style.AnimCenter;
    }

    public int setGravity() {
        return Gravity.CENTER;
    }

    public int setWidth() {
        return ScreenUtils.getScreenWidth() / 10 * 7;
    }

    @Override
    public void show() {
        if (!isShowing()) {
            super.show();
        }
    }
}
