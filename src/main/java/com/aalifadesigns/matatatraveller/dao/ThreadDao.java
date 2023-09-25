package com.aalifadesigns.matatatraveller.dao;

import com.aalifadesigns.matatatraveller.dao.entities.CategoryEntity;
import com.aalifadesigns.matatatraveller.dao.entities.CityEntity;
import com.aalifadesigns.matatatraveller.dao.entities.ThreadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ThreadDao extends JpaRepository<ThreadEntity, Integer> {
    List<ThreadEntity> findByThreadDate(LocalDate threadDate);

    //finder extra method to fetch threads by city
    List<ThreadEntity> findByCityEntity (CityEntity cityEntity);

    //finder extra method to fetch threads by category
    List<ThreadEntity> findByAllCategoriesEntity (CategoryEntity categoryEntity);

}
