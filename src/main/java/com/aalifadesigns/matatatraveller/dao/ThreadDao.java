package com.aalifadesigns.matatatraveller.dao;

import com.aalifadesigns.matatatraveller.dao.entities.ThreadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadDao extends JpaRepository<ThreadEntity, Integer> {
}
