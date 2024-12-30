package com.example.my_coffe1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private TextView createAccountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialisation des champs
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        createAccountText = findViewById(R.id.textCreateAccount);

        // Action pour le texte "Créer un compte"
        createAccountText.setOnClickListener(this::onCreateAccountClicked);
    }

    // Fonction pour la validation et la connexion
    public void login(View view) {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Vérification des champs vides
        if (email.isEmpty()) {
            emailEditText.setError("Email is required!");
            emailEditText.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordEditText.setError("Password is required!");
            passwordEditText.requestFocus();
            return;
        }

        // Simuler la validation de l'email et du mot de passe
        if (email.equals("wassim") && password.equals("1234")) {
            Toast.makeText(this, "Connexion réussie !", Toast.LENGTH_SHORT).show();
            // Rediriger vers l'activité principale
            Intent intent = new Intent(ActivityLogin.this, com.example.my_coffe1.MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    // Fonction pour la redirection vers la page de création de compte
    public void onCreateAccountClicked(View view) {
        // Rediriger vers la page de création de compte
        Intent intent = new Intent(ActivityLogin.this, ActivityRegister.class);
        startActivity(intent);
    }
}
