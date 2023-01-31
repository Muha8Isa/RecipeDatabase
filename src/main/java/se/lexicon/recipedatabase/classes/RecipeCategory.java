package se.lexicon.recipedatabase.classes;

import javax.persistence.*;
import java.util.*;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String category;

    @OneToMany ////Can I have OneToMany in both linked entities? Recipe
    Set<Recipe> recipe;
}
