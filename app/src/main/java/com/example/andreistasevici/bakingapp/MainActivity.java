package com.example.andreistasevici.bakingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> data;

    private RecyclerView recipesRecyclerView;
    private LinearLayoutManager layoutManager;
    private RecipesAdapter recipesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            data.add(String.valueOf(i));
        }

        // setup recyclerview
        recipesRecyclerView = findViewById(R.id.recipes_recycler_view);

        // use a linear layout manager for recyclerview
        layoutManager = new LinearLayoutManager(this);
        recipesRecyclerView.setLayoutManager(layoutManager);

        // create adapter and use it for recyclerview
        recipesAdapter = new RecipesAdapter(data);
        recipesRecyclerView.setAdapter(recipesAdapter);


    }
}
