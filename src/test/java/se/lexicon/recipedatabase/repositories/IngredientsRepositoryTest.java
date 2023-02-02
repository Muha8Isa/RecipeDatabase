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

    Ingredient createdIngredient1;
    Ingredient createdIngredient2;
    List<Ingredient> ingredientList;

    @BeforeEach
    public void setup(){

        Ingredient ingredient1 = new Ingredient("garlic");
        Ingredient ingredient2 = new Ingredient("onion");

        createdIngredient1 = testObject.save(ingredient1);
        createdIngredient2 = testObject.save(ingredient1);
        assertNotNull(createdIngredient1);
        assertNotNull(createdIngredient2);

        ingredientList.add(createdIngredient1);
        ingredientList.add(createdIngredient2);


    }

    @Test
    public void findByIngredientIgnoreCase() {

        Optional<Ingredient> ingredientOptional = testObject.findByIngredientNameIgnoreCase(createdIngredient1.getIngredientName());
        assertTrue(ingredientOptional.isPresent());
        Ingredient actualData = ingredientOptional.get();
        Ingredient expectedData = createdIngredient1;
        assertEquals(expectedData, actualData);

    }

    @Test
    public void findAllByIngredientContainsIgnoreCase() {

        List<Ingredient> actualList = testObject.findAllByIngredientNameContainsIgnoreCase("I");
        List<Ingredient> expectedList = ingredientList;
        assertEquals(expectedList, actualList);

    }
}
