package com.pcs.kundankumar.vision_x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class FourActivity extends AppCompatActivity {
    private TextView idview, idview2  , idview3 , idview4 , idview5 ;
    public DatabaseReference mfirebase , mfg;
    private String p   ,   mediprice,  medi2price , mediq  , medi2q;
    public String dt,med11,med22;
    private Button Btn;
    public int resultp , resultq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        idview=(TextView)findViewById(R.id.textViewb);
        idview2=(TextView)findViewById(R.id.textViewb2);
        idview3=(TextView)findViewById(R.id.textViewb3);
        idview4=(TextView)findViewById(R.id.textViewb4);
        idview5=(TextView)findViewById(R.id.textViewb5);
        Btn=(Button)findViewById(R.id.buttonr);


        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent pay=new Intent(FourActivity.this,FifthActivity.class);
                        pay.putExtra("p1",mediprice);
                        pay.putExtra("p2",medi2price);
                        pay.putExtra("p3",mediq);
                        pay.putExtra("p4",medi2q);
                        pay.putExtra("p5",med11);
                        pay.putExtra("p6",med22);
                        startActivity(pay);
            }
        });



        p=getIntent().getStringExtra("pid");
        dt=getIntent().getStringExtra("date");
        med11=getIntent().getStringExtra("m1");
        med22=getIntent().getStringExtra("m2");


        mfirebase= FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mcd=mfirebase.child("CustomerId");
        DatabaseReference mfg=mfirebase.child("Medicines");


                DatabaseReference msd=mcd.child(String.valueOf(p));

                msd.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                        String value =dataSnapshot.getValue(String.class);

                        if(value.equals(dt)) {
                            Intent koio = new Intent(FourActivity.this, ThirteenthActivity.class);
                            startActivity(koio);
                        }
                        else{

                            inventry();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



    }
    public void inventry(){
        DatabaseReference mfg=mfirebase.child("Medicines");
        DatabaseReference medref=mfg.child(med11);

                medref.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                         mediprice=dataSnapshot.child("Price").getValue(String.class);
                        mediq=dataSnapshot.child("Quantity").getValue(String.class);

                        idview.setText(mediprice);

                        inventry2();


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }
    public void inventry2(){
        DatabaseReference mfg=mfirebase.child("Medicines");
        DatabaseReference medr=mfg.child(med22);
        medr.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                medi2price=dataSnapshot.child("Price").getValue(String.class);
                medi2q=dataSnapshot.child("Quantity").getValue(String.class);

                idview2.setText(medi2price);
                idview3.setText(med11);
                idview4.setText(med22);
                idview5.setText("PRICE OF MEDICINES");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
