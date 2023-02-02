package se.lexicon.recipedatabase.repositories;


import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import se.lexicon.recipedatabase.classes.Ingredient;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@AutoConfigureTestEntityManager
@DirtiesContext
public class IngredientsRepositoryTest {

    @Autowired
    TestEntityManager em;

    @Autowired
    IngredientsRepository testObject;

    @BeforeEach
    public void setup(){

        Ingredient ingredient1 = new Ingredient("garlic");
        Ingredient ingredient2 = new Ingredient("onion");

        Ingredient createdIngredient1 = em.persist(ingredient1);
        Ingredient createdIngredient2 = em.persist(ingredient2);

        int createdIngredient1Id = createdIngredient1.getId();
        int createdIngredient2Id = createdIngredient2.getId();

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
}
