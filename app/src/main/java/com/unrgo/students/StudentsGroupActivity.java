package com.unrgo.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class StudentsGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_group2);
        Intent intent = getIntent();
        String grpNumber = intent.getStringExtra("groupNumber");
        StudentsGroup group = StudentsGroup.getGroup(grpNumber);

        EditText txtGroupNumber =(EditText) findViewById(R.id.editTextGrpNum);
        TextView txtGroupNumberView =(TextView) findViewById(R.id.textGrpNum);
        assert group != null;
        txtGroupNumber.setText(group.getNumber());
        txtGroupNumberView.setText(group.getNumber());
        EditText txtFacultyText =(EditText) findViewById(R.id.editTextFacultyText);
        TextView txtFacultyTextView =(TextView) findViewById(R.id.textFacultyName);
        txtFacultyText.setText(group.getFacultyName());
        txtFacultyTextView.setText(group.getFacultyName());

        if(group.getEducationLevel() == 0 ){
            ((RadioButton)findViewById(R.id.radioBac)).setChecked(true);
        }else{
            ((RadioButton)findViewById(R.id.radioMag)).setChecked(true);
        }

        ((CheckBox)findViewById(R.id.contract)).setChecked(
                group.isContractExistsFlag()
        );

        ((CheckBox)findViewById(R.id.pilg)).setChecked(
                group.isPrivilageExistsFlag()
        );
    }

    public void onOkBtnClick(View view){
        String outString = "Група" + ((TextView)findViewById(R.id.editTextGrpNum)).getText() +'\n';
        outString += "Факультет" + ((TextView)findViewById(R.id.editTextFacultyText)).getText() +'\n';

        if(((RadioButton)findViewById(R.id.radioBac)).isChecked() ){
            outString+="рівень освіти - " + "бакалавр\n";
        }else{
            outString+="рівень освіти - " + "магістр\n";

        }

        if(((CheckBox)findViewById(R.id.contract)).isChecked() ){
            outString+="є контрактники\n";
        }else{
            outString+="контрактників нема\n";

        }

        if(((CheckBox)findViewById(R.id.pilg)).isChecked() ){
            outString+="є пільговики\n";
        }else{
            outString+="пільговиків нема\n";

        }

        Toast.makeText(this,outString,Toast.LENGTH_LONG).show();
    }
}