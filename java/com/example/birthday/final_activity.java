package com.example.birthday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class final_activity extends AppCompatActivity {

    private static final int TIME_INTERVAL = 2000;
    private long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_activity);
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