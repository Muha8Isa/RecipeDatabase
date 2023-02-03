package se.lexicon.recipedatabase.repositories;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.recipedatabase.Enum.Measurement;
import se.lexicon.recipedatabase.classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecipeRepositoryTest {


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



    @BeforeEach
    public void setup() {

       // recipeIngredientList = new ArrayList<>();

        Recipe onionStew = new Recipe("Onionstew");

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

        onions.setRecipe(onionStew);
        garlics.setRecipe(onionStew);

        onionStewInstruction = new RecipeInstruction("Add onions and garlic to the stew");

        onionStew.setInstruction(onionStewInstruction);
        onionStew.setRecipeIngredients();

        stews = new RecipeCategory("Here be stews yo");

        onionStew.addCategory(stews);

        testObject.save(onionStew);

    }

    @Test
    public void findAllRecipesByIngredients() {

        //System.out.println(testObject.findAllRecipesByIngredients(onions.getIngredients().getIngredientName()));
        System.out.println(testObject.findAll());

        /*
            Optional<Ingredient> ingredientOptional = testObject.findByIngredientNameIgnoreCase(addedIngredient1.getIngredientName());
            assertTrue(ingredientOptional.isPresent());
            Ingredient actualData = ingredientOptional.get();
            Ingredient expectedData1 = addedIngredient1;
            assertEquals(expectedData1, actualData);

         */

    }


}

