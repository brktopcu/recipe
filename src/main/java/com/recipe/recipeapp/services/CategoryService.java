package com.recipe.recipeapp.services;

import com.recipe.recipeapp.commands.CategoryCommand;
import com.recipe.recipeapp.models.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getCategories();
}
