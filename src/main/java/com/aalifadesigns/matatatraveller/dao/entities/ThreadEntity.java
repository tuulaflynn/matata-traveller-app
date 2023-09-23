package com.aalifadesigns.matatatraveller.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "thread_details")
public class ThreadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thread_id")
    private int threadId;

    @Column(name = "thread_content")
    private String threadContent;

    @Column(name = "threadDate")
    private LocalDate threadDate;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

}
