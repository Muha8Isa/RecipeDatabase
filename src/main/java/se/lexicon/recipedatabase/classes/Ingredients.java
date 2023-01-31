package se.lexicon.recipedatabase.classes;


import javax.persistence.*;

@Entity
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String ingredientName;

    @ManyToOne
    private RecipeIngredient recipeIngredient;
}
