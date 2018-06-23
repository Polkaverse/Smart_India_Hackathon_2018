package com.pcs.kundankumar.vision_x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EightActivity extends AppCompatActivity {
        public Button bton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);
        bton=(Button)findViewById(R.id.button7);
        bton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent koi=new Intent(EightActivity.this ,NinthActivity.class);
                startActivity(koi);
            }
        });
    }
}
