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

    @Autowired // Constructor Dependency Injection
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // 1. fetch all categories
    // http://localhost:8080/api/categories
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> fetchAllCategories() {
        //wrap the response body when calling fetchAllCategories into a ResponseEntity, adding the http status as 2nd arg
        return new ResponseEntity<List<CategoryDto>>(categoryService.fetchAllCategories(), HttpStatus.OK);
    }

    // 2. fetch a category
    // http://localhost:8080/api/categories/2
    @GetMapping("/categories/{cid}")
    //PathVariable with the name cid should be extracted and stored in a java variable(cityId)
    //and pass as parameter when fetching the method fetchACategory
    public ResponseEntity<CategoryDto> fetchCategory(@PathVariable("cid") int categoryId) {
        return new ResponseEntity<CategoryDto>(categoryService.fetchACategory(categoryId), HttpStatus.OK);
    }

    // 3. add a category
    // http://localhost:8080/api/categories
    @PostMapping("/categories")
    //there will be a @RequestBody to send together with the POST request,
    // (the ObjectDto which will correspond to the entity we want to add to the database)
    public CategoryDto addCategory(@RequestBody CategoryDto newCategory) {
        return categoryService.addCategory(newCategory);
    }

    // 4. update a category
    // http://localhost:8080/api/categories
    @PutMapping("categories")
    //similar to the Post request, the Put request also has a RequestBody
    //if we don't want to update all attributes, we can only add the ones we want to change
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto updateCategory) {
        return new ResponseEntity<>(categoryService.updateCategory(updateCategory), HttpStatus.OK);
    }

    // 5. delete a category
    // http://localhost:8080/api/categories/3
    @DeleteMapping("/categories/{cid}")
    public ResponseEntity<Void> removeLocation(@PathVariable("cid") int categoryId) {
        //PathVariable with the name cid is extracted and stored in a java variable(categoryId)
        //since the method is not returning anything the ResponseEntity's first arg is set to Void
        categoryService.removeCategory(categoryId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

