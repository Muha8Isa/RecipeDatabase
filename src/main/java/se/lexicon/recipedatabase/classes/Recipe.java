package se.lexicon.recipedatabase.classes;

import javax.persistence.*;
import java.util.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String recipeName;

    @OneToMany(mappedBy = "recipe")
    List<RecipeIngredient> recipeIngredients;

    @OneToOne
    private RecipeInstruction instruction;

    @OneToMany //Can I have OneToMany in both linked entities? //RecipeCategory, Collection cannot be OneToOne or ManyToOne
    Set<RecipeCategory> categories;
}
