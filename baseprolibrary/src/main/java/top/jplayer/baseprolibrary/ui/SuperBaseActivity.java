package top.jplayer.baseprolibrary.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import top.jplayer.baseprolibrary.R;
import top.jplayer.baseprolibrary.utils.KeyboardUtils;
import top.jplayer.baseprolibrary.utils.StringUtils;

/**
 * Created by Obl on 2018/1/9.
 * top.jplayer.baseprolibrary.ui
 */

public abstract class SuperBaseActivity extends AppCompatActivity {


    public View superRootView;

    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRootBundle(savedInstanceState);
        superRootView = initRootView();
        setContentView(superRootView);
        initRootData(superRootView);
        initInject(superRootView);
    }

    protected View initRootView() {
        int layout = initRootLayout();
        if (layout == 0) {
            layout = R.layout.layout_test;
        }
        return View.inflate(this, layout, null);
    }

    /**
     * 依赖注入
     */
    public void initInject(View view) {
    }

    @LayoutRes
    protected abstract int initRootLayout();

    /**
     * 默认原始根布局下的FrameLayout,基于相同ToolBar 的视图
     *
     * @param view 根布局
     */
    public abstract void initRootData(View view);


    /**
     * 保存状态,可设置一些公共代码
     *
     * @param savedInstanceState 所保存的状态信息
     */
    public void initRootBundle(Bundle savedInstanceState) {

    }

    /**
     * 设置文字
     *
     * @param viewResId
     * @param text
     */
    public void setText(@IdRes int viewResId, CharSequence text) {
        TextView tv = findViewById(viewResId);
        tv.setText(StringUtils.init().fixNullStr(text));
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        saveInstanceState(outState, outPersistentState);
    }

    public void saveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restoreInstanceState(savedInstanceState);
    }

    public void restoreInstanceState(Bundle savedInstanceState) {

    }

    /**
     * 是否检查关闭软键盘
     */
    protected boolean isCheckKeyboard = true;

    /**
     * 点击空白处关闭软键盘
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isCheckKeyboard)
            KeyboardUtils.init().clickBound2CloseInput(this, ev);
        return super.dispatchTouchEvent(ev);
    }
}
