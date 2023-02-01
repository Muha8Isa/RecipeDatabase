package se.lexicon.recipedatabase.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.classes.RecipeInstruction;

@Repository
public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
}
