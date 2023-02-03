package se.lexicon.recipedatabase.repositories;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.recipedatabase.classes.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IngredientsRepositoryTest {

    @Autowired
    IngredientsRepository testObject;

    Ingredient addedIngredient1;
    Ingredient addedIngredient2;
    List<Ingredient> ingredientList = new ArrayList<>();

    @BeforeEach
    public void setup(){

        Ingredient ingredient1 = new Ingredient("garlic");
        Ingredient ingredient2 = new Ingredient("onion");


        createdIngredient1 = testObject.save(ingredient1);
        createdIngredient2 = testObject.save(ingredient2);
        assertNotNull(createdIngredient1);
        assertNotNull(createdIngredient2);

        addedIngredient1 = testObject.save(ingredient1);
        addedIngredient2 = testObject.save(ingredient2);
        assertNotNull(addedIngredient1);
        assertNotNull(addedIngredient2);


        ingredientList.add(addedIngredient1);
        ingredientList.add(addedIngredient2);


    }

    @Test
    public void findByIngredientIgnoreCase() {
        Optional<Ingredient> ingredientOptional = testObject.findByIngredientNameIgnoreCase(addedIngredient1.getIngredientName());
        assertTrue(ingredientOptional.isPresent());
        Ingredient actualData = ingredientOptional.get();
        Ingredient expectedData1 = addedIngredient1;
        assertEquals(expectedData1, actualData);
    }

    @Test
    public void findAllByIngredientContainsIgnoreCase() {

        List<Ingredient> actualList = testObject.findAllByIngredientNameContainsIgnoreCase("i"); //Both addedIngredients contain i, but if we could only test for one ingredient.
        List<Ingredient> expectedList = ingredientList;
        assertEquals(expectedList, actualList);

    }
}
