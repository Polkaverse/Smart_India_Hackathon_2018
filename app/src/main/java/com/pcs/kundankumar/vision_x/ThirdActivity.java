package com.pcs.kundankumar.vision_x;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class ThirdActivity extends AppCompatActivity {

    String pi,dt,med1,med2;
    private Button scan_btn , butto;
    private TextView textViewId, textViewDate ,textViewMed1 ,textViewMed2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        scan_btn = (Button)findViewById(R.id.sc_btn);

        textViewId = (TextView) findViewById(R.id.textView5);
        textViewDate = (TextView) findViewById(R.id.textView3);
        textViewMed1 = (TextView) findViewById(R.id.textView7);
        textViewMed2 = (TextView) findViewById(R.id.textView11);


        butto =(Button)findViewById(R.id.button2); // next activity



        final Activity activity = this;
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator= new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

        butto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent koi = new Intent(ThirdActivity.this, FourActivity.class);
                koi.putExtra("pid",pi);
                koi.putExtra("date",dt);
                koi.putExtra("m1",med1);
                koi.putExtra("m2",med2);
                startActivity(koi);


            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result= IntentIntegrator.parseActivityResult(requestCode , resultCode, data);
        if (result!=null) {
            if (result.getContents() == null) {
                Toast.makeText(this,"YOU CANCELLED THE SCANNING " , Toast.LENGTH_LONG).show();
            }
            else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    pi=obj.getString("patient-id");
                    dt=obj.getString("date");
                    med1=obj.getString("m1");
                    med2=obj.getString("m2");

                    if(med1.equals("Becosule")){
                        Intent koi=new Intent(ThirdActivity.this ,SixthActivity.class);
                        startActivity(koi);
                    }


                    if(true )        {

                        textViewId.setText(pi);
                        textViewDate.setText(obj.getString("date"));
                        textViewMed1.setText(obj.getString("m1"));
                        textViewMed2.setText(obj.getString("m2"));

                    }
                    else{
                        //Intent koio = new Intent(ThirdActivity.this, ThirteenthActivity.class);
                        //startActivity(koio);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast

                    //Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                    //Intent koio = new Intent(ThirdActivity.this, ThirteenthActivity.class);
                    //startActivity(koio);
                }
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
