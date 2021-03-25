package com.example.yaz_1_1.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.yaz_1_1.R;

import java.util.List;

public class CustomeListViewProductAdapter extends ArrayAdapter<Product> {
    List<Product> productList;
    Context context;
    int resource;

    public CustomeListViewProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> list) {
        super(context, resource, list);

        this.productList =list;
        this.context = context;
        this.resource =resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(resource,parent,false);

        ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage);
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvPrice = (TextView) view.findViewById(R.id.tvPrice);
        Button btnAdd = (Button)view.findViewById(R.id.btnAdd);

        Product product =  productList.get(position);
        ivImage.setImageDrawable(context.getResources().getDrawable(product.getImage()));
        tvName.setText(product.getName());
        tvPrice.setText(String.valueOf(product.getPrice()));


        // button click event
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Hello from Add Button", Toast.LENGTH_SHORT).show();

                // alert dialog

                AlertDialog.Builder builder =  new AlertDialog.Builder(context);
                builder.setTitle("Are you sure?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "You clicked YES", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "Oh NOOOOOOO", Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        return view;
    }
}
