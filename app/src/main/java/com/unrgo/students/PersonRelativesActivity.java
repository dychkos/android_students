package com.unrgo.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PersonRelativesActivity extends AppCompatActivity {

    public static final String RELATIVE_ID = "relative_id";

    private PersonRelatives relative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_relatives);
        Intent intent = getIntent();
        int relativeId = intent.getIntExtra(RELATIVE_ID,1);

        relative = PersonRelatives.httpGetOneRelative(relativeId);


    }

    public void onOkBtnClick(View view){
       SQLiteOpenHelper sqLiteOpenHelper = new PersonDataBaseHelper(this);

        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name", String.valueOf(findViewById(R.id.editRelativeFullName)));
        contentValues.put("type", String.valueOf(findViewById(R.id.editRelativeType)));
        contentValues.put("live_together", String.valueOf(findViewById(R.id.edtRelativeLiveTogether)));

        Intent intent = getIntent();
        int relative_id = intent.getIntExtra(RELATIVE_ID,1);

        try {
            SQLiteDatabase db  = sqLiteOpenHelper.getReadableDatabase();
            db.update("relatives",contentValues,"id=?",new String[]{Integer.toString(relative_id)});
            db.close();
            NavUtils.navigateUpFromSameTask(this);

        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this,"Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onShowPersonsBtnClick(View view){
        Intent intent = new Intent(this,PersonsActivity.class);
        intent.putExtra("relative_id",relative.getId());
        startActivity(intent);
    }
}