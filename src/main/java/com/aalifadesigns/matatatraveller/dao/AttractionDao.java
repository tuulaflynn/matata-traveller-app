package com.aalifadesigns.matatatraveller.dao;

import com.aalifadesigns.matatatraveller.dao.entities.AttractionEntity;
import com.aalifadesigns.matatatraveller.dao.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionDao extends JpaRepository<AttractionEntity, Integer> {

    List<AttractionEntity> findByCityEntity (CityEntity cityEntity);
}
