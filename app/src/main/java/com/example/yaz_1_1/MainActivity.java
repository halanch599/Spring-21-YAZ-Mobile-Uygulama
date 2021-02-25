package com.example.yaz_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login(View view)
    {

        EditText etuserName = (EditText) findViewById(R.id.etUserName);
        EditText etpassword = (EditText) findViewById(R.id.etPassword);

        String username = etuserName.getText().toString().trim();
        String password = etpassword.getText().toString().trim();

        if (username.equals("")){

        }

    }
}