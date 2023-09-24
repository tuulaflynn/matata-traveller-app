package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.CategoryDao;
import com.aalifadesigns.matatatraveller.dao.entities.CategoryEntity;
import com.aalifadesigns.matatatraveller.dao.entities.ThreadEntity;
import com.aalifadesigns.matatatraveller.model.CategoryDto;
import com.aalifadesigns.matatatraveller.model.ThreadDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao;

    @Autowired //Constructor Dependency Injection
    public CategoryServiceImpl(CategoryDao categoryDao) {

        this.categoryDao = categoryDao;
    }

    @Override
    public List<CategoryDto> fetchAllCategories() {
        //call findAll(), which will return a collection of entities, stored in allCategoryEntity
        List<CategoryEntity> allCategoryEntity = categoryDao.findAll();

        //copy the entities into CategoryDto objects and store them in a collection(which the method will return)
        List<CategoryDto> allCategoryDto = new ArrayList<CategoryDto>();

        //traverse the collection, using a forEach loop
        allCategoryEntity.forEach((eachCategoryEntity) -> {
            //copy each entity into a CategoryDto
            CategoryDto eachCategoryDto = new CategoryDto();
            BeanUtils.copyProperties(eachCategoryEntity, eachCategoryDto);

            //copy also the lists of threads (many-to-many mapped relationships)
            //traverse the collection,copy each entity into a Dto object, and form a collection of ThreadDto, to be set in the CategoryDto
            List<ThreadDto> allThreadDto = new ArrayList<ThreadDto>();
            for (ThreadEntity eachThreadEntity : eachCategoryEntity.getAllThreads()) {
                ThreadDto eachThreadDto = new ThreadDto();
                //copy each ThreadEntity into ThreadDto object
                BeanUtils.copyProperties(eachThreadEntity, eachThreadDto);
                //add the ThreadDto to the collection
                allThreadDto.add(eachThreadDto);
            }

            //set the ThreadDto collection inside CityDto
            eachCategoryDto.setAllThreads(allThreadDto);

            //add the CityDto to the collection (containing now also the Threads and Attraction collections too)
            allCategoryDto.add(eachCategoryDto);
        });

        return allCategoryDto;
    }

    @Override
    public CategoryDto fetchACategory(int categoryId) {
        return null;
    }

    @Override
    public CategoryDto addCategory(CategoryDao newCategory) {
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto updateCategory) {
        return null;
    }

    @Override
    public void removeCategory(int categoryId) {

    }
}
