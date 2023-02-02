package se.lexicon.recipedatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.recipedatabase.classes.Ingredient;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RecipeDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeDatabaseApplication.class, args);
        ex1();
    }

    public static void ex1(){
    List<Ingredient> ingredientList = new ArrayList<>();
    Ingredient addedIngredient1 = new Ingredient("Garlic");
    Ingredient addedIngredient2 = new Ingredient("Onion");
    ingredientList.add(addedIngredient1);
    ingredientList.add(addedIngredient2);
    System.out.println(ingredientList);
    }


}
