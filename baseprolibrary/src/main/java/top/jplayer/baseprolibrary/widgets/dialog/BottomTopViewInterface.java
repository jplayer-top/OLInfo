package top.jplayer.baseprolibrary.widgets.dialog;

import android.view.ViewGroup;

/**
 * Created by Li on 2017/2/16.
 */

public interface BottomTopViewInterface {


    /**
     * getContentLayoutId()中布局和数据绑定
     *
     */
    void bindContent(ViewGroup viewGroup);

    /**
     * 内容所属的layoutId
     */
    int getContentLayoutId();


    /**
     * 内容是显示在上方还是下方

     */
    int getGravity();
}
