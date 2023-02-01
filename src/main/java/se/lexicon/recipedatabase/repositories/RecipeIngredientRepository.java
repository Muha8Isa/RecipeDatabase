package se.lexicon.recipedatabase.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.classes.RecipeIngredient;


@Repository
public interface RecipeIngredientRepository extends CrudRepository <RecipeIngredient, Integer> {


}
