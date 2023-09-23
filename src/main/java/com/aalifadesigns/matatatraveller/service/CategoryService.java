package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.CategoryDao;
import com.aalifadesigns.matatatraveller.model.CategoryDto;

import java.util.List;

public interface CategoryService {

    public List<CategoryDto> fetchAllCategories();
    public CategoryDto fetchACategory (int categoryId);
    public CategoryDto addCategory(CategoryDao newCategory);
    public CategoryDto updateCategory (CategoryDto updateCategory);
    public void removeCategory(int categoryId);

}
