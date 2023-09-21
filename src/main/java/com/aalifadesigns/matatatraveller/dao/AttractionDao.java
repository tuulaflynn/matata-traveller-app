package com.aalifadesigns.matatatraveller.dao;

import com.aalifadesigns.matatatraveller.dao.entities.AttractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionDao extends JpaRepository<AttractionEntity, Integer> {
}
