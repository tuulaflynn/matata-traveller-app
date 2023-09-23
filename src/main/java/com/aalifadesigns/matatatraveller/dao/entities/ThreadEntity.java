package com.aalifadesigns.matatatraveller.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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

    // I think this bidirectional mapping is unnecessary
    @ManyToMany(mappedBy = "allThreads")  // As the uni-directional mapping has already been made in CategoryEntity, this annotation makes it bidirectional
    private List<CategoryEntity> allCategoriesEntity;
    // this returns a list of all categories for threads

}
