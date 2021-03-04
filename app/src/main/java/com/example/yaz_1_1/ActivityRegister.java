package com.example.yaz_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class ActivityRegister extends AppCompatActivity {

    EditText etName, etPassword, etEmail, etPasswordReenter;
    CheckBox cb8hours, cb24hours;
    RadioGroup rb;
    Spinner spinnerCountry;
    Button btnRegister, btnClear, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPasswordReenter = (EditText) findViewById(R.id.etPasswordReenter);

        cb8hours = (CheckBox) findViewById(R.id.cb8hours);
        cb24hours = (CheckBox) findViewById(R.id.checkBox2);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnBack = (Button) findViewById(R.id.btnBack);

        rb =  (RadioGroup) findViewById(R.id.radiogroupGender);

        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);


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

        // activityf or you
        //1. Password ve reenter password ayni?
        //2 For apssword check: At least one Upper case, Numeric , minimum length 8
        // 3 watch youtube video for Calculator in Android, good design


    }
}