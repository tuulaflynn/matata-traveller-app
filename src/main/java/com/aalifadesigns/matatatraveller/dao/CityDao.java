package com.aalifadesigns.matatatraveller.dao;

import com.aalifadesigns.matatatraveller.dao.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<CityEntity, Integer> {
}
