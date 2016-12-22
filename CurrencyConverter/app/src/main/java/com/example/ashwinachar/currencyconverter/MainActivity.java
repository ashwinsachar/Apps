package com.example.ashwinachar.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void convert(View view) {


        EditText usd =  (EditText) findViewById(R.id.usd);
        Log.i("DollarField", usd.getText().toString());
        Double usdollar = Double.parseDouble(usd.getText().toString());
        Double inr = usdollar * 65.0;
        Log.i("Converted dollar to inr", inr.toString());
        Toast.makeText(getApplicationContext(), "₹" + inr.toString() ,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
