package com.unrgo.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        Intent intent = getIntent();
        String groupNumber = intent.getStringExtra("groupNumber");

        StringBuilder txtStudents = new StringBuilder();
        for(Student student : Student.getStudents(groupNumber)){
           txtStudents.append(student.getName()).append("\n");
        }

        TextView textView  = (TextView) findViewById(R.id.text);
        textView.setText(txtStudents.toString());
    }

    public void onBtnSendClick(View view){
        TextView textView  = (TextView) findViewById(R.id.text);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TITLE,"Список студентів");
        intent.putExtra(Intent.EXTRA_TEXT,textView.getText());
        startActivity(intent);
    }


}