package com.pcs.kundankumar.vision_x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class ThirteenthActivity extends AppCompatActivity {
Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirteenth);

        timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //mDatabase.child("CH100265").setValue("10-06-2018");
                Intent in=new Intent(ThirteenthActivity.this,MainActivity.class);
                startActivity(in);

                finish();


            }
        },2000);
    }
}
