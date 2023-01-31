package se.lexicon.recipedatabase.classes;

import org.hibernate.annotations.GenericGenerator;
import se.lexicon.recipedatabase.Enum.Measurement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.UUID;


@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private double amount;

    private Measurement measurement;

    private Recipe recipe;
    @OneToMany
    private Ingredients ingredients;
}
