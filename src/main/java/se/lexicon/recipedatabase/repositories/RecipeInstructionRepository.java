package se.lexicon.recipedatabase.repositories;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.recipedatabase.classes.RecipeInstruction;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
}
