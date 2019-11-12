package com.averysk.floatview.view;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.airbnb.lottie.LottieAnimationView;
import com.averysk.floatview.R;

/**
 * @ClassName EnFloatingView
 * @Description 悬浮窗
 * @Author Averysk
 */
public class FloatView extends FloatViewMagnet implements View.OnClickListener {

    private final ImageView ivAudioRecord; // 对讲按键
    private final LottieAnimationView lav_anim; // 对讲动画
    private ImageView iv_intercom_group;
    private ImageView iv_intercom_hide;

    public FloatView(@NonNull Context context) {
        super(context, null);
        inflate(context, R.layout.layout_intercom_float_audio_record, this);
        ivAudioRecord = findViewById(R.id.iv_audio_record);
        lav_anim = findViewById(R.id.lav_anim);
        iv_intercom_group = findViewById(R.id.iv_intercom_group);
        iv_intercom_hide = findViewById(R.id.iv_intercom_hide);
        iv_intercom_group.setOnClickListener(this);
        iv_intercom_hide.setOnClickListener(this);
    }

    // 设置按钮图片
    public void setAudioRecordImage(@DrawableRes int resId){
        ivAudioRecord.setImageResource(resId);
    }
    // 设置按钮图片
    public void playAnim(boolean flag){
        if (flag) {
            // 显示动画
            lav_anim.playAnimation();
            lav_anim.setVisibility(View.VISIBLE);
        } else {
            // 隐藏动画
            lav_anim.cancelAnimation();
            lav_anim.setVisibility(View.GONE);
        }
    }

    public ImageView getIvAudioRecord() {
        return ivAudioRecord;
    }

    // 设置是否能够开启对讲
    @Override
    public void setCanTalk(boolean canTalk) {
        super.setCanTalk(canTalk);
        if (canTalk){
            setAudioRecordImage(R.mipmap.ic_intercom_waiting);
        } else {
            setAudioRecordImage(R.mipmap.ic_intercom_prohibit);
        }
    }

    @Override
    public void setNeedMoveBottom(boolean needMoveBottom) {
        super.setNeedMoveBottom(needMoveBottom);
    }

    /**
     * 设置当前对讲按钮类型
     * @param type
     *              1:正常状态, 能够对讲, 等待对讲
     *              2:禁止对讲, 不准对讲, 等待解锁
     *              3:按下事件, 更替对讲按钮背景
     *              4:抬起事件, 更新对讲按钮背景
     */
    @Override
    public void setTalkStatus(int type) {
        switch (type){
            case 1: // 正常状态, 能够对讲, 等待对讲
                Log.e("AnyRtc","1正常状态, 能够对讲, 等待对讲");
                setCanTalk(true);
                setAudioRecordImage(R.mipmap.ic_intercom_waiting);
                break;
            case 2: // 禁止对讲, 不准对讲, 等待解锁
                Log.e("AnyRtc","2禁止对讲, 不准对讲, 等待解锁");
                setCanTalk(false);
                setAudioRecordImage(R.mipmap.ic_intercom_prohibit);
                break;
            case 3: // 按下事件, 更替对讲按钮背景
                Log.e("AnyRtc","3按下事件, 更替对讲按钮背景");
                setAudioRecordImage(R.mipmap.ic_intercom_processing);
                break;
            case 4: // 抬起事件, 更新对讲按钮背景
                Log.e("AnyRtc","4抬起事件, 更新对讲按钮背景");
                setAudioRecordImage(R.mipmap.ic_intercom_waiting);
                break;
            case 5: // 双击事件, 更新对讲按钮背景
                Log.e("AnyRtc","5双击事件, 更新对讲按钮背景");
                setCanTalk(false);
                setAudioRecordImage(R.mipmap.ic_intercom_double_click);
                iv_intercom_group.setVisibility(VISIBLE);
                iv_intercom_hide.setVisibility(VISIBLE);
                break;
            case 6:
                Log.e("AnyRtc","双击事件后再次单击,6正常状态, 能够对讲, 等待对讲");
                setCanTalk(true);
                reSet();
                break;
        }
    }
    public void reSet() {
        setAudioRecordImage(R.mipmap.ic_intercom_waiting);
        iv_intercom_group.setVisibility(GONE);
        iv_intercom_hide.setVisibility(GONE);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_intercom_group: // 显示切换群对讲的群列表
                break;
            case R.id.iv_intercom_hide: // 隐藏群对讲
                reSet();
                break;
        }
    }
}
