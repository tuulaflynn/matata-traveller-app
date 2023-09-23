package com.aalifadesigns.matatatraveller.dao.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "city_details")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}

