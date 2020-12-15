package com.neco_test.hfad.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttonMusic);

      //  ActionBar actionBar = getSupportActionBar();
      //  assert actionBar != null;
      //  actionBar.setTitle((Html.fromHtml("<font color=\"#F49015\">" + getString(R.string.app_name) + "</font>")));


        mediaPlayer = MediaPlayer.create(this, R.raw.love_is_gone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    button.setText("Play");
                } else {
                    mediaPlayer.start();
                    button.setText("Pause");
                }
            }
        });

    }
}