package com.example.mealmate_demo.Model;

import android.net.Uri;

import androidx.annotation.NonNull;

public class Grocery {
    private String id;
    private String name;
    private String description;
    private double price;
    private boolean purchase;
    private Uri image;

    public Grocery(String id, String name, String description, double price, boolean purchase, Uri image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.purchase = purchase;
        this.image=image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPurchase() {
        return purchase;
    }

    public void setPurchase(boolean purchase) {
        this.purchase = purchase;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    @NonNull
    @Override
    public String toString() {
        return "Grocery{"+
                "id="+ id +
                " , name'"+ name +'\''+
                " , description'"+ description +'\''+
                " , price="+ price +
                " , purchase="+ purchase +
                " , image="+ image +
                '}';
    }
}
