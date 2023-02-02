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

    public Optional<Ingredient> findByIngredientIgnoreCase(String ingredient) {
        return testObject.findByIngredientNameIgnoreCase(ingredient);
    }

    public List<Ingredient> findAllByIngredientContainsIgnoreCase(String ingredient) {
        return testObject.findAllByIngredientNameContainsIgnoreCase(ingredient);
    }

    public <S extends Ingredient> S save(S entity) {
        return testObject.save(entity);
    }

    public <S extends Ingredient> Iterable<S> saveAll(Iterable<S> entities) {
        return testObject.saveAll(entities);
    }

    public Optional<Ingredient> findById(Integer integer) {
        return testObject.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return testObject.existsById(integer);
    }

    public Iterable<Ingredient> findAll() {
        return testObject.findAll();
    }

    public Iterable<Ingredient> findAllById(Iterable<Integer> integers) {
        return testObject.findAllById(integers);
    }

    public long count() {
        return testObject.count();
    }

    public void deleteById(Integer integer) {
        testObject.deleteById(integer);
    }

    public void delete(Ingredient entity) {
        testObject.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {
        testObject.deleteAllById(integers);
    }

    public void deleteAll(Iterable<? extends Ingredient> entities) {
        testObject.deleteAll(entities);
    }

    public void deleteAll() {
        testObject.deleteAll();
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
