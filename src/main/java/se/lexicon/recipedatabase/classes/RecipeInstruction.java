package se.lexicon.recipedatabase.classes;


import javax.persistence.*;

@Entity
public class RecipeInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String instructions;
}
