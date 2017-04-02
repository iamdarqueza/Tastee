package Model;

/**
 * Created by Amiel on 03/04/2017.
 */

import java.util.List;

public class Recipe {

    private Integer recipeNo;
    private String recipeName;
    private List<Ingredients> ingredients;

    public Integer getRecipeNo() {
        return recipeNo;
    }

    public void setRecipeNo(Integer recipeNo) {
        this.recipeNo = recipeNo;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}

