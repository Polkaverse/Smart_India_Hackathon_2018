package com.pcs.kundankumar.vision_x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FifthActivity extends AppCompatActivity {
        public TextView txtview;
        public String str , str2, str3 , str4;
        public int Total=1 ;
        public String s1="20",s2="30";
        public Button BTN;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        txtview=(TextView)findViewById(R.id.textView3);
        BTN=(Button)findViewById(R.id.button11);

        str=getIntent().getStringExtra("p1");
        str2=getIntent().getStringExtra("p2");
        str3=getIntent().getStringExtra("p5");
        str4=getIntent().getStringExtra("p6");


        int result = Integer.parseInt(str);
        int result1 = Integer.parseInt(str2);
        //if (s1.equals(str)){
         //   Total=30;
         //   }
            /*else {
            if(s2.equals(str)){
                Total=40;
            }
            else{
                Total=50;
            }
        } */

        txtview.setText("30");
        BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent koi=new Intent(FifthActivity.this ,NinthActivity.class);
                startActivity(koi);
            }
        });
    }
}
