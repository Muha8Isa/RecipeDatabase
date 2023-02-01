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

    public RecipeIngredient() {
    }

    public RecipeIngredient(double amount, Measurement measurement, Recipe recipe, Set<Ingredient> ingredients) {
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
        this.ingredients = ingredients;
    }

    public RecipeIngredient(UUID id, double amount, Measurement measurement, Recipe recipe, Set<Ingredient> ingredients) {
        this.id = id;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(id, that.id) && measurement == that.measurement && Objects.equals(recipe, that.recipe) && Objects.equals(ingredients, that.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, measurement, recipe, ingredients);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id=" + id +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", recipe=" + recipe +
                ", ingredients=" + ingredients +
                '}';
    }
}
