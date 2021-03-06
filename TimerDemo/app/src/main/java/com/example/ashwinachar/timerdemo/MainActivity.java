package com.example.ashwinachar.timerdemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000){
            @Override
            public void onTick(long millisecondsUntilDone) {

                 //Countdown is counting down (Every second)
                Log.i("Seconds left", String.valueOf(millisecondsUntilDone/1000));

            }

            @Override
            public void onFinish() {

                //Counter is finished (After 10 seconds)
                Log.i("Counter is done","Countdown timer finished");

            }
        }.start();
/*
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {

                //Insert code to run every second

                Log.i("Runnable has run", "a second must have passed");

                handler.postDelayed(this, 1000);

            }
        };

        handler.post(run);
*/
    }


}
