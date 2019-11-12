package com.averysk.floatview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.averysk.floatview.globals.FloatIntercomManage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatIntercomManage.getInstance().showFloatView(this);
        FloatIntercomManage.getInstance().setNeedMoveBottom(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        FloatIntercomManage.getInstance().hideFloatView(this);
    }

}
