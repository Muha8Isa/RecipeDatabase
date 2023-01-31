package se.lexicon.recipedatabase.classes;

import java.util.*;

public class Recipe {
    private int id;
    private String recipeName;
    List<RecipeIngredient> recipeIngredients;

    RecipeInstruction instruction;
    Set<RecipeCategory> categories;
}
