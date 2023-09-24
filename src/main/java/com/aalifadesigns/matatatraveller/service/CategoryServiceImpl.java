package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.CategoryDao;
import com.aalifadesigns.matatatraveller.model.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


        return null;
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
