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
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private RecipeInstruction instruction;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    Set<RecipeCategory> categories = new HashSet<>();

    public Recipe() {
    }

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, Set<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe(int id, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, Set<RecipeCategory> categories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient){
        recipeIngredients.add(recipeIngredient);
        if(recipeIngredient == null) throw new IllegalArgumentException("Argument provided was null");
        recipeIngredient.setRecipe(this);
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<RecipeCategory> categories) {
        this.categories = categories;
    }

    public void addCategory(RecipeCategory recipeCategory){
        categories.add(recipeCategory);
        if(recipeCategory == null) throw new IllegalArgumentException("Argument provided was null");
        recipeCategory.addRecipe(this);
    }

    public void removeCategory(RecipeCategory recipeCategory) {
        if (categories == null) categories = new HashSet<>();
        categories.remove(recipeCategory);
        recipeCategory.removeRecipe(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && Objects.equals(recipeName, recipe.recipeName) && Objects.equals(recipeIngredients, recipe.recipeIngredients) && Objects.equals(instruction, recipe.instruction) && Objects.equals(categories, recipe.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeName, recipeIngredients, instruction, categories);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", instruction=" + instruction +
                ", categories=" + categories +
                '}';
    }
}
