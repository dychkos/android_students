package com.unrgo.students;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PersonDataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "persons";
    private static final int DB_VERSION = 1;



    public PersonDataBaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "CREATE TABLE Relatives (\n" +
                "id             INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "full_name      TEXT (25) NOT NULL, \n" +
                "age            INT  NOT NULL ,\n " +
                "type           VARCHAR(10) , \n" +
                "live_together  BOOLEAN );";

        sqLiteDatabase.execSQL(sqlQuery);
        populateDB(sqLiteDatabase);
    }

    private void populateDB(SQLiteDatabase db){
        for (PersonRelatives relative : PersonRelatives.getRelatives()){
            insertRow(db,relative);
        }
    }

    private void insertRow(SQLiteDatabase db, PersonRelatives relative){
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name",relative.getFullName());
        contentValues.put("age",relative.getAge());
        contentValues.put("type",relative.getTypeRelative());
        contentValues.put("live_together",relative.isLiveTogether());
        db.insert("Relatives",null,contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
