package com.example.yaz_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.yaz_1_1.model.DbHelper;
import com.example.yaz_1_1.model.User;

public class ActivityRegister extends AppCompatActivity {

    EditText etName, etPassword, etEmail, etPasswordReenter;
    CheckBox cb8hours, cb24hours;
    RadioGroup rb;
    Spinner spinnerCountry;
    Button btnRegister, btnClear, btnBack;
    TextView tvRegisterMsg;
    DbHelper dbHelper;

    String country=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbHelper = new DbHelper();

        tvRegisterMsg = findViewById(R.id.tvRegisterMessage);

        tvRegisterMsg.setVisibility(View.GONE);
        tvRegisterMsg.setText("");

        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPasswordRegister);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPasswordReenter = (EditText) findViewById(R.id.etPasswordReenter);

        cb8hours = (CheckBox) findViewById(R.id.cb8hours);
        cb24hours = (CheckBox) findViewById(R.id.checkBox2);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ActivityRegister.this, MainActivity.class);
                startActivity(intent);
            }
        });
        tvRegisterMsg = findViewById(R.id.tvRegisterMessage);

        rb =  (RadioGroup) findViewById(R.id.radiogroupGender);

        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long rowId) {

                 country =  adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String email =  etEmail.getText().toString().trim();
                String passwordreenter = etPasswordReenter.getText().toString().trim();

                String cbMessage = "";
                if (cb8hours.isChecked()) {
                    cbMessage = cb8hours.getText().toString();
                }
                if (cb24hours.isChecked()){
                    if (cbMessage.equals(""))
                        cbMessage = cb24hours.getText().toString();
                    else
                        cbMessage = "," + cb24hours.getText().toString();
                }

                String gender="";

                if (rb.getCheckedRadioButtonId()==R.id.rbMale)
                {
                    gender = "Male";
                }
                else    {
                    gender = "Female";
                }
                //valudation

                if (name.isEmpty())
                {
                    tvRegisterMsg.setText("Please enter your name");
                    tvRegisterMsg.setTextColor(Color.RED);
                    etName.requestFocus();
                    tvRegisterMsg.setVisibility(View.VISIBLE);
                    return;

                }
                if (email.isEmpty())
                {
                    tvRegisterMsg.setText("Enter email");
                    tvRegisterMsg.setTextColor(Color.RED);
                    etEmail.requestFocus();
                    tvRegisterMsg.setVisibility(View.VISIBLE);
                    return;

                }
                if (password.isEmpty())
                {
                    tvRegisterMsg.setText("Enter password");
                    tvRegisterMsg.setTextColor(Color.RED);
                    etPassword.requestFocus();
                    tvRegisterMsg.setVisibility(View.VISIBLE);
                    return;

                }

                if (passwordreenter.isEmpty())
                {
                    tvRegisterMsg.setText("Enter re-enter password");
                    tvRegisterMsg.setTextColor(Color.RED);
                    etPasswordReenter.requestFocus();
                    tvRegisterMsg.setVisibility(View.VISIBLE);
                    return;

                }

                if (!passwordreenter.equals(password))
                {
                    tvRegisterMsg.setText("Password and re-enter password are not same");
                    tvRegisterMsg.setTextColor(Color.RED);
                    etPasswordReenter.requestFocus();
                    tvRegisterMsg.setVisibility(View.VISIBLE);
                    return;

                }

                // activityf or you
                //1. Password ve reenter password ayni?
                //2 For apssword check: At least one Upper case, Numeric , minimum length 8
                // 3 watch youtube video for Calculator in Android, good design
                // 4 Background color change using radio buttons


                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setGender(gender);
                user.setCountry(country);

                if(dbHelper.AddUser(user))
                {
                    tvRegisterMsg.setText("User Added.");
                    tvRegisterMsg.setVisibility(View.VISIBLE);
                    tvRegisterMsg.setTextColor(Color.GREEN);
                }
            }
        });







    }
}