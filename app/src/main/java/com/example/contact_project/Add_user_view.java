package com.example.contact_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_user_view extends AppCompatActivity {
EditText name,phone;
Database my_db;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_view);
        name=findViewById(R.id.add_name);
        phone=findViewById(R.id.add_number);
        btn=findViewById(R.id.add_btn);
        my_db=new Database(getBaseContext());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my_db.InsertData(new User(name.getText().toString(),phone.getText().toString()));
                Intent i=new Intent(getBaseContext(), MainActivity.class);
startActivity(i);
            }

        });

    }
}