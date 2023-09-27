package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.CategoryDao;
import com.aalifadesigns.matatatraveller.dao.entities.CategoryEntity;
import com.aalifadesigns.matatatraveller.dao.entities.ThreadEntity;
import com.aalifadesigns.matatatraveller.exception.EntityAlreadyExistsException;
import com.aalifadesigns.matatatraveller.exception.InvalidIdException;
import com.aalifadesigns.matatatraveller.exception.UpdateCategoryException;
import com.aalifadesigns.matatatraveller.model.CategoryDto;
import com.aalifadesigns.matatatraveller.model.CityDto;
import com.aalifadesigns.matatatraveller.model.ThreadDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //required Spring Annotation -- stereotype
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

            //set the ThreadDto collection inside CategoryDto
            eachCategoryDto.setAllThreads(allThreadDto);

            //add each CategoryDto object (containing now also the Threads collection) to the collection
            allCategoryDto.add(eachCategoryDto);
        });

        return allCategoryDto;
    }

    @Override
    public CategoryDto fetchACategory(int categoryId) {
        //call findById(), which returns an Optional<Entity> type
        Optional<CategoryEntity> optionalCategoryEntity = categoryDao.findById(categoryId);
        // if data exists, copy the entity to a corresponding CategoryDTO object
        CategoryDto categoryDto = null;
        if (optionalCategoryEntity.isPresent()) {
            categoryDto = new CategoryDto();
            BeanUtils.copyProperties(optionalCategoryEntity.get(), categoryDto);

            //copy also the collection of threads (many-to-many mapped relationships)
            //traverse the collection,copy each entity into a Dto object, and form a collection of ThreadDto to be set in each CategoryDto
            List<ThreadDto> allThreadDto = new ArrayList<ThreadDto>();
            for (ThreadEntity eachThreadEntity : optionalCategoryEntity.get().getAllThreads()) {
                ThreadDto eachThreadDto = new ThreadDto();
                //copy each ThreadEntity inti ThreadDto object
                BeanUtils.copyProperties(eachThreadEntity, eachThreadDto);

                //also copy the City object of each thread
                CityDto cityDto = new CityDto();
                BeanUtils.copyProperties(eachThreadEntity.getCityEntity(), cityDto);
                //set cityDto
                eachThreadDto.setCityDto(cityDto);

                //add the ThreadDto (containing also the CityDto) to the collection
                allThreadDto.add(eachThreadDto);

            }
            //set the ThreadDto collection inside categoryDto object
            categoryDto.setAllThreads(allThreadDto);
        }
        //if the category does not exist throw exception and inform the user
        else {
            throw new InvalidIdException();
        }
        return categoryDto;
    }

    @Override
    public CategoryDto addCategory(CategoryDto newCategory) {

        //copy the CategoryDto object into an entity
        CategoryEntity newCategoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(newCategory, newCategoryEntity);

        //since saveAndFlush is valid for both add and update operations
        //if the id PK already exist, do not overwrite (update), instead throw custom exception to let the user know the entity already exists
        if (categoryDao.existsById(newCategoryEntity.getCategoryId())) {
            throw new EntityAlreadyExistsException();
        }

        // if the Id is new, go ahead and create new entity
        CategoryEntity savedCategoryEntity = categoryDao.saveAndFlush(newCategoryEntity);

        // set the type id in the new dto object
        newCategory.setCategoryId(savedCategoryEntity.getCategoryId());

        //return the Dto (now containing the Id)
        return newCategory;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto updateCategory) {

        //first, check whether the id associated with the object exists
        //if the id(PK) does not exist, throw exception (as using saveAndFlush will create a new entry instead of updating)
        if (!categoryDao.existsById(updateCategory.getCategoryId())) {
            throw new InvalidIdException();
        }

        // if the Id exists, proceed with ubdating this record
        //copy the CategoryDto object into an entity
        CategoryEntity updateCategoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(updateCategory, updateCategoryEntity);

        //also copy the Threads collection inside each category
        List<ThreadEntity> updateAllThreadEntity = new ArrayList<>();
        //traverse the Threads collection, copy each ThreadDto into An Entity object, and add it to the updateAllThreadEntity collection
        try { // error can occur if the user tries to update the category without specifying the threads too
            updateCategory.getAllThreads().forEach(eachThreadDto -> {
                ThreadEntity eachThreadEntity = new ThreadEntity();
                BeanUtils.copyProperties(eachThreadDto, eachThreadEntity);
                updateAllThreadEntity.add(eachThreadEntity);
            });
            //updateCategoryEntity - set collection of Threads entities
            updateCategoryEntity.setAllThreads(updateAllThreadEntity);

            //make use of saneAndFlush in-built method
            CategoryEntity savedCategoryEntity = categoryDao.saveAndFlush(updateCategoryEntity);
        }
        // if the user tries to update the category without specifying the threads' IDs,
        // catch NullPointerException and rethrow it as custom exception
        catch (NullPointerException exception) {
            throw new UpdateCategoryException();
        }
        //return the Dto
        return updateCategory;
    }

    @Override
    public void removeCategory(int categoryId) {

        /* this has been commented as the 2-step process of verifying the item exists and then remove it should take place on the front end

        //if Id exists, remove the entity object with that PK
        if (categoryDao.existsById(categoryId)) {
            categoryDao.deleteById(categoryId);
        }
        //else throw exception, informing the user there is no such category
        else {
            throw new InvalidIdException();
        }
        */
        categoryDao.deleteById(categoryId);
    }
}
