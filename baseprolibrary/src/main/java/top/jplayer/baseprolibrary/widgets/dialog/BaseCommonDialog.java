package top.jplayer.baseprolibrary.widgets.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import top.jplayer.baseprolibrary.R;

public class BaseCommonDialog extends Dialog {

    protected Context mContext;

    protected LayoutParams mLayoutParams;
    private Window mWindow;

    public LayoutParams getLayoutParams() {
        return mLayoutParams;
    }

    public BaseCommonDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public BaseCommonDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public BaseCommonDialog(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mWindow = this.getWindow();
        assert mWindow != null;
        mWindow.setBackgroundDrawableResource(R.drawable.transparent_bg);
        mContext = context;
        mLayoutParams = mWindow.getAttributes();
        mLayoutParams.alpha = 1f;
        mWindow.setAttributes(mLayoutParams);
        if (mLayoutParams != null) {
            mLayoutParams.height = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
            mLayoutParams.gravity = Gravity.CENTER;
        }
    }

    /**
     * @param context
     * @param alpha   透明度 0.0f--1f(不透明)
     * @param gravity 方向(Gravity.BOTTOM,Gravity.TOP,Gravity.LEFT,Gravity.RIGHT)
     */
    public BaseCommonDialog(Context context, float alpha, int gravity) {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mWindow = this.getWindow();
        assert mWindow != null;
        mWindow.setBackgroundDrawableResource(R.drawable.transparent_bg);
        mContext = context;
        mLayoutParams = mWindow.getAttributes();
        mLayoutParams.alpha = alpha;
        mWindow.setAttributes(mLayoutParams);
        if (mLayoutParams != null) {
            mLayoutParams.height = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
            mLayoutParams.gravity = gravity;
        }
    }

    /**
     * 隐藏头部导航栏状态栏
     */
    @SuppressLint("ObsoleteSdkInt")
    public void skipTools() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        mWindow.setFlags(LayoutParams.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 设置全屏显示
     */
    public void setFullScreen() {
        mWindow.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams lp = mWindow.getAttributes();
        lp.width = LayoutParams.MATCH_PARENT;
        lp.height = LayoutParams.MATCH_PARENT;
        mWindow.setAttributes(lp);
    }

    /**
     * 设置宽度match_parent
     */
    public void setFullScreenWidth() {
        mWindow.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams lp = mWindow.getAttributes();
        lp.width = LayoutParams.MATCH_PARENT;
        lp.height = LayoutParams.WRAP_CONTENT;
        mWindow.setAttributes(lp);
    }

    /**
     * 设置高度为match_parent
     */
    public void setFullScreenHeight() {
        mWindow.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams lp = mWindow.getAttributes();
        lp.width = LayoutParams.WRAP_CONTENT;
        lp.height = LayoutParams.MATCH_PARENT;
        mWindow.setAttributes(lp);
    }

    public void setOnWhole() {
        mWindow.setType(LayoutParams.TYPE_SYSTEM_ALERT);
    }
}
