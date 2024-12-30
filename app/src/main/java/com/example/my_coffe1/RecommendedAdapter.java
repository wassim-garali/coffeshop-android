package com.example.my_coffe1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {
    private List<RecommendedItem> recommendedItems;
    private static List<CartItem> cartItems = new ArrayList<>(); // Liste des articles ajoutés au panier
    private Context context;

    public RecommendedAdapter(Context context, List<RecommendedItem> items) {
        this.recommendedItems = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_recommended_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecommendedItem item = recommendedItems.get(position);

        // Définir les données de chaque élément
        holder.imageView.setImageResource(item.getImageResId());
        holder.nameTextView.setText(item.getName());
        holder.descriptionTextView.setText(item.getDescription());
        holder.priceTextView.setText(item.getPrice());

        // Gérer l'action du bouton "+"
        holder.addButton.setOnClickListener(v -> {
            addToCart(item);
            Toast.makeText(v.getContext(), item.getName() + " ajouté au panier !", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return recommendedItems.size();
    }

    // Méthode pour ajouter un élément au panier
    private void addToCart(RecommendedItem item) {
        boolean exists = false;

        // Vérifie si l'article existe déjà dans le panier
        for (CartItem cartItem : cartItems) {
            if (cartItem.getName().equals(item.getName())) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                exists = true;
                break;
            }
        }

        // Si l'article n'existe pas, on l'ajoute au panier
        if (!exists) {
            cartItems.add(new CartItem(item.getImageResId(), item.getName(), item.getDescription(), item.getPrice(), 1));
        }
    }

    // Méthode pour récupérer les articles du panier
    public static List<CartItem> getCartItems() {
        return cartItems;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView, descriptionTextView, priceTextView;
        Button addButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_item);
            nameTextView = itemView.findViewById(R.id.tv_item_name);
            descriptionTextView = itemView.findViewById(R.id.tv_item_description);
            priceTextView = itemView.findViewById(R.id.tv_item_price);
            addButton = itemView.findViewById(R.id.btn_add_to_order);
        }
    }
}
