package com.github.easyguide;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by shenxl on 2018/8/17.
 */

public class ViewLocationUtils {
    public static Rect getViewAbsRect(Activity activity, View view) {
        int parentY = 0;
        final int[] locWin = new int[2];
        activity.getWindow().getDecorView().getLocationInWindow(locWin);
        parentY = locWin[1];
        if (parentY == 0) {
            Class<?> localClass;
            try {
                localClass = Class.forName("com.android.internal.R$dimen");
                Object localObject = localClass.newInstance();
                int i5 = Integer.parseInt(localClass.getField("status_bar_height").
                        get(localObject).toString());
                parentY = activity.getResources().getDimensionPixelSize(i5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int[] locView = new int[2];
        view.getLocationInWindow(locView);
        Rect rect = new Rect();
        rect.set(locView[0], locView[1], locView[0] + view.getMeasuredWidth(), locView[1] + view.getMeasuredHeight());
        rect.offset(0, -parentY);
        return rect;
    }
}
