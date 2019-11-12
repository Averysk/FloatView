package com.averysk.floatview.view;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

/**
 * Created by Averysk
 */

public interface IFloatingView {

    FloatViewManager remove();

    FloatViewManager add();

    FloatViewManager attach(Activity activity);

    FloatViewManager attach(FrameLayout container);

    FloatViewManager detach(Activity activity);

    FloatViewManager detach(FrameLayout container);

    FloatView getView();

    ImageView getImageView();

    FloatViewManager icon(@DrawableRes int resId);

    FloatViewManager layoutParams(ViewGroup.LayoutParams params);

    FloatViewManager listener(IFloatingViewMagnet magnetViewListener);

}
