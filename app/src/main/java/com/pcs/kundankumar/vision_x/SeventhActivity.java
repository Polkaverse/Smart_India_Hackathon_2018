package com.pcs.kundankumar.vision_x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SeventhActivity extends AppCompatActivity {
        public Button Bton1 , Bton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);

        Bton1 =(Button)findViewById(R.id.button5);
        Bton2 =(Button)findViewById(R.id.button6);

        Bton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent poi=new Intent(SeventhActivity.this , SixthActivity.class);
                startActivity(poi);
            }
        });
        Bton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent poi=new Intent(SeventhActivity.this , SixthActivity.class);
                startActivity(poi);
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
