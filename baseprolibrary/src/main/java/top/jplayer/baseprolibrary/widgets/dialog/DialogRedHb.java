package top.jplayer.baseprolibrary.widgets.dialog;

import android.content.Context;
import android.view.View;

import top.jplayer.baseprolibrary.R;


/**
 * Created by vondear on 2016/7/19.
 * Mainly used for confirmation and cancel.
 */
public class DialogRedHb extends BaseCustomDialog {

    public DialogRedHb(Context context) {
        super(context);
    }

    @Override
    protected void initView(View view) {
        view.findViewById(R.id.ivCancel).setOnClickListener(v -> cancel());
    }


    @Override
    public int initLayout() {
        return R.layout.dialog_redhb;
    }

}
