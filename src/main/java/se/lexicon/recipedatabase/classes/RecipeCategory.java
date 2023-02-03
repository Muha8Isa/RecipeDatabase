package se.lexicon.recipedatabase.classes;

import javax.persistence.*;
import java.util.*;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String category;

    @ManyToMany //Can I have OneToMany in both linked entities? Recipe
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    Set<Recipe> recipe = new HashSet<>();

    public RecipeCategory() {
    }

    public RecipeCategory(String category) {
        this.category = category;
    }

    public RecipeCategory(String category, Set<Recipe> recipe) {
        this.category = category;
        this.recipe = recipe;
    }

    public RecipeCategory(int id, String category, Set<Recipe> recipe) {
        this.id = id;
        this.category = category;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipe = recipe;
    }

    public void addRecipe(Recipe recipe){
        if(recipe == null) throw new IllegalArgumentException("Argument provided was null");
        this.recipe.add(recipe);
       // recipe.addCategory(this);
    }

    public void removeRecipe(Recipe recipe){
        if(recipe == null) throw new IllegalArgumentException("Argument provided was null");
        this.recipe.remove(recipe);
       // recipe.removeCategory(this);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return id == that.id && Objects.equals(category, that.category) && Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + category +
                '}';
    }
}
