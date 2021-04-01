package com.example.yaz_1_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.yaz_1_1.model.ProdcutAdapterRecyler;
import com.example.yaz_1_1.model.Product;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView rvProductList;
    RecyclerView.Adapter productAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        rvProductList = findViewById(R.id.rvProductList);

        //
        // prducts
        products = new ArrayList<>();
        products.add(new Product("Apple Rize",1.50f,R.drawable.apple_100px));
        products.add(new Product("HD Samsung TV ",1500,R.drawable.hdtv_100px));
        products.add(new Product("HP Laptop",3500,R.drawable.laptop_100px));
        products.add(new Product("LG Mobile",2500,R.drawable.mobile_phone_100px));
        products.add(new Product("Smart Watch",560,R.drawable.smart_watch_100px));


        productAdapter = new ProdcutAdapterRecyler(this,products);
        layoutManager = new LinearLayoutManager(this);

        rvProductList.setAdapter(productAdapter);
        rvProductList.setLayoutManager(layoutManager);
    }
}