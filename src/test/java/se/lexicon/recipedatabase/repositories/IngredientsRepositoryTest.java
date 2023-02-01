package se.lexicon.recipedatabase.repositories;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.recipedatabase.classes.Ingredient;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class IngredientsRepositoryTest {


    @Autowired
    IngredientsRepository testObject;

    Ingredient addedIngredient;

    @BeforeEach
    public void setup(){

        Ingredient ingredient1 = new Ingredient("garlic");
        Ingredient ingredient2 = new Ingredient("onion");

        addedIngredient = testObject.save(ingredient1);
        addedIngredient = testObject.save(ingredient2);

        assertNotNull(ingredient1);
        assertNotNull(ingredient2);

    }
    @Test
    public void test_findByIngredient(){
        Optional<Ingredient> ingredientOptional = testObject.findByIngredientIgnoreCase(addedIngredient.getIngredientName());
        assertTrue(ingredientOptional.isPresent());
        Ingredient actualData = ingredientOptional.get();
        Ingredient expectedData = addedIngredient;
        assertEquals(expectedData, actualData);
    }

}
