package com.unrgo.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class OnePost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_post);

        Intent intent = getIntent();
        int ID = intent.getIntExtra(PostListActivity.POST_ID,0);

        String res = new HttpDataGetter("https://jsonplaceholder.typicode.com/posts/"+ID).getData();

        try {
            JSONObject  obj = new JSONObject(res);

            EditText postId = findViewById(R.id.editPostId);
            postId.setText(obj.getString("id"));

            EditText postTitle = findViewById(R.id.editPostTitle);
            postTitle.setText(obj.getString("title"));

            EditText postBody = findViewById(R.id.editPostBody);
            postBody.setText(obj.getString("body"));

            EditText author = findViewById(R.id.edit_author);
            String resUser = new HttpDataGetter("https://jsonplaceholder.typicode.com/user/" + author).getData();
            JSONObject jsonObject = new JSONObject(resUser);
            author.setText(obj.getString("name"));


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}