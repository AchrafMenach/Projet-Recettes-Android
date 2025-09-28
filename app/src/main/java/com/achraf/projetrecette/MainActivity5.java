package com.achraf.projetrecette;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class MainActivity5 extends AppCompatActivity {
    private EditText etRecipeName, etIngredients, etSteps;
    private String originalRecipeData;
    private static final String PREF_NAME = "recetteApp";
    private static final String KEY_RECIPES = "recette";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        etRecipeName = findViewById(R.id.etRecipeName);
        etIngredients = findViewById(R.id.etIngredients);
        etSteps = findViewById(R.id.etSteps);
        Button btnSaveRecipe = findViewById(R.id.btnSaveRecipe);

        originalRecipeData = getIntent().getStringExtra("recipeData");
        if (originalRecipeData != null) {
            String[] parts = originalRecipeData.split("\\|");
            etRecipeName.setText(parts[0]);
            etIngredients.setText(parts[1]);
            etSteps.setText(parts[2]);
        } else {
            Toast.makeText(this, "Aucune recette sélectionnée pour modification", Toast.LENGTH_SHORT).show();
            finish();
        }

        btnSaveRecipe.setOnClickListener(v -> modifyRecipe());
    }

    private void modifyRecipe() {
        String newName = etRecipeName.getText().toString();
        String newIngredients = etIngredients.getText().toString();
        String newSteps = etSteps.getText().toString();

        if (newName.isEmpty() || newIngredients.isEmpty() || newSteps.isEmpty()) {
            Toast.makeText(this, "Tous les champs doivent être remplis", Toast.LENGTH_SHORT).show();
            return;
        }

        String newRecipeData = newName + "|" + newIngredients + "|" + newSteps;

        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Set<String> recipes = sharedPreferences.getStringSet(KEY_RECIPES, new HashSet<>());

        if (recipes != null) {
            Set<String> updatedRecipes = new HashSet<>(recipes);
            updatedRecipes.remove(originalRecipeData);
            updatedRecipes.add(newRecipeData);

            sharedPreferences.edit().putStringSet(KEY_RECIPES, updatedRecipes).apply();

            Toast.makeText(this, "Recette modifiée avec succès!", Toast.LENGTH_SHORT).show();

            finish();
        }
    }
}
