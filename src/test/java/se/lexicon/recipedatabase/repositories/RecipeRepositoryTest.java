package se.lexicon.recipedatabase.repositories;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.recipedatabase.Enum.Measurement;
import se.lexicon.recipedatabase.classes.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecipeRepositoryTest {

    @Autowired
    RecipeInstructionRepository recipeInstructionRepository;

    @Autowired
    RecipeRepository testObject;
    @Autowired
    IngredientsRepository ingredientManager;

    @Autowired
    RecipeIngredientRepository recipeManager;

    Ingredient addedIngredient1;
    Ingredient addedIngredient2;

    RecipeIngredient onions;
    RecipeIngredient garlics;

    RecipeInstruction onionStewInstruction;

    RecipeCategory stews;

    Set<RecipeCategory> recipeCategories;
   // List<RecipeIngredient> recipeIngredientList;

    Recipe onionStew;
    Recipe steak;

    @BeforeEach
    public void setup() {

       // recipeIngredientList = new ArrayList<>();
        onionStew = new Recipe("Onionstew");
        steak = new Recipe("Steak");


        Ingredient ingredient1 = new Ingredient("garlic");
        Ingredient ingredient2 = new Ingredient("onion");

        addedIngredient1 = ingredientManager.save(ingredient1);
        addedIngredient2 = ingredientManager.save(ingredient2);
        assertNotNull(addedIngredient1);
        assertNotNull(addedIngredient2);

        onions = new RecipeIngredient(200d, Measurement.TSP);
        garlics = new RecipeIngredient(150d, Measurement.DL);

        onions.setIngredients(ingredient1);
        garlics.setIngredients(ingredient2);

        //onions.setRecipe(onionStew);
        //garlics.setRecipe(onionStew);

        onionStewInstruction = new RecipeInstruction("Add onions and garlic to the stew");

        onionStew.setInstruction(onionStewInstruction);
        steak.setInstruction(onionStewInstruction);

        stews = new RecipeCategory("Here be stews yo");

        onionStew.addCategory(stews);
        steak.addCategory(stews);

        recipeManager.save(onions);
        recipeManager.save(garlics);
        //List<RecipeIngredient> ingredients = new ArrayList<>();

        onionStew.addRecipeIngredient(onions);
        onionStew.addRecipeIngredient(garlics);
        steak.addRecipeIngredient(garlics);
        testObject.save(onionStew);
        testObject.save(steak);

    }

    @Test
    public void findAllRecipesByIngredients() {

            List<Recipe> actualData = testObject.findAllByRecipeIngredients_Ingredients(ingredientManager.findById(addedIngredient1.getId()).get());
            List<Recipe> expectedData1 = new ArrayList<>();
            expectedData1.add(onionStew);
            assertEquals(expectedData1, actualData);
    }

    @Test
    public void findAllByRecipeNameContainsIgnoreCase() {
        List<Recipe> expectedData2 = new ArrayList<>();
        expectedData2.add(onionStew);
        List<Recipe> actualData = testObject.findAllByRecipeNameContainsIgnoreCase("onio");
        assertEquals(expectedData2, actualData);
    }

    @Test
    public void findAllByCategoriesContains() {
        List<Recipe> expectedData3 = new ArrayList<>();
        expectedData3.add(onionStew);
        List<Recipe> actualData = testObject.findAllByCategoriesContains(stews);
        assertEquals(expectedData3, actualData);
    }

    @Test
    public void findAllByCategories() {
        List<Recipe> expectedData4 = new ArrayList<>();
        expectedData4.add(onionStew);
        Set<RecipeCategory> categories = new HashSet<>();
        categories.add(stews);
        List<Recipe> actualData = testObject.findAllByCategories(categories);
        assertEquals(expectedData4, actualData);

    }
}

