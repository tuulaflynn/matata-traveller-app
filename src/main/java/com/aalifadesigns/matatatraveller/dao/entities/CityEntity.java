package com.aalifadesigns.matatatraveller.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//Using LOMBOK
@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

@Entity
@Table(name = "city_details")
public class CityEntity {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-generated
    @Column(name = "city_id")
    private int cityId;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "city_country")
    private String cityCountry;

    @Column(name = "city_img")
    private String cityImg;

    @Column(name = "city_currency")
    private String cityCurrency;

    //ManyToMany relationship with Threads
    //joinTable name specifies the table that connects these 2 tables, and the city_details becomes the owner
    //the thread_details is the inverse
    //JoinColumn/ inverseJoinColumn - on the FK column, which connects with the 3rd table
/*    @ManyToMany
    @JoinTable(name = "city_thread",
            joinColumns = @JoinColumn(name = "city_id"),
            inverseJoinColumns = @JoinColumn(name = "thread_id"))
    private List<ThreadEntity> allThreads; //collection of Threads*/

    @OneToMany(mappedBy = "cityEntity")        // this creates the bidirectional mapping
    private List<ThreadEntity> allThreads;     //collection of Threads for a city can be obtained through this field

    //OneToMany relationship with Attractions
    @OneToMany (mappedBy = "cityEntity")
    private List<AttractionEntity> allAttractions;

}

