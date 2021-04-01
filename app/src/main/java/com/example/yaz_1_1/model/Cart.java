package com.example.yaz_1_1.model;

import java.util.ArrayList;

public class Cart {
    private static  ArrayList<Product> shoppingCart = new ArrayList<>();

    public static void AddItems(Product p){
        shoppingCart.add(p);
    }

    public static void DeleteItems(int id){
        // write code to delete
    }

    public static ArrayList<Product> GetAllItesm()
    {
        return shoppingCart;
    }

}
