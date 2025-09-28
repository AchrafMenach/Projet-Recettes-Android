package com.achraf.projetrecette;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecetteAdapter extends RecyclerView.Adapter<RecetteAdapter.ViewHolder> {
    private List<String> recipeList;
    private OnRecipeClickListener listener;
    public RecetteAdapter(List<String> recipeList, OnRecipeClickListener listener) {
        this.recipeList = recipeList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String recipe = recipeList.get(position);
        String recipeName = recipe.split("\\|")[0];
        holder.tvRecipeName.setText(recipeName);
        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecipeClick(recipe);
            }
        });
    }
    @Override
    public int getItemCount() {
        return recipeList.size();
    }
    public interface OnRecipeClickListener {
        void onRecipeClick(String recipe);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRecipeName;
        Button btnDetails;
        public ViewHolder(View itemView) {
            super(itemView);
            tvRecipeName = itemView.findViewById(R.id.tvRecipeName);
            btnDetails = itemView.findViewById(R.id.btnDetails);
        }
    }
}
