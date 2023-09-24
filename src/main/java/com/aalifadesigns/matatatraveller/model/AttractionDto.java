package com.aalifadesigns.matatatraveller.model;

import lombok.*;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

//Using LOMBOK
@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code
public class AttractionDto {
    private int attractionId;
    private String attractionName;
    private String attractionDescription;
    private String attractionImage;
    private CityDto cityDto;
}
