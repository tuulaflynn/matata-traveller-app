package com.aalifadesigns.matatatraveller.model;

import lombok.*;
//Using LOMBOK
@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

public class CityDto {
    private int cityId;
    private String cityName;
    private String cityCountry;
    private String cityImg;
    private String cityCurrency;
}
