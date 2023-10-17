package com.aalifadesigns.matatatraveller.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "thread_details")
public class ThreadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thread_id")
    private int threadId;

    @Column(name = "thread_content")
    private String threadContent;

    @Column(name = "threadDate")
    private LocalDate threadDate;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    //implement the ManyToMany relationship between the Categories and Threads
    //JoinColumn/ inverseJoinColumn - on the FK column, which connects with the 3rd table
    @ManyToMany
    @JoinTable (name="thread_category_details",     //the table that connects these 2 tables (thread_details becomes the owner)
            joinColumns = @JoinColumn (name = "thread_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")) //the category_details is the inverse
    private List<CategoryEntity> allCategoriesEntity;

}
