package com.example.yaz_1_1.model;

public class Product {
    int ProductID;
    String Name;
    float Price;
    int Image;
    int Quantity;

    public Product(String name, float price, int image) {
        Name = name;
        Price = price;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
