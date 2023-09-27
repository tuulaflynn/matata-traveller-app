package com.aalifadesigns.matatatraveller.controller;

import com.aalifadesigns.matatatraveller.model.CategoryDto;
import com.aalifadesigns.matatatraveller.service.CategoryService;
import jakarta.validation.Valid;
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

    @Autowired // Constructor Dependency Injection
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // 1. fetch all categories
    // http://localhost:8080/api/categories
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> fetchAllCategories() {
        return new ResponseEntity<List<CategoryDto>>(categoryService.fetchAllCategories(), HttpStatus.OK);
    }

    // 2. fetch a category
    // http://localhost:8080/api/categories/2
    @GetMapping("/categories/{cid}")
    public ResponseEntity<CategoryDto> fetchCategory(@PathVariable("cid") int categoryId) {
        return new ResponseEntity<CategoryDto>(categoryService.fetchACategory(categoryId), HttpStatus.OK);
    }

    // 3. add a category
    // http://localhost:8080/api/categories
    @PostMapping("/categories")
    public CategoryDto addCategory(@RequestBody @Valid CategoryDto newCategory) {
        return categoryService.addCategory(newCategory);
    }

    // 4. update a category
    // http://localhost:8080/api/categories
    @PutMapping("categories")
    //similar to the Post request, the Put request also has a RequestBody
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody @Valid CategoryDto updateCategory) {
        return new ResponseEntity<>(categoryService.updateCategory(updateCategory), HttpStatus.OK);
    }

    // 5. delete a category
    // http://localhost:8080/api/categories/3
    @DeleteMapping("/categories/{cid}")
    public ResponseEntity<Void> removeLocation(@PathVariable("cid") int categoryId) {
        categoryService.removeCategory(categoryId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

