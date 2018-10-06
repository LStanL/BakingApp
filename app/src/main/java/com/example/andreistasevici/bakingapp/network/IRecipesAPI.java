package com.example.andreistasevici.bakingapp.network;

import com.example.andreistasevici.bakingapp.models.Recipe;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by andreistasevici on 10/4/18.
 */

public interface IRecipesAPI {

    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<ArrayList<Recipe>> fetchRecipes();
}
