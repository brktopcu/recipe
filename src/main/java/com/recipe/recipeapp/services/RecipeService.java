package com.recipe.recipeapp.services;

import com.recipe.recipeapp.commands.RecipeCommand;
import com.recipe.recipeapp.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand findCommandById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    void deleteById(Long id);
}
