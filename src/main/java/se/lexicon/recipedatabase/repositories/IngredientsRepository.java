package se.lexicon.recipedatabase.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.classes.Ingredient;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientsRepository extends CrudRepository<Ingredient, Integer> {
    Optional<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);
    List<Ingredient> findAllByIngredientNameContainsIgnoreCase(String ingredientName);
}
