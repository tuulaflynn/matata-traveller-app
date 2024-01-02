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

    @Column(name = "city_currency")
    private String cityCurrency;

    //OneToMany relation with Threads
    @OneToMany(mappedBy = "cityEntity")        // this creates the bidirectional mapping
    private List<ThreadEntity> allThreads;     //collection of Threads for a city can be obtained through this field

    //OneToMany relationship with Attractions
    @OneToMany(mappedBy = "cityEntity")
    private List<AttractionEntity> allAttractions;

}

