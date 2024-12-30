package com.example.my_coffe1;

public class RecommendedItem {
    private int imageResId;
    private String name;
    private String price;
    private String description; // Nouveau champ pour la description

    // Constructeur mis à jour pour inclure la description
    public RecommendedItem(int imageResId, String name, String description, String price) {
        this.imageResId = imageResId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters pour accéder aux champs
    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() { // Nouveau getter pour la description
        return description;
    }
}
