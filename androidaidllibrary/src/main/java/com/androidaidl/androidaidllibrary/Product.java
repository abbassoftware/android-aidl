package com.androidaidl.androidaidllibrary;

/**
 * Created by abbas on 27/9/15.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private String name;


    private int quantity;
    private float cost;

    public Product(String name, int quantity, float cost) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    private Product(Parcel in) {
        name = in.readString();
        quantity = in.readInt();
        cost = in.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeInt(quantity);
        out.writeFloat(cost);
    }

    public static final Parcelable.Creator<Product> CREATOR
            = new Parcelable.Creator<Product>() {
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };


    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}
