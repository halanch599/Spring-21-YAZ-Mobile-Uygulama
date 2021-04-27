package com.example.yaz_1_1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yaz_1_1.R;

public class CustomerListActivity extends AppCompatActivity {

    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        btnAdd= findViewById(R.id.btnCustomerAddActivity);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerListActivity.this,CustomerAddActivity.class);
                startActivity(intent);
            }
        });
    }
}