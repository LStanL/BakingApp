package com.example.andreistasevici.bakingapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.andreistasevici.bakingapp.R;
import com.example.andreistasevici.bakingapp.adapters.RecipesAdapter;
import com.example.andreistasevici.bakingapp.models.Recipe;
import com.example.andreistasevici.bakingapp.network.IRecipesAPI;
import com.example.andreistasevici.bakingapp.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Recipe> data;

    private RecyclerView recipesRecyclerView;
    private LinearLayoutManager layoutManager;
    private RecipesAdapter recipesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        data = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            data.add(String.valueOf(i));
//        }

        // create handle of RetrofitInstance interface
        IRecipesAPI apiService = RetrofitInstance.getRetrofitInstance().create(IRecipesAPI.class);

        Call<ArrayList<Recipe>> call = apiService.fetchRecipes();
        Log.d("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ArrayList<Recipe>>() {
            @Override
            public void onResponse(Call<ArrayList<Recipe>> call, Response<ArrayList<Recipe>> response) {
                // setup recyclerview
                recipesRecyclerView = findViewById(R.id.recipes_recycler_view);

                data = response.body();

                // use a linear layout manager for recyclerview
                layoutManager = new LinearLayoutManager(MainActivity.this);
                recipesRecyclerView.setLayoutManager(layoutManager);

                // create adapter and use it for recyclerview
                recipesAdapter = new RecipesAdapter(data);
                recipesRecyclerView.setAdapter(recipesAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Recipe>> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "Network request failed", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
