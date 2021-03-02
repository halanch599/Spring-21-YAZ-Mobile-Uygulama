package com.example.yaz_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityHome extends AppCompatActivity {

    TextView tvWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

      Intent intent =  getIntent();
      String msg = intent.getStringExtra(MainActivity.DATA);

      if (msg!=null)
      {
          tvWelcome = (TextView) findViewById(R.id.tvHomeWelcome);
          tvWelcome.setText("Welcome, " + msg);
      }
    }
}