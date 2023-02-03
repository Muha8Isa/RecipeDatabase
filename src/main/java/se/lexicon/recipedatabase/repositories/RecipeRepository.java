package se.lexicon.recipedatabase.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.classes.Ingredient;
import se.lexicon.recipedatabase.classes.Recipe;
import se.lexicon.recipedatabase.classes.RecipeCategory;
import se.lexicon.recipedatabase.classes.RecipeIngredient;

import java.util.List;
import java.util.Set;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findByRecipeNameContainsIgnoreCase(String name);

    List<Recipe> findAllByCategoriesContains(RecipeCategory recipeCategory);

    //List<Recipe> findAllByCategoriesWithin(Set<RecipeCategory> categories);
    @Query("select r from Recipe r where r.categories = :ctg")
    List<Recipe> findAllByCategories(@Param("ctg") Set<RecipeCategory> categories);

}
