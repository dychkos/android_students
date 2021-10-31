package com.unrgo.students;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;

public class GroupListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        ArrayAdapter<StudentsGroup> studentsGroupArrayAdapter = new ArrayAdapter<StudentsGroup>(
                this,
                android.R.layout.simple_list_item_1,
                StudentsGroup.getGroups()
        );

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String groupNumber = ((StudentsGroup) adapterView.getItemAtPosition(i)).toString();
                Intent intent = new Intent(GroupListActivity.this,StudentsGroupActivity.class);
                intent.putExtra("groupNumber",groupNumber);

                startActivity(intent);
            }
        };
        ListView listView = findViewById(R.id.grp_list_view);
        listView.setAdapter(studentsGroupArrayAdapter);
        listView.setOnItemClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.group_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_1share);
        ShareActionProvider shareActionProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"test message");
        shareActionProvider.setShareIntent(intent);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_create) {
            startActivity(new Intent(this, AddStudentsGroupActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void AddGrpClick(View view){
        Intent intent = new Intent(GroupListActivity.this,AddStudentsGroupActivity.class);
        startActivity(intent);
    }
}