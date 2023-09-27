package com.aalifadesigns.matatatraveller.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

//Using LOMBOK
@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

public class CategoryDto {
    private int categoryId;

    @NotNull
    private String categoryName;

    //corresponding to the Category entity object (ManytoMany- one category has many threads)
    private List<ThreadDto> allThreads;
}
