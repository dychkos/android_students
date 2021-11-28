package com.unrgo.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onBtnClick(View view){
        Intent intent = new Intent(this, RelativesListActivity.class);
        startActivity(intent);

    }

    public void showJsonData(View view){
        Intent intent = new Intent(this, PostListActivity.class);
        startActivity(intent);

    }




}