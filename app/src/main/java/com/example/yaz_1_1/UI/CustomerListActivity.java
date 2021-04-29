package com.example.yaz_1_1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.yaz_1_1.R;
import com.example.yaz_1_1.model.Customer;
import com.example.yaz_1_1.model.CustomerDbHelper;
import com.example.yaz_1_1.model.CustomerListViewAdapter;

import java.util.ArrayList;

public class CustomerListActivity extends AppCompatActivity {

    Button btnAdd;
    ListView lvCustomers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        btnAdd= findViewById(R.id.btnCustomerAddActivity);
        lvCustomers = findViewById(R.id.lvCustomers);


        CustomerDbHelper dbHelper = new CustomerDbHelper(this);
        ArrayList<Customer> list = dbHelper.GetCustomers();
        CustomerListViewAdapter adapter = new CustomerListViewAdapter(this,R.layout.customer_list_layout,list);
        lvCustomers.setAdapter(adapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerListActivity.this,CustomerAddActivity.class);
                startActivity(intent);
            }
        });
    }
}