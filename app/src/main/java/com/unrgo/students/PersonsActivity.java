package com.unrgo.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class PersonsActivity extends AppCompatActivity {

    public static final String RELATIVE = "relative_id";
    private Cursor cursor;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatives);

        Intent intent = getIntent();
        int relative_id = intent.getIntExtra(RELATIVE,0);

        ListView listView = (ListView) findViewById(R.id.relative_list_view);
        SimpleCursorAdapter adapter = getDataFromDB(relative_id);

        if(adapter!=null){
            listView.setAdapter(adapter);
        }
    }

    private SimpleCursorAdapter getDataFromDB(int relative_id){
        SimpleCursorAdapter listAdapter = null;

        SQLiteOpenHelper sqLiteOpenHelper = new PersonDataBaseHelper(this);
        try {
            db = sqLiteOpenHelper.getReadableDatabase();
            cursor = db.rawQuery("select 'full_name' ,'age'",new String[]{Integer.toString(relative_id)});
            listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
                    cursor,new String[]{"name"},
                    new int[]{android.R.id.text1},0);

        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this,"Database unaviable",Toast.LENGTH_SHORT);
            toast.show();

        }
        return  listAdapter;
    }
}