package com.achraf.projetrecette;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Set;

public class MainActivity2 extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "recetteApp";
    private static final String KEY_RECIPES = "recette";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        EditText rnom = findViewById(R.id.editText1);
        EditText ingredients = findViewById(R.id.editText2);
        EditText etape = findViewById(R.id.editText3);
        Button saveButton = findViewById(R.id.btnsave);

        saveButton.setOnClickListener(v -> {
            String name = rnom.getText().toString();
            String ingredientList = ingredients.getText().toString();
            String preparation = etape.getText().toString();

            if (name.isEmpty() || ingredientList.isEmpty() || preparation.isEmpty()) {
                Toast.makeText(this, "Tous les champs doivent être remplis!", Toast.LENGTH_SHORT).show();
                return;
            }

            Set<String> recipes = new HashSet<>(sharedPreferences.getStringSet(KEY_RECIPES, new HashSet<>()));
            recipes.add(name + "|" + ingredientList + "|" + preparation);
            sharedPreferences.edit().putStringSet(KEY_RECIPES, recipes).apply();
            Toast.makeText(this, "Recette sauvegardée!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
