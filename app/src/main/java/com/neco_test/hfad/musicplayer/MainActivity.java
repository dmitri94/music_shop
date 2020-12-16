package com.neco_test.hfad.musicplayer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
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
    private int min;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       init(); // инициализация

       mediaPlayer = MediaPlayer.create(this, R.raw.crujit);


        createSeeBar(mediaPlayer); // линия под аудио трэком (слудит за моментом воспроизведения)

    }

    private void createSeeBar(MediaPlayer seek) {
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) { // если fromUser у нас true то пользователь может менять положение SeekBar
                    mediaPlayer.seekTo(progress); // с помощью этого метода мы пожем перематывать музыку
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
       new Timer().scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
               seekBar.setProgress(seek.getCurrentPosition());
           }
       }, 0, 500);
    }


    public void onClickNext(View view) {

        seekBar.setProgress(mediaPlayer.getDuration());
        mediaPlayer.seekTo(mediaPlayer.getDuration());
        mediaPlayer.pause();
        imagePause.setImageResource(R.drawable.icon_play);

    }

    public void onClickPlay(View view) {

        if(mediaPlayer.isPlaying()) {
            imagePause.setImageResource(R.drawable.icon_play);
            mediaPlayer.pause();


        } else  {
            mediaPlayer.start();
            imagePause.setImageResource(R.drawable.icon_pause);


        }
    }


    public void onClickBack(View view) {
      seekBar.setProgress(0);
      mediaPlayer.seekTo(0);
      mediaPlayer.pause();
      imagePause.setImageResource(R.drawable.icon_play);

    }

    private void init() {
        imagePause = findViewById(R.id.imagePlay);
        seekBar = findViewById(R.id.seekBar);
    }
}