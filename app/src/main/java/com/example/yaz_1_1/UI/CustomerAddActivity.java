package com.example.yaz_1_1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yaz_1_1.R;
import com.example.yaz_1_1.model.CustomerDbHelper;

public class CustomerAddActivity extends AppCompatActivity {

    TextView tvMessage;
    EditText etFirstName,etLastName,etAddress;
    Button btnAdd, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add);

        tvMessage = findViewById(R.id.tvCustomerMessage);
        etFirstName =  findViewById(R.id.etCustomerFirstName);
        etLastName = findViewById(R.id.etCustoemrLastName);
        etAddress = findViewById(R.id.etCustomerAddress);

        btnAdd =  findViewById(R.id.btnCustomerAdd);
        btnBack =  findViewById(R.id.btnCustomerBack);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname =  etFirstName.getText().toString().trim();
                String lname = etLastName.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                CustomerDbHelper dbHelper= new CustomerDbHelper(CustomerAddActivity.this);
                long result =  dbHelper.AddCustomer(fname,lname,address);

                if (result>0)
                {
                    tvMessage.setText("Customer Added succsully.");
                    tvMessage.setTextColor(Color.GREEN);
                    etFirstName.setText("");
                    etLastName.setText("");
                    etAddress.setText("");
                }
                else
                {
                    tvMessage.setText("Customer not added.");
                    tvMessage.setTextColor(Color.RED);
                }


            }
        });
    }
}