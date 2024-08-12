package com.example.contact_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Database my_db;
    private ArrayList<User> users_list;
    private ListView ls;
    private FloatingActionButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        my_db = new Database(this);

        setContentView(R.layout.activity_main);



        btn = findViewById(R.id.floatingActionButton_id);
        ls = findViewById(R.id.list_view);

        users_list = my_db.GetAllData();
        Custom_Adapter myCustomAdapter = new Custom_Adapter(this, users_list, R.layout.contact_item);
        ls.setAdapter(myCustomAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Add_user_view.class);
                startActivity(i);
            }
        });
    }
}
