package se.lexicon.recipedatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.recipedatabase.classes.Ingredient;
import se.lexicon.recipedatabase.repositories.IngredientsRepository;

import javax.transaction.Transactional;

@Component
public class Main implements CommandLineRunner {

    @Autowired // We need it in order to insert values into db, it seems that data cannot be inserted without it!
    IngredientsRepository ingredientsRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception{ //Why do we need exception here if it is never thrown? When is it thrown?
        ex1();
    }

    public void ex1(){
        Ingredient ingredientInformation1 = new Ingredient("Sugar");
        Ingredient ingredientInformation2 = new Ingredient("Flour");
        Ingredient addedIngredient1 = ingredientsRepository.save(ingredientInformation1);
        Ingredient addedIngredient2 = ingredientsRepository.save(ingredientInformation2);
    }
}
