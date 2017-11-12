package com.gra.grsalerm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by taku24 on 2017/11/12.
 */

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    private MediaPlayer mMediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            AssetFileDescriptor afdescripter = context.getAssets().openFd("f1.mp3"); // assetsから音声データを取得
            mMediaPlayer = new MediaPlayer(); // このオブジェクトが音声データの操作を担う
            mMediaPlayer.setDataSource(afdescripter.getFileDescriptor(), afdescripter.getStartOffset(), afdescripter.getLength()); // 取得した音声データをMediaPlayerオブジェクトに教える
            mMediaPlayer.prepare(); // ※：再生準備が整うまでブロックする
            mMediaPlayer.start(); // 再生
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                }
            });
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
