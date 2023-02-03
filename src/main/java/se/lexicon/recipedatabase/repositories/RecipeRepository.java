package se.lexicon.recipedatabase.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.classes.Recipe;
import se.lexicon.recipedatabase.classes.RecipeCategory;

import java.util.List;
import java.util.Set;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findAllByRecipeNameContainsIgnoreCase(String name);

    List<Recipe> findAllByCategoriesContains(RecipeCategory recipeCategory);

    //List<Recipe> findAllByCategoriesWithin(Set<RecipeCategory> categories);

}
