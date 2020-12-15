package com.neco_test.hfad.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private ImageView imagePause;
    private SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       init();

       mediaPlayer = MediaPlayer.create(this, R.raw.love_is_gone);
        seekBar.setMax(mediaPlayer.getDuration());
       createSeeBar(mediaPlayer);

    }

    private void createSeeBar(MediaPlayer seek) {
       new Timer().scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
               seekBar.setProgress(seek.getCurrentPosition());
           }
       }, 0, 500);
    }


    public void onClickNext(View view) {
    }

    public void onClickPlay(View view) {
        if(mediaPlayer.isPlaying()) {
            imagePause.setImageResource(R.drawable.icon_play);
            mediaPlayer.pause();


        } else {
            imagePause.setImageResource(R.drawable.icon_pause);
            mediaPlayer.start();
        }
    }

    public void onClickBack(View view) {
    }

    private void init() {
        imagePause = findViewById(R.id.imagePlay);
        seekBar = findViewById(R.id.seekBar);
    }
}