package com.example.andreistasevici.bakingapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andreistasevici on 9/30/18.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {

    // using list of integeres until implementing Recipe class
    // private List<Recipe> recipes;
    private List<String> recipes;

    //internal class for custom ViewHolder
    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        private TextView recipeName;
        private ImageView imageView;

        //constructor
        public RecipeViewHolder(View view) {
            super(view);
            this.recipeName = view.findViewById(R.id.tv_recipe_name);
            this.imageView = view.findViewById(R.id.iv_recipe_thumbnail);

        }
    }

    //adapter constructor
    public RecipesAdapter(List<String> recipes) {
        this.recipes = recipes;
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_item, parent, false);

        RecipeViewHolder recipeViewHolder = new RecipeViewHolder(v);
        return recipeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.recipeName.setText(recipes.get(position));
    }
}
