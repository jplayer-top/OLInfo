package com.modiwu.myapplication.mvp.model.bean;

import top.jplayer.baseprolibrary.mvp.model.bean.BaseBean;

/**
 * Created by Obl on 2018/3/21.
 * com.modiwu.myapplication.mvp.model.bean
 */

public class DialogInfo extends BaseBean {
  public String title;
  public String subTitle;
  public String src;

    public DialogInfo(String title, String subTitle, String src) {
        this.title = title;
        this.subTitle = subTitle;
        this.src = src;
    }
}
