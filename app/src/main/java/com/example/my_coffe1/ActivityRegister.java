package com.example.my_coffe1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityRegister extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private Button registerButton;
    private TextView backToLoginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Liaison des widgets avec leurs IDs dans le fichier XML
        nameEditText = findViewById(R.id.editTextName);
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        confirmPasswordEditText = findViewById(R.id.editTextConfirmPassword);
        registerButton = findViewById(R.id.buttonRegister);
        backToLoginText = findViewById(R.id.textBackToLogin);

        // Action pour le bouton "Créer un compte"
        registerButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String confirmPassword = confirmPasswordEditText.getText().toString().trim();

            // Validation des champs
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(ActivityRegister.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(ActivityRegister.this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
            } else if (password.length() < 6) {
                Toast.makeText(ActivityRegister.this, "Le mot de passe doit contenir au moins 6 caractères", Toast.LENGTH_SHORT).show();
            } else {
                // Enregistrer l'utilisateur (logique fictive)
                Toast.makeText(ActivityRegister.this, "Compte créé avec succès !", Toast.LENGTH_SHORT).show();

                // Rediriger vers la page de connexion
                Intent intent = new Intent(ActivityRegister.this, ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        });

        // Action pour le texte "Retour à la connexion"
        backToLoginText.setOnClickListener(v -> {
            // Rediriger vers la page de connexion
            Intent intent = new Intent(ActivityRegister.this, ActivityLogin.class);
            startActivity(intent);
            finish();
        });
    }
}
