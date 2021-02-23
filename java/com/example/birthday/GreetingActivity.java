package com.example.birthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

public class GreetingActivity extends AppCompatActivity {

    private TextView name;
    static MediaPlayer introsong;

    private static final int TIME_INTERVAL = 2000;
    private long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        introsong = MediaPlayer.create(GreetingActivity.this,R.raw.happy_music);
        introsong.start();

        name=findViewById(R.id.happybirthday);

        String username = getIntent().getStringExtra("yourname");

        name.setText(username);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(GreetingActivity.this,final_activity.class));
            }
        },12000);
    }

    @Override
    public void onBackPressed() {
        if(backPressed+TIME_INTERVAL> System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        }
        else {
            Toast.makeText(getBaseContext(),"Press Back Again to Exit App",Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }
}