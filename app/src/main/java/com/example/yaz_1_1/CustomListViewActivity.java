package com.example.yaz_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.lang.UProperty;
import android.os.Bundle;
import android.widget.ListView;

import com.example.yaz_1_1.model.CustomeListViewProductAdapter;
import com.example.yaz_1_1.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {

    List<Product> productList;
    ListView lvProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        lvProduct = findViewById(R.id.lvProduct);
        productList = new ArrayList<>();

        productList.add(new Product("Laptop",3500,R.drawable.laptop_100px));
        productList.add(new Product("Mobile",3500,R.drawable.mobile_phone_100px));
        productList.add(new Product("Smart Watch",3500,R.drawable.smart_watch_100px));
        productList.add(new Product("HD TV",3500,R.drawable.hdtv_100px));
        productList.add(new Product("Apple",3500,R.drawable.apple_100px));

        CustomeListViewProductAdapter adapter = new CustomeListViewProductAdapter(this,R.layout.listview_product,productList);
        lvProduct.setAdapter(adapter);

    }
}