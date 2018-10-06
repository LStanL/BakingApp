package com.example.andreistasevici.bakingapp.models;

/**
 * Created by andreistasevici on 9/30/18.
 */

public class Recipe {

    private int id;
    private String name;
    //private List<Ingredient> ingredients;
    //private List<CookingStep> cookingSteps;
    private double servingsCount;
    private String imagePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getServingsCount() {
        return servingsCount;
    }

    public void setServingsCount(double servingsCount) {
        this.servingsCount = servingsCount;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
