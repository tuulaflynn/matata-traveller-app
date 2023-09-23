package com.aalifadesigns.matatatraveller.model;

import com.aalifadesigns.matatatraveller.dao.entities.CategoryEntity;
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
    private LocalDate threadDate;
    private CityDto cityDto;
    private List<CategoryDto> allCategoriesDto;


}
