package com.example.yaz_1_1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.yaz_1_1.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CustomerListViewAdapter extends ArrayAdapter<Customer> {
    ArrayList<Customer> customers;
    Context context;
    int resource;

    public CustomerListViewAdapter(@NonNull Context context, int resource, ArrayList<Customer> list) {
        super(context, resource, list);
        this.customers = list;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(resource,parent,false);


        TextView tvCustomerName = (TextView) view.findViewById(R.id.tvCustomerName);
        TextView tvCustomerID = (TextView) view.findViewById(R.id.tvCustomerId);
        TextView tvCustomerAddress = (TextView) view.findViewById(R.id.tvCustomerAddress);

        Customer c = customers.get(position);

        tvCustomerName.setText(c.getFirstName()+ " " + c.getLastName());
        tvCustomerID.setText(String.valueOf(c.getCustomerID()));
        tvCustomerAddress.setText(c.getAddress());

        return view;
    }
}
