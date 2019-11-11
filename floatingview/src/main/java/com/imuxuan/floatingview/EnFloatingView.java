package com.imuxuan.floatingview;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.widget.ImageView;

/**
 * @ClassName EnFloatingView
 * @Description 悬浮窗
 * @Author Yunpeng Li
 * @Creation 2018/3/15 下午5:04
 * @Mender Yunpeng Li
 * @Modification 2018/3/15 下午5:04
 */
public class EnFloatingView extends FloatingMagnetView {

    private final ImageView mIcon;

    public EnFloatingView(@NonNull Context context) {
        super(context, null);
        inflate(context, R.layout.layout_intercom_audio_record_float, this);
        mIcon = findViewById(R.id.iv_audio_record);
    }

    public void setAudioRecordImage(@DrawableRes int resId){
        mIcon.setImageResource(resId);
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
                setCanTalk(true);
                setAudioRecordImage(R.drawable.ic_intercom_waiting);
                break;
            case 2: // 禁止对讲, 不准对讲, 等待解锁
                setCanTalk(false);
                setAudioRecordImage(R.drawable.ic_intercom_prohibit);
                break;
            case 3: // 按下事件, 更替对讲按钮背景
                setAudioRecordImage(R.drawable.ic_intercom_processing);
                break;
            case 4: // 抬起事件, 更新对讲按钮背景
                setAudioRecordImage(R.drawable.ic_intercom_waiting);
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

}
