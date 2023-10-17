package com.aalifadesigns.matatatraveller.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//Using Lombok
@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

@Entity //declare class as entity
@Table (name= "category_details") //map the class to the category_details table
public class CategoryEntity {

    @Id //PK value
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-generated id
    @Column (name= "category_id") //map it to the column category_id
    private int categoryId;

    @Column (name= "category_name")
    private String categoryName;

    // Threads will be the owner instead (as this reflect on POST/PUT endpoints)
    /*
    @ManyToMany
    @JoinTable (name="thread_category_details",
                joinColumns = @JoinColumn (name = "category_id"),
                inverseJoinColumns = @JoinColumn(name = "thread_id"))*/

    @ManyToMany(mappedBy = "allCategoriesEntity")
    private List<ThreadEntity> allThreads; //collection of Threads (for each category)
}
