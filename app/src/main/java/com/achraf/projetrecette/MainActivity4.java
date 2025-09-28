package com.achraf.projetrecette;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Set;

public class MainActivity4 extends AppCompatActivity {
    private String recipeData;
    private static final String PREF_NAME = "recetteApp";
    private static final String KEY_RECIPES = "recette";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        recipeData = getIntent().getStringExtra("recipeData");
        String[] parts = recipeData.split("\\|");

        ((TextView) findViewById(R.id.tvRecipeName)).setText(parts[0]);
        ((TextView) findViewById(R.id.tvIngredients)).setText(parts[1]);
        ((TextView) findViewById(R.id.tvSteps)).setText(parts[2]);

        Button btnEdit = findViewById(R.id.btnmodifier);
        btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity5.class);
            intent.putExtra("recipeData", recipeData);
            startActivityForResult(intent, 1);
        });

        findViewById(R.id.btnDeleteRecipe).setOnClickListener(v -> deleteRecipe());
    }
    private void deleteRecipe() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Set<String> recipes = sharedPreferences.getStringSet(KEY_RECIPES, new HashSet<>());

        if (recipes != null && recipes.contains(recipeData)) {
            Set<String> updatedRecipes = new HashSet<>(recipes);
            updatedRecipes.remove(recipeData);

            sharedPreferences.edit().putStringSet(KEY_RECIPES, updatedRecipes).apply();
            Toast.makeText(this, "Recette supprimée", Toast.LENGTH_SHORT).show();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("deletedRecipe", recipeData);
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }
}
