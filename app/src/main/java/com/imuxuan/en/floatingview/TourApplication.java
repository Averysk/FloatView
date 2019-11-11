package com.imuxuan.en.floatingview;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.imuxuan.floatingview.FloatingMagnetView;
import com.imuxuan.floatingview.FloatingView;
import com.imuxuan.floatingview.MagnetViewListener;

/**
 * @author tanlei
 * @date 2019/8/7
 * @describe Application
 */

public class TourApplication extends Application {

    public static TourApplication INSTANCE;

    public static TourApplication getInstance() {
        return INSTANCE;
    }

    public static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        context = this;
        initFloatWindow();
    }

    // 悬浮窗
    private void initFloatWindow() {
        FloatingView.get().add();
        FloatingView.get().listener(new MagnetViewListener() {
            @Override
            public void onRemove(FloatingMagnetView magnetView) {
                Toast.makeText(context, "我没了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClick(FloatingMagnetView magnetView) {
                Toast.makeText(context, "点到我了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClick(FloatingMagnetView magnetView) {
                Toast.makeText(context, "双击到我了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUpClick(FloatingMagnetView magnetView) {
            }

            @Override
            public void onTalkClick(FloatingMagnetView magnetView) {

            }
        });

    }

}
