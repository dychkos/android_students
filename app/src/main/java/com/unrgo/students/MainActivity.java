package com.unrgo.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View view){
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        String grpNum = (String) spinner.getSelectedItem();
        Intent intent = new Intent(this,StudentsActivity.class);
        intent.putExtra("groupNumber",grpNum);
        startActivity(intent);

    }
}