package top.jplayer.baseprolibrary.widgets.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import top.jplayer.baseprolibrary.R;


/**
 * Created by vondear on 2016/7/19.
 * Mainly used for confirmation and cancel.
 */
public class DialogFlowSure extends BaseBottomDialog {

    private ImageView iv_sure;

    public DialogFlowSure(Context context) {
        super(context);
    }


    @Override
    protected void initView(View view) {

    }

    @Override
    public int initLayout() {
        return R.layout.dialog_sure;
    }

    public void setSureListener(View.OnClickListener listener) {
        iv_sure.setOnClickListener(listener);
    }
}
