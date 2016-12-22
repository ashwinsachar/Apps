package com.example.ashwinachar.eggtimer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView timerTextView;
    SeekBar timerSeekBar;
    Boolean counterisActive = false;
    Button controllerButton;
    CountDownTimer countDownTimer;

    public void resetTimer(){
        timerTextView.setText("00:00");
        timerSeekBar.setProgress(0);
        countDownTimer.cancel();
        controllerButton.setText("GO");
        timerSeekBar.setEnabled(true);
        counterisActive = false;
    }

    public void updateTimer(int secLeft){
        int min = (int) secLeft / 60;
        int sec = secLeft - min * 60;

        String minString = Integer.toString(min);

        String secString = Integer.toString(sec);

        if(min <= 9){
            minString = "0" + minString;
        }

        if(sec <= 9){
            secString = "0" + secString;
        }



        timerTextView.setText(minString + ":" + secString);
    }

    public void controlTimer(View view){

        if(counterisActive == false) {

            counterisActive = true;
            timerSeekBar.setEnabled(false);

            controllerButton.setText("STOP");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {


                @Override
                public void onTick(long l) {

                    updateTimer((int) l / 1000);

                }

                @Override
                public void onFinish() {
                    resetTimer();
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mediaPlayer.start();

                }
            }.start();

        }
        else {

            resetTimer();
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        controllerButton = (Button)findViewById(R.id.controllerButton);

        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(0);


            timerSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                    updateTimer(progress);

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        }

}
