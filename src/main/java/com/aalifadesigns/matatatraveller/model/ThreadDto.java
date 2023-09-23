package com.aalifadesigns.matatatraveller.model;

import lombok.*;

import java.time.LocalDate;

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


}
