package com.unrgo.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.ArrayList;

public class PostListActivity extends AppCompatActivity {

    public static final String POST_ID = "post_id";


    class Post {
        public int id;
        public String title;

        public Post(int id, String title) {
            this.id = id;
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);

        ListView listView = (ListView) findViewById(R.id.post_list);
        ArrayAdapter<Post> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                getListData()
        );
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener listener = ((adapterView, view, i, l) -> {
            Post post = (Post) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(PostListActivity.this,OnePost.class);
            intent.putExtra(PostListActivity.POST_ID,post.id);
            startActivity(intent);
        });

        listView.setOnItemClickListener(listener);



    }



    private ArrayList<Post> getListData (){
        ArrayList<Post> postArrayList = new ArrayList<>();
        String result = new HttpDataGetter("https://jsonplaceholder.typicode.com/posts").getData();
        try {
            JSONObject resJson = new JSONObject(result);
            for (int i = 0; i< resJson.length();i++){
                JSONObject obj  = resJson.getJSONObject(String.valueOf(i));
                postArrayList.add(
                        new Post(
                                obj.getInt("id"),
                                obj.getString("title")
                        )
                );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return postArrayList;
    }


}