package com.unrgo.students;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int seconds;
    private Boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("timer");
        }
        runTimer();
    }

    @Override
    protected void onStart() {
        super.onStart();
        isRunning = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("timer",seconds);
    }

    public void onBtnClick(View view){
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        String grpNum = (String) spinner.getSelectedItem();
        Intent intent = new Intent(this,StudentsActivity.class);
        intent.putExtra("groupNumber",grpNum);
        startActivity(intent);

    }

    public void buttonGrpClick(View view){
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        String grpNum = (String) spinner.getSelectedItem();

        Intent intent = new Intent(this,StudentsGroupActivity.class);
        intent.putExtra("groupNumber",grpNum);

        startActivity(intent);

    }

    private void runTimer(){
        final TextView timeView = (TextView)findViewById(R.id.timer);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int sesc = seconds%60;
                String time = String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,sesc);
                timeView.setText(time);
                if(isRunning){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}