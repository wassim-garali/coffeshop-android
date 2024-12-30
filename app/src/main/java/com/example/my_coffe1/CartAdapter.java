package com.example.my_coffe1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartItem> cartItemList;

    // Constructeur pour passer la liste des articles du panier
    public CartAdapter(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Charger le layout pour chaque article
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false); // item_cart.xml doit exister
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        // Obtenir l'article actuel
        CartItem item = cartItemList.get(position);

        // Liaison des données aux vues
        holder.itemImage.setImageResource(item.getImageResId()); // Image de l'article
        holder.itemName.setText(item.getName()); // Nom de l'article
        holder.itemDescription.setText(item.getDescription()); // Description de l'article
        holder.itemQuantity.setText("x" + item.getQuantity()); // Quantité
        holder.itemPrice.setText(item.getPrice()); // Prix
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    // Classe interne ViewHolder pour gérer les vues de chaque article
    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName, itemDescription, itemQuantity, itemPrice;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialisation des composants de l'UI
            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemDescription = itemView.findViewById(R.id.item_description);
            itemQuantity = itemView.findViewById(R.id.item_quantity);
            itemPrice = itemView.findViewById(R.id.item_price);
        }
    }
}
