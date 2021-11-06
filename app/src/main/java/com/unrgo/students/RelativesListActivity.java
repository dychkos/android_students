package com.unrgo.students;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RelativesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatives_list);

        ArrayAdapter<PersonRelatives> personRelativesArrayAdapter = new ArrayAdapter<PersonRelatives>(
                this,
                android.R.layout.simple_list_item_1,
                getDataFromDB()
        );

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int relativeId = ((PersonRelatives) adapterView.getItemAtPosition(i)).getId();
                Intent intent = new Intent(RelativesListActivity.this, PersonRelativesActivity.class);
                intent.putExtra("relativeId",relativeId);

                startActivity(intent);
            }
        };
        ListView listView = findViewById(R.id.relative_list_view);
        listView.setAdapter(personRelativesArrayAdapter);
        listView.setOnItemClickListener(listener);

        getDataFromDB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.relative_menu,menu);

//        MenuItem menuItem = menu.findItem(R.id.action_1share);
//        ShareActionProvider shareActionProvider =
//                (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"test message");
        //shareActionProvider.setShareIntent(intent);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_create) {
            startActivity(new Intent(this, AddPersonRelativesActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void AddRelativeClick(View view){
        Intent intent = new Intent(RelativesListActivity.this, AddPersonRelativesActivity.class);
        startActivity(intent);
    }

    private ArrayList<PersonRelatives> getDataFromDB(){
        ArrayList<PersonRelatives> relatives = new ArrayList<PersonRelatives>();
        SQLiteOpenHelper sqLiteOpenHelper = new PersonDataBaseHelper(this);

        try {
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
            Cursor cursor = db.query("relatives",
                    new String[] {"full_name","age","type","live_together","id"},
                    null,null,null,null,null
            );
            while (cursor.moveToNext()){
                relatives.add(
                        new PersonRelatives(
                                cursor.getString(0),
                                cursor.getString(1),
                                cursor.getInt(2),
                                (cursor.getInt(3)>0),
                                cursor.getInt(4)
                                )
                );
            }
        }catch (SQLException e){
            Toast toast = Toast.makeText(this,"Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }

        return relatives;

    }
}