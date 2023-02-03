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
    }

}
