package net.androidbootcamp.haiquizapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextClock;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    MediaPlayer splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash= new MediaPlayer();
        splash= MediaPlayer.create(this, R.raw.splashsound);
        splash.start();

        TextClock clock = (TextClock) findViewById(R.id.clock);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                //go to main activity page
                Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        };

        //set timer to begin
        Timer opening = new Timer();
        //Open for 4s or 4000miliseconds
        opening.schedule(task, 4000);

    }
}
