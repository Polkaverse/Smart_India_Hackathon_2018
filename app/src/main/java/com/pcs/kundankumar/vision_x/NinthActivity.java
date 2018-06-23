package com.pcs.kundankumar.vision_x;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class NinthActivity extends AppCompatActivity {
    Timer timer;
    public int z=1;
    public TextView tct;
    private final String DEVICE_ADDRESS = "98:D3:32:11:10:F1"; //MAC Address of Bluetooth Module     98:D3:32:11:10:F1
    private final UUID PORT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    //private DatabaseReference mDatabase;

    private BluetoothDevice device;
    private BluetoothSocket socket;
    private OutputStream outputStream;

    private Button btnb , bluetooth_connect_btn;;
    String command1, command2 , command3 , command4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth);
        bluetoothconet();

        tct=(TextView) findViewById(R.id.textView20) ;
        btnb = (Button) findViewById(R.id.button10);
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(z==1) {
                    command1 = "a";
                    command2 = "c";

                    try {
                        tct.setText("Processing... please wait");

                        outputStream.write(command1.getBytes());


                        outputStream.write(command2.getBytes());
                        

                        z=z+1;

                        timer=new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Intent intent=new Intent(NinthActivity.this,TenthActivity.class);
                                startActivity(intent);

                                finish();
                            }
                        },2000);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                {}
            }
        });
    }

    private void bluetoothconet() {
        if (BTinit()) {
            BTconnect();
        }
    }

    public boolean BTinit()
    {
        boolean found = false;

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(bluetoothAdapter == null) //Checks if the device supports bluetooth
        {
            Toast.makeText(getApplicationContext(), "Device doesn't support bluetooth", Toast.LENGTH_SHORT).show();
        }

        if(!bluetoothAdapter.isEnabled()) //Checks if bluetooth is enabled. If not, the program will ask permission from the user to enable it
        {
            Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableAdapter,0);

            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();

        if(bondedDevices.isEmpty()) //Checks for paired bluetooth devices
        {
            Toast.makeText(getApplicationContext(), "Please pair the device first", Toast.LENGTH_SHORT).show();
        }
        else
        {
            for(BluetoothDevice iterator : bondedDevices)
            {
                if(iterator.getAddress().equals(DEVICE_ADDRESS))
                {
                    device = iterator;
                    found = true;
                    break;
                }
            }
        }

        return found;
    }

    public boolean BTconnect()
    {
        boolean connected = true;

        try
        {
            socket = device.createRfcommSocketToServiceRecord(PORT_UUID); //Creates a socket to handle the outgoing connection
            socket.connect();

            Toast.makeText(getApplicationContext(),
                    "Connection to bluetooth device successful", Toast.LENGTH_LONG).show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            connected = false;
        }

        if(connected)
        {
            try
            {
                outputStream = socket.getOutputStream(); //gets the output stream of the socket
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        return connected;
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }


}
