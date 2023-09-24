package com.aalifadesigns.matatatraveller.controller;

import com.aalifadesigns.matatatraveller.model.CategoryDto;
import com.aalifadesigns.matatatraveller.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // 1. fetch all categories
    // http://localhost:7474/api/categories
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> fetchAllCategories() {
        return new ResponseEntity<List<CategoryDto>>(categoryService.fetchAllCategories(), HttpStatus.OK);

    }

    // 2. fetch a category
    // http://localhost:7474/api/categories/2
    @GetMapping("/categories/{cid}")
    // PathVariable with the name bid and should be extracted and store in a java variable/parameter(cityId)
    public ResponseEntity<CategoryDto> fetchCategory(@PathVariable("cid") int categoryId) {
        return new ResponseEntity<CategoryDto>(categoryService.fetchACategory(categoryId), HttpStatus.OK);
    }

    // 3. add a category
    // http://localhost:7474/api/categories
    @PostMapping("/categories")
    public CategoryDto addCategory(@RequestBody CategoryDto newCategory) {
        return categoryService.addCategory(newCategory);
    }

    // 4. update a category
    // http://localhost:7474/api/categories
    @PutMapping("categories")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto updateCategory) {
        return new ResponseEntity<>(categoryService.updateCategory(updateCategory), HttpStatus.OK);
    }

    // 5. delete a category
    // http://localhost:7474/api/categories/3
    @DeleteMapping("/categories/{cid}")
    public ResponseEntity<Void> removeLocation(@PathVariable("cid") int categoryId) {
        categoryService.removeCategory(categoryId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

