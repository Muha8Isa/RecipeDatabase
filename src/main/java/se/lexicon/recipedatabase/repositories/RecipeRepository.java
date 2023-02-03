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

    List<Recipe> findAllByRecipeNameContainsIgnoreCase(String name);

   // List<Recipe> findAllByIngredientContainsIgnoreCase(Ingredient ingredient);
    //@Query("select r from Recipe r join r.recipeIngredients ri where ri.ingredients.ingredientName = :ingr")
    List<Recipe> findAllByRecipeIngredients_Ingredients( Ingredient ingredient);

            //and
            //ri.recipe.id = r.id")

    List<Recipe> findAllByCategoriesContains(RecipeCategory recipeCategory);

    @Query("select r from Recipe r where r.categories = :ctg")
    List<Recipe> findAllByCategories(@Param("ctg") Set<RecipeCategory> categories);

}
