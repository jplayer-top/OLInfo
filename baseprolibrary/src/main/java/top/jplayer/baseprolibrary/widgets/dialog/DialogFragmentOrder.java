package top.jplayer.baseprolibrary.widgets.dialog;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import top.jplayer.baseprolibrary.R;

/**
 * Created by Obl on 2018/3/15.
 * top.jplayer.baseprolibrary.widgets.dialog
 */

public class DialogFragmentOrder extends BaseCustomDialogFragment {


    @Override
    public int setAnim() {
        return R.style.AnimBottom;
    }

    @Override
    public int setGravity() {
        return Gravity.BOTTOM;
    }

    @Override
    protected void initView(View view) {
        view.findViewById(R.id.ivCancel).setOnClickListener(v -> dismiss());
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public int initLayout() {
        return R.layout.dialog_order;
    }
}
