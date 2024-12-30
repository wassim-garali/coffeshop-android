package com.example.my_coffe1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView cartRecyclerView;
    private TextView totalPriceTextView;
    private Button orderButton, cancelButton;
    private ArrayList<CartItem> cartItems;
    private double totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartRecyclerView = findViewById(R.id.recyclerCart);
        totalPriceTextView = findViewById(R.id.tv_total_price);
        orderButton = findViewById(R.id.btn_order);
        cancelButton = findViewById(R.id.btn_cancel);

        // Get the cart items from the Intent
        cartItems = getIntent().getParcelableArrayListExtra("cartItems");

        // Setup RecyclerView
        CartAdapter cartAdapter = new CartAdapter(cartItems);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartRecyclerView.setAdapter(cartAdapter);

        // Calculate total price
        calculateTotalPrice();

        // Display total price
        totalPriceTextView.setText("Total: $" + totalPrice);

        // Set OnClickListener for the "Commander" button
        orderButton.setOnClickListener(v -> showConfirmationDialog());

        // Set OnClickListener for the "Annuler" button to go back to MainActivity
        cancelButton.setOnClickListener(v -> {
            // Reset the cart items and total price when cancelling
            resetCart();
            // Return to MainActivity
            Intent intent = new Intent(CartActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Close CartActivity
        });
    }

    private void calculateTotalPrice() {
        totalPrice = 0;
        for (CartItem cartItem : cartItems) {
            totalPrice += Double.parseDouble(cartItem.getPrice().replace("$", "")) * cartItem.getQuantity();
        }
    }

    private void resetCart() {
        // Clear the cart items list
        cartItems.clear();
        // Reset the total price
        totalPrice = 0;
        // Update the total price display
        totalPriceTextView.setText("Total: $0.00");
    }

    private void showConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setMessage("Êtes-vous sûr de vouloir confirmer la commande ?")
                .setPositiveButton("Oui", (dialog, which) -> {
                    // Action pour confirmer la commande
                    Toast.makeText(CartActivity.this, "Commande confirmée !", Toast.LENGTH_SHORT).show();
                    finish(); // Retour à la page principale après la commande
                })
                .setNegativeButton("Non", (dialog, which) -> {
                    // Action pour annuler la commande
                    dialog.dismiss();
                })
                .create()
                .show();
    }
}
