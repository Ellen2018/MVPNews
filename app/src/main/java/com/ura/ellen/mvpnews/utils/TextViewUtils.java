package com.ura.ellen.mvpnews.utils;

import android.graphics.Paint;
import android.widget.TextView;

public class TextViewUtils {

    /**
     * 判断是否TextView的文字有省略...
     * @param textView
     * @return
     */
    public static boolean isShengLuo(TextView textView){

        Paint paint = textView.getPaint();
        float width = paint.measureText(textView.getText().toString());
        if (width > (textView.getWidth() - textView.getPaddingLeft() - textView.getPaddingRight())) {
            textView.setSelected(true);
            return true;
        }
        textView.setSelected(false);
        return false;
    }

}
