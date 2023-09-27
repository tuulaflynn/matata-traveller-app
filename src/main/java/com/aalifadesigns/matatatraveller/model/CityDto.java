package com.aalifadesigns.matatatraveller.model;

import lombok.*;
import org.springframework.http.HttpStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

//Using LOMBOK
@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

public class CityDto {

    private int cityId;
    @NotNull //input validation
    private String cityName;
    @NotNull //input validation
    private String cityCountry;
    private String cityImg;
    private String cityCurrency;

    //corresponding to the City entity object (Many to Many - one city has many threads)
    private List<ThreadDto> allThreads;

    //corresponding to the City entity object (One to Many - one city has many attractions)
    private List<AttractionDto> allAttractions;

}
