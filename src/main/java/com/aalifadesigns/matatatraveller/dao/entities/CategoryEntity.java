package com.aalifadesigns.matatatraveller.dao.entities;

import com.aalifadesigns.matatatraveller.model.ThreadDto;
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

    //implement the ManyToMany relationship between the Categories and Threads
    //joinTable name specifies the table that connects these 2 tables, and therefore category_details becomes the owner
    //the thread_details is the inverse
    //JoinColumn/ inverseJoinColumn - on the FK column, which connects with the 3rd table
    @ManyToMany
    @JoinTable (name="thread_category",
                joinColumns = @JoinColumn (name = "category_id"),
                inverseJoinColumns = @JoinColumn(name = "thread_id"))

    private List<ThreadEntity> allThreads; //collection of Threads
}
