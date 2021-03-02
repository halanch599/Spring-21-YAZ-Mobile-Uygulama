package com.example.yaz_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etuserName;
    EditText etpassword;
    TextView tvMessage;
    Button btnRegister;

    public static final String DATA = "USER_NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etuserName = (EditText) findViewById(R.id.etUserName);
        etpassword = (EditText) findViewById(R.id.etPassword);
        tvMessage = (TextView) findViewById(R.id.tvMessage);


        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, ActivityRegister.class);
                startActivity(intent);
            }
        });
    }

    public void Login(View view)
    {


         tvMessage.setText("");
         tvMessage.setTextColor(Color.BLACK);
        tvMessage.setVisibility(View.GONE);

        String username = etuserName.getText().toString().trim();
        String password = etpassword.getText().toString().trim();



        if (username.equals("")){
            tvMessage.setText("Please enter user name");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.RED);
            etuserName.requestFocus();

            return;
        }

        if (password.equals("")){
            tvMessage.setText("Please enter password");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.RED);
            etpassword.requestFocus();
            return;
        }


        if(username.equals("admin") && password.equals("12345"))
        {
//            tvMessage.setText("Welcome, " + username);
//            tvMessage.setTextColor(Color.GREEN);

            Intent intent = new Intent(this,ActivityHome.class);
            intent.putExtra(DATA,username);
            startActivity((intent));
        }
        else{
            tvMessage.setText("Invalid username or password.");
            tvMessage.setTextColor(Color.RED);

        }
        tvMessage.setVisibility(View.VISIBLE);



    }
}