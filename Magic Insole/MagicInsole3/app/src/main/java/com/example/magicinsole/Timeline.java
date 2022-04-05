package com.example.magicinsole;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AnisSarah on Sept2021.
 */


public class Timeline extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private TextView count;
    private TextView weights;
    private TextView heights;
    boolean activityRunning;
    private long timeWhenStopped = 0;
    private boolean stopClicked;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);

        count = (TextView) findViewById(R.id.count);
        weights = (TextView) findViewById(R.id.weight);
        heights = (TextView) findViewById(R.id.height);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        chronometer = (Chronometer) findViewById(R.id.chronometer);

    }

    public void setContentView(int timeline) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null){
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        }
        else{
            Toast.makeText(this, "Count sensor not available", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        activityRunning = false;
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (activityRunning){
            count.setText(String.valueOf(sensorEvent.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    // the method for when we press the 'reset' button
    @SuppressLint("SetTextI18n")
    public void resetButtonClick(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        timeWhenStopped = 0;
        TextView secondsText = (TextView) findViewById(R.id.hmsTekst);
        secondsText.setText("0 seconds");
        TextView secondsText1 = (TextView) findViewById(R.id.count);
        secondsText1.setText("0 steps");

    }

    // the method for when we press the 'start' button
    public void startButtonClick(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chronometer.start();
        stopClicked = false;

    }

    // the method for when we press the 'stop' button
    @SuppressLint("SetTextI18n")
    public void stopButtonClick(View v){
        if (!stopClicked)  {
            TextView secondsText = (TextView) findViewById(R.id.hmsTekst);
            timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
            int seconds = (int) timeWhenStopped / 1000;
            secondsText.setText( Math.abs(seconds) + " seconds");
            chronometer.stop();
            TextView Results = (TextView) findViewById(R.id.result);
            int weight = Integer.parseInt(weights.getText().toString());
            int height = Integer.parseInt(heights.getText().toString());
            //(0.57*(weight*2.2))/(160934.4/(height*0.415))//
            Results.setText( Math.abs((0.57*(weight*2.2))/(160934.4/(height*0.415)))*10 + "kcal"); //show result
            stopClicked = true;
        }
    }
}
