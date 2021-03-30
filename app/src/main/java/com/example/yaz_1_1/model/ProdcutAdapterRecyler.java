package com.example.yaz_1_1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yaz_1_1.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProdcutAdapterRecyler extends RecyclerView.Adapter<ProdcutAdapterRecyler.ViewHolder> {

    private ArrayList<Product> prodcutList;
    private Context context;

    public ProdcutAdapterRecyler(Context context, ArrayList<Product> list) {
        this.prodcutList = list;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivImage;
        TextView tvName, tvPrice;
        Button btnProductAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

          ivImage =   itemView.findViewById(R.id.ivImage);
          tvName = itemView.findViewById(R.id.tvProductName);
          tvPrice = itemView.findViewById(R.id.tvProductPrice);
          btnProductAdd =  itemView.findViewById(R.id.btnProductAdd);
        }
    }


    @NonNull
    @Override
    public ProdcutAdapterRecyler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_product,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdcutAdapterRecyler.ViewHolder holder, int position) {

        Product p = prodcutList.get(position);
        holder.tvName.setText(p.getName());
        holder.tvPrice.setText(String.valueOf(p.getPrice()));
        holder.ivImage.setImageDrawable(context.getResources().getDrawable(p.getImage()));
    }

    @Override
    public int getItemCount() {
        return prodcutList.size();
    }
}
