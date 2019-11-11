package com.imuxuan.en.floatingview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.imuxuan.floatingview.FloatingMagnetView;
import com.imuxuan.floatingview.FloatingView;
import com.imuxuan.floatingview.MagnetViewListener;

/**
 * @ClassName TestActivity
 * @Description
 * @Author Yunpeng Li
 * @Creation 2018/3/15 下午5:01
 * @Mender Yunpeng Li
 * @Modification 2018/3/15 下午5:01
 */
public class TestActivity2 extends BaseActivity {

    boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
/*
        FloatingView.get().add();
        FloatingView.get().listener(new MagnetViewListener() {
            @Override
            public void onRemove(FloatingMagnetView magnetView) {
                Toast.makeText(TestActivity2.this, "我没了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClick(FloatingMagnetView magnetView) {
                Toast.makeText(TestActivity2.this, "点到我了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUpClick(FloatingMagnetView magnetView) {

            }

            @Override
            public void onTalkClick(FloatingMagnetView magnetView) {

            }
        });
*/
        findViewById(R.id.btn_new).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    flag = false;
                    FloatingView.get().detach(TestActivity2.this);
                } else {
                    flag = true;
                    FloatingView.get().attach(TestActivity2.this);
                }
//                createActivity(v);
            }
        });

    }

    public void createActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, TestActivity3.class);
        startActivity(intent);
    }
}
