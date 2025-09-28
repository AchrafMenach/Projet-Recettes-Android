package com.achraf.projetrecette;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity3 extends AppCompatActivity {
    private ArrayList<String> recipeList;
    private RecetteAdapter adapter;
    private static final String PREF_NAME = "recetteApp";
    private static final String KEY_RECIPES = "recette";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recipeList = new ArrayList<>();
        MiseAjoursRecette();

        adapter = new RecetteAdapter(recipeList, recipe -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra("recipeData", recipe);
            startActivityForResult(intent, 1);
        });
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        MiseAjoursRecette();
        adapter.notifyDataSetChanged();
    }
    private void MiseAjoursRecette() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Set<String> recipes = sharedPreferences.getStringSet(KEY_RECIPES, null);
        recipeList.clear();
        if (recipes != null) {
            recipeList.addAll(recipes);
        }
    }
}
