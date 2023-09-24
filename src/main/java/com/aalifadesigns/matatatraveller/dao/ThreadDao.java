package com.aalifadesigns.matatatraveller.dao;

import com.aalifadesigns.matatatraveller.dao.entities.CategoryEntity;
import com.aalifadesigns.matatatraveller.dao.entities.ThreadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ThreadDao extends JpaRepository<ThreadEntity, Integer> {
    List<ThreadEntity> findByThreadDate(LocalDate threadDate);
}
