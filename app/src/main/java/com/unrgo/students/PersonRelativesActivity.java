package com.unrgo.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PersonRelativesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_relatives);
        Intent intent = getIntent();
        int relativeId = intent.getIntExtra("relativeId",1);

        SQLiteOpenHelper sqLiteOpenHelper = new PersonDataBaseHelper(this);
        try {
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
            Cursor cursor = db.query("relatives",
                    new String[] {"full_name","age","type","live_together","id"},
                    "id=?",new String[] {Integer.toString(relativeId)},
                    null,null,null
                    );
            if(cursor.moveToFirst()){
                PersonRelatives relative = new PersonRelatives(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        (cursor.getInt(3)>0),
                        cursor.getInt(4)
                );

                EditText txtRelativeFullName =(EditText) findViewById(R.id.editRelativeFullName);
                TextView txtRelativeFullNameView =(TextView) findViewById(R.id.textRelative);
                txtRelativeFullName.setText(relative.getFullName());
                txtRelativeFullNameView.setText(relative.getFullName());
                EditText txtRelativeType =(EditText) findViewById(R.id.editRelativeType);
                txtRelativeType.setText(relative.getTypeRelative());

                if(relative.isLiveTogether()){
                    ((RadioButton)findViewById(R.id.radioYesTogether)).setChecked(true);
                }else{
                    ((RadioButton)findViewById(R.id.radioNoTogether)).setChecked(true);
                }
            }else{
                Toast toast = Toast.makeText(this,"Cant find relative with id" + Integer.toString(relativeId),Toast.LENGTH_SHORT);
                toast.show();
                cursor.close();
                db.close();
            }
        }catch (SQLException e){
            Toast toast = Toast.makeText(this,"Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void onOkBtnClick(View view){
        String outString = "Вік: " + ((TextView)findViewById(R.id.editRelativeType)).getText() +'\n';
        outString += "ПІБ: " + ((TextView)findViewById(R.id.editRelativeFullName)).getText() +'\n';

        if(((RadioButton)findViewById(R.id.radioYesTogether)).isChecked() ){
            outString+="проживає разом - " + "так\n";
        }else{
            outString+="проживає разом - " + "ні\n";

        }

        Toast.makeText(this,outString,Toast.LENGTH_LONG).show();
    }
}