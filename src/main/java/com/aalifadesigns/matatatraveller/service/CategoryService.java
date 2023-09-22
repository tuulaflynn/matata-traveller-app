package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.model.CategoryDto;

import java.util.List;

public interface CategoryService {

    public List<CategoryDto> fetchAllCategories();
    public CategoryDto fetchACategory (int categoryId);

}
