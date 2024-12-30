package com.example.my_coffe1;

import android.os.Parcel;
import android.os.Parcelable;

public class CartItem implements Parcelable {
    private int imageResId;
    private String name;
    private String description;
    private String price;
    private int quantity;

    public CartItem(int imageResId, String name, String description, String price, int quantity) {
        this.imageResId = imageResId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    protected CartItem(Parcel in) {
        imageResId = in.readInt();
        name = in.readString();
        description = in.readString();
        price = in.readString();
        quantity = in.readInt();
    }

    public static final Creator<CartItem> CREATOR = new Creator<CartItem>() {
        @Override
        public CartItem createFromParcel(Parcel in) {
            return new CartItem(in);
        }

        @Override
        public CartItem[] newArray(int size) {
            return new CartItem[size];
        }
    };

    // Getters
    public int getImageResId() { return imageResId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResId);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(price);
        dest.writeInt(quantity);
    }
}
