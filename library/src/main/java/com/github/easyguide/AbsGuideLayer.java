package com.github.easyguide;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by shenxl on 2018/8/16.
 */

public abstract class AbsGuideLayer {
    private ILayerCallback mCallback;

    public ILayerCallback getCallback() {
        return mCallback;
    }

    public void setCallback(ILayerCallback callback) {
        mCallback = callback;
    }

    protected abstract View makeView(Context context);

    protected abstract AbsGuideLayer nextLayer();

    public interface ILayerCallback {
        void dismissCurrent();
        void dismissAll();
    }
}
