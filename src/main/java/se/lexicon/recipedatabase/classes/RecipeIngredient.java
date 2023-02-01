package se.lexicon.recipedatabase.classes;

import org.hibernate.annotations.GenericGenerator;
import se.lexicon.recipedatabase.Enum.Measurement;

import javax.persistence.*;
import java.util.*;
import java.util.UUID;


@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private Measurement measurement;

    @ManyToOne
    private Recipe recipe;
    @OneToMany(mappedBy = "recipeIngredient") // According to the table, this should be @ManyToOne, but collections cannot be @ManyToOne
    private Set<Ingredient> ingredients;
}
