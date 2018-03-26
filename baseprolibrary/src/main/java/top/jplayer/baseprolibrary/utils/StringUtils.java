package top.jplayer.baseprolibrary.utils;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Obl on 2018/3/14.
 * top.jplayer.baseprolibrary.utils
 */

public class StringUtils {
    private static StringUtils mStrUtils;

    public static StringUtils init() {
        if (mStrUtils == null) {
            mStrUtils = new StringUtils();
        }
        return mStrUtils;
    }

    public boolean isEmpty(String string) {
        return TextUtils.isEmpty(string);
    }

    public boolean isEmpty(CharSequence sequence) {
        return TextUtils.isEmpty(sequence);
    }

    public boolean isEmpty(TextView textView) {
        return TextUtils.isEmpty(textView.getText());
    }

    public String fixNullStr(CharSequence sequence) {
        return fixNullStr(sequence.toString());
    }

    public String fixNullStr(String string) {
        if (isEmpty(string)) {
            return "";
        }
        return string;
    }

    /**
     * @param preStr 判断的str
     * @param aftStr 如果是空，返回的str
     * @return aftStr
     */
    public String fixNullStr(String preStr, String aftStr) {
        if (isEmpty(preStr)) {
            return aftStr;
        }
        return preStr;
    }


    public void tipEditTextLength(EditText edit, Editable s, int maxLen, String msg) {
        if (s.length() > maxLen) {
            ToastUtils.init().showQuickToast(msg);
            edit.setText(s.subSequence(0, maxLen));
            edit.setSelection(edit.getText().length());
        }
    }
}
