package com.unrgo.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPersonRelativesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person_relative);
    }

    public void onRelativeAdd(View view){
        EditText relativeFullName = (EditText) findViewById(R.id.addRelativeFullName);
        EditText relativeType = (EditText) findViewById(R.id.addRelativeAge);

        PersonRelatives.addRelative(new PersonRelatives(relativeFullName.getText().toString(),relativeType.getText().toString(),false));
        NavUtils.navigateUpFromSameTask(this);
    }
}