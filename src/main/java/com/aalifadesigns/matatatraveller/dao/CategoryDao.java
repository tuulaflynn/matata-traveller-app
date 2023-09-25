package com.aalifadesigns.matatatraveller.dao;

import com.aalifadesigns.matatatraveller.dao.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //required Spring annotation - stereotype
public interface CategoryDao extends JpaRepository<CategoryEntity, Integer> {

    //as this project uses JPA, there no need for a Dao Implementation class, instead SPRING JPA will handle all the Dao related queries
    //the interface will extend JpaRepository interface, which takes 2 generics parameters:
    // the entity type and the data type of the PK (int becomes Integer wrapper class)

    //if we were to implement more than the 5 CRUD operations, it would require to write extra Finder methods (not the case here, but for attractions and for threads yes)
}
