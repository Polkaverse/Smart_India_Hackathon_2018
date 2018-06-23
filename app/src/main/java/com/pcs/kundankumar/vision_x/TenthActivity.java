package com.pcs.kundankumar.vision_x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;
public class TenthActivity extends AppCompatActivity {
    Timer timer;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("CustomerId");

        timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mDatabase.child("CH100265").setValue("10-06-2018");
                Intent in=new Intent(TenthActivity.this,MainActivity.class);
                startActivity(in);

                finish();


            }
        },2000);

    }
}
