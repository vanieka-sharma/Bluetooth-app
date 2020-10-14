package com.example.bluetoothapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int request = 0;
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(bluetoothAdapter == null){
            Toast.makeText(getApplicationContext(), "Bluetooth not supported", Toast.LENGTH_SHORT);


        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bluetoothAdapter.isEnabled()){
                    Intent benable = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(benable, request);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothAdapter.disable();
            }
        });
    }
}
