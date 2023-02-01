package se.lexicon.recipedatabase.classes;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String ingredientName;

    @ManyToOne
    private RecipeIngredient recipeIngredient;

    public Ingredient() {
    }

    public Ingredient(String ingredientName, RecipeIngredient recipeIngredient) {
        this.ingredientName = ingredientName;
        this.recipeIngredient = recipeIngredient;
    }

    public Ingredient(int id, String ingredientName, RecipeIngredient recipeIngredient) {
        this.id = id;
        this.ingredientName = ingredientName;
        this.recipeIngredient = recipeIngredient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public RecipeIngredient getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(RecipeIngredient recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id && Objects.equals(ingredientName, that.ingredientName) && Objects.equals(recipeIngredient, that.recipeIngredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredientName, recipeIngredient);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                ", recipeIngredient=" + recipeIngredient +
                '}';
    }
}

