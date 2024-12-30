package com.example.my_coffe1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecommendedAdapter adapter;
    private ArrayList<RecommendedItem> recommendedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView setup
        recyclerView = findViewById(R.id.recycler_recommended);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Set the layout manager for RecyclerView

        // Initialize the recommendedItems list
        recommendedItems = new ArrayList<>();

        // Create and set the adapter
        adapter = new RecommendedAdapter(this, recommendedItems);
        recyclerView.setAdapter(adapter);

        // Charger par défaut la catégorie "Salades"
        loadRecommendations("Salades");

        // Button to view the cart
        findViewById(R.id.btn_view_cart).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            intent.putParcelableArrayListExtra("cartItems", new ArrayList<>(RecommendedAdapter.getCartItems()));
            startActivity(intent);
        });

        // Set up the category buttons
        findViewById(R.id.icon_salades).setOnClickListener(v -> loadRecommendations("Salades"));
        findViewById(R.id.icon_omelettes).setOnClickListener(v -> loadRecommendations("Omlettes"));
        findViewById(R.id.icon_crepes_sales).setOnClickListener(v -> loadRecommendations("Crêpes Salées"));
        findViewById(R.id.icon_crepes_sucres).setOnClickListener(v -> loadRecommendations("Crêpes Sucrées"));
    }

    // Load different recommendations based on the selected category
    private void loadRecommendations(String category) {
        recommendedItems.clear(); // Clear the list before adding new items

        // Add items based on the selected category
        if (category.equals("Salades")) {
            recommendedItems.add(new RecommendedItem(R.drawable.saladeburatta, "Salade Burrata", "Roquette, burrata, noix de cajou, chia, sésames", "$13.10"));
            recommendedItems.add(new RecommendedItem(R.drawable.saladeeoxtic, "Salade Exotic", "Kiwi, ananas, crevette, mais, sauce pesto", "$12.00"));
            recommendedItems.add(new RecommendedItem(R.drawable.saladecesar, "Salade César", "Sauce césar, œuf, poulet, croutons, oignon", "$9.50"));
        } else if (category.equals("Omlettes")) {
            recommendedItems.add(new RecommendedItem(R.drawable.omletebres, "Omelette Brésilienne", "Œufs, champignons, mozzarella, poulet", "$10.50"));
            recommendedItems.add(new RecommendedItem(R.drawable.omlettearg, "Omelette Argentine", "Œufs, épinards, ricotta, persil, fromage", "$11.20"));
            recommendedItems.add(new RecommendedItem(R.drawable.omlettemex, "Omelette Mexicaine", "Œufs, légumes sautés, thon", "$17.20"));
        } else if (category.equals("Crêpes Salées")) {
            recommendedItems.add(new RecommendedItem(R.drawable.crepetoul, "Crêpe Toulouse", "Thon, fromage, olive, œuf", "$10.00"));
            recommendedItems.add(new RecommendedItem(R.drawable.crepepoul, "Crêpe Los Pollos", "Poulet, sauce blanche, mozzarella et gruyère", "$12.50"));
            recommendedItems.add(new RecommendedItem(R.drawable.crepejamb, "Crêpe Jambon", "3 Jambons, sauce blanche, fromage", "$9.50"));
        } else if (category.equals("Crêpes Sucrées")) {
            recommendedItems.add(new RecommendedItem(R.drawable.crepepist, "Crêpe Crunch Pistachio", "Beurre de pistache et pistache concassée", "$11.50"));
            recommendedItems.add(new RecommendedItem(R.drawable.crepechoco, "Crêpe Choco-Banane", "Chocolat noir et banane", "$10.00"));
            recommendedItems.add(new RecommendedItem(R.drawable.crepenois, "Crêpe Noisettino", "Beurre de noisette et noisette concassée", "$8.00"));
        }

        // Notify the adapter to update the RecyclerView
        adapter.notifyDataSetChanged();
    }
}
