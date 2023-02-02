package se.lexicon.recipedatabase.repositories;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.recipedatabase.classes.Ingredient;

import java.util.Optional;

@DataJpaTest
public class IngredientsRepositoryTest {

    @Autowired
    IngredientRepository testObject;

    Ingredient addedIngredient;
    @BeforeEach
    public void setup(){
        Ingredient ingredient1 = new Ingredient("Garlic");
        Ingredient ingredient2 = new Ingredient("Onion");
        addedIngredient = testObject.save(ingredient1);
        addedIngredient = testObject.save(ingredient2);
        assertNotNull(addedIngredient);
    }

    @Test
    public void test_findByIngredientName(){
        Optional<Ingredient> ingredientOptional = testObject.findByIngredientNameIgnoreCase(addedIngredient.getIngredientName());
        assertTrue(ingredientOptional.isPresent());
        Ingredient actualData = ingredientOptional.get();
        Ingredient expectedData = addedIngredient;
        assertEquals(expectedData, actualData);
    }

}