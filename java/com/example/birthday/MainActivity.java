package com.example.birthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView name;
    private static final int TIME_INTERVAL = 2000;
    private long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.get_gift_button);
        name = findViewById(R.id.name_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                Intent intent=new Intent(MainActivity.this,GreetingActivity.class);
                intent.putExtra("yourname",username);
                startActivity(intent);
            }
        });
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