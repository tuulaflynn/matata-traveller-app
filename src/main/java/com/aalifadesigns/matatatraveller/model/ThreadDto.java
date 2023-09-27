package com.aalifadesigns.matatatraveller.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ThreadDto {
    private int threadId;

    private String threadContent;

    @NotNull
    private LocalDate threadDate;

    @NotNull    //  input validation for the backend
    private CityDto cityDto;

    @NotNull
    private List<CategoryDto> allCategoriesDto;


}
