package top.jplayer.baseprolibrary.widgets.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.github.ybq.android.spinkit.SpinKitView;

import top.jplayer.baseprolibrary.R;
import top.jplayer.baseprolibrary.utils.ToastUtils;

/**
 * Created by Administrator on 2017/3/16.
 * 加载中
 */

public class DialogLoading extends BaseCustomDialog {

    private SpinKitView mLoadingView;
    private TextView mTextView;

    public DialogLoading(Context context) {
        super(context);
    }

    @Override
    protected void initView(View view) {
        mLoadingView = view.findViewById(R.id.spin_kit);
        mTextView = view.findViewById(R.id.name);
    }

    @Override
    public int initLayout() {
        return R.layout.dialog_loading_spinkit;
    }

    public void setLoadingText(CharSequence charSequence) {
        mTextView.setText(charSequence);
    }

    public void setLoadingColor(int color) {
        mLoadingView.setColor(color);
    }

    public void cancel(String str) {
        cancel();
        ToastUtils.init().showQuickToast(getContext(), str);
    }

    public SpinKitView getLoadingView() {
        return mLoadingView;
    }


    public TextView getTextView() {
        return mTextView;
    }

}
