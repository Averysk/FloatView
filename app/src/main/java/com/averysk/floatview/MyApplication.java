package com.averysk.floatview;

import android.app.Application;
import android.widget.Toast;

import com.averysk.floatview.globals.FloatIntercomManage;
import com.averysk.floatview.view.FloatViewMagnet;
import com.averysk.floatview.view.IFloatingViewMagnet;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        addFloatView();
    }

    // 添加悬浮窗
    private void addFloatView() {
        FloatIntercomManage.getInstance().initFloatView();
        // 注册悬浮窗事件回调
        registerFloatIntercomListener();
    }
    // 注册监听对讲悬浮窗口事件
    private void registerFloatIntercomListener() {
        FloatIntercomManage.getInstance().listenerFloatView(new IFloatingViewMagnet() {
            @Override
            public void onRemove(FloatViewMagnet magnetView) {
                Toast.makeText(getApplicationContext(), "按钮消了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClick(FloatViewMagnet magnetView) {
                Toast.makeText(getApplicationContext(), "单击我了", Toast.LENGTH_SHORT).show();
                FloatIntercomManage.getInstance().setTalkStatus(6);
            }

            @Override
            public void onDoubleClick(FloatViewMagnet magnetView) {
                Toast.makeText(getApplicationContext(), "双击我了", Toast.LENGTH_SHORT).show();
                FloatIntercomManage.getInstance().setTalkStatus(5);
            }

            @Override
            public void onUpClick(FloatViewMagnet magnetView) {
                Toast.makeText(getApplicationContext(), "抬起按钮", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTalkClick(FloatViewMagnet magnetView) {
                Toast.makeText(getApplicationContext(), "长按/按住", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
