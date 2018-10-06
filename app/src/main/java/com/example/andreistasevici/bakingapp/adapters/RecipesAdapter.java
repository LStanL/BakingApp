package com.example.andreistasevici.bakingapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andreistasevici.bakingapp.R;
import com.example.andreistasevici.bakingapp.models.Recipe;

import java.util.ArrayList;

/**
 * Created by andreistasevici on 9/30/18.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {

    private ArrayList<Recipe> recipes;

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
    public RecipesAdapter(ArrayList<Recipe> recipes) {
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
        holder.recipeName.setText(recipes.get(position).getName());
    }
}
