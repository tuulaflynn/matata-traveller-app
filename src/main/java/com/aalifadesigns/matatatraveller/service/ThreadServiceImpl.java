package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.ThreadDao;
import com.aalifadesigns.matatatraveller.dao.entities.CategoryEntity;
import com.aalifadesigns.matatatraveller.dao.entities.CityEntity;
import com.aalifadesigns.matatatraveller.dao.entities.ThreadEntity;
import com.aalifadesigns.matatatraveller.model.CategoryDto;
import com.aalifadesigns.matatatraveller.model.CityDto;
import com.aalifadesigns.matatatraveller.model.ThreadDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ThreadServiceImpl implements ThreadService {

    private ThreadDao threadDao;

    @Autowired
    public ThreadServiceImpl(ThreadDao threadDao) {
        this.threadDao = threadDao;
    }

    @Override
    public List<ThreadDto> fetchAllThreads() {
        // Collection to store all the records (which are each in the form of ThreadEtity objects) fetched from the database.
        List<ThreadEntity> allThreadsEntity = threadDao.findAll();
        // Collection of records (which have been stored in Dto objects) to be sent to the controller layer.
        List<ThreadDto> allThreadsDto = new ArrayList<ThreadDto>();

        // Transferring each record from an entity to a dto (including copying the record's composite entity).
        allThreadsEntity.forEach(eachThreadEntity -> {
            ThreadDto eachThreadDto = new ThreadDto();
            // For the composite entity inside the thread entity
            CityDto eachCityDto = new CityDto();
            List<CategoryDto> eachCategoryDtoList = new ArrayList<>();

            // Copy over everything
            BeanUtils.copyProperties(eachThreadEntity, eachThreadDto);
            // Copy over the city composite property
            BeanUtils.copyProperties(eachThreadEntity.getCityEntity(), eachCityDto);
            // Set the city composite property
            eachThreadDto.setCityDto(eachCityDto);
            // Copy over the composite categoryEntities (there may be more than one so we need to do this in a loop)
            eachThreadEntity.getAllCategoriesEntity().forEach(eachCategoryEntity -> {
                CategoryDto eachCategoryDto = new CategoryDto();
                BeanUtils.copyProperties(eachCategoryEntity, eachCategoryDto);
                eachCategoryDtoList.add(eachCategoryDto);
            });
            // Set the categories composite property which is a list of categoryDto
            eachThreadDto.setAllCategoriesDto(eachCategoryDtoList);

            // Add the dto to the collection allThreadsDto
            allThreadsDto.add(eachThreadDto);
        });
        return allThreadsDto;
    }

    @Override
    public ThreadDto fetchAThread(int threadId) {
        // Store the entity returned by the id search in an optional for if id is invalid it is able to hold the value null.
        Optional<ThreadEntity> threadEntityOptional = threadDao.findById(threadId);
        // Store the record, if it exists, in a dto object with its composite entities copied in
        ThreadDto threadDto = new ThreadDto();
        if (threadEntityOptional.isPresent()) {
            CityDto cityDto = new CityDto();        // this is for the composite entity inside the thread entity
            List<CategoryDto> categoryDtoList = new ArrayList<>();

            BeanUtils.copyProperties(threadEntityOptional.get(), threadDto);
            BeanUtils.copyProperties(threadEntityOptional.get().getCityEntity(), cityDto);
            threadDto.setCityDto(cityDto);          // set the composite property

            // Copy over the composite categoryEntities (there may be more than one so we need to do this in a loop)
            threadEntityOptional.get().getAllCategoriesEntity().forEach(eachCategoryEntity -> {
                CategoryDto eachCategoryDto = new CategoryDto();
                BeanUtils.copyProperties(eachCategoryEntity, eachCategoryDto);
                categoryDtoList.add(eachCategoryDto);
            });
            // Set the categories composite property which is a list of categoryDto
            threadDto.setAllCategoriesDto(categoryDtoList);

            return threadDto;
        }
        return null;
    }

    @Override
    public ThreadDto addThread(ThreadDto newThreadDto) {
        // Copy dto into an entity
        ThreadEntity newThreadEntity = new ThreadEntity();
        CityEntity newCityEntity = new CityEntity();
        List<CategoryEntity> categoryEntityList = new ArrayList<>();

        BeanUtils.copyProperties(newThreadDto, newThreadEntity);
        // Copy in the city composite entity too
        BeanUtils.copyProperties(newThreadDto.getCityDto(),newCityEntity);
        newThreadEntity.setCityEntity(newCityEntity);
        // Copy into a list of category entities
        newThreadDto.getAllCategoriesDto().forEach(eachCategoryDao -> {
            CategoryEntity eachCategoryEntity = new CategoryEntity();
            BeanUtils.copyProperties(eachCategoryDao, eachCategoryEntity);
            categoryEntityList.add(eachCategoryEntity);
        });
        // Set the list of categories entities to the newThreadEntity object
        newThreadEntity.setAllCategoriesEntity(categoryEntityList);

        // Add the entity to the database. N.B. if the primary key is not unique, it will update the existing record with this entity
        threadDao.saveAndFlush(newThreadEntity);
        newThreadDto.setThreadId(newThreadEntity.getThreadId());
        return newThreadDto;
    }

    @Override
    public List<ThreadDto> fetchByThreadDate(LocalDate threadDate) {
        // Store the entities returned by the date search in a list of ThreadEntity objects.
        // This list will be empty if there are no threads on the date 'threadDate'
        List<ThreadEntity> allThreadsEntity = threadDao.findByThreadDate(threadDate);
        // Collection of records (which have been stored in Dto objects) to be sent to the controller layer.
        List<ThreadDto> allThreadsDto = new ArrayList<ThreadDto>();

        // Transferring each record from an entity to a dto (including copying the record's composite entity).
        allThreadsEntity.forEach(eachThreadEntity -> {
            ThreadDto eachThreadDto = new ThreadDto();
            CityDto eachCityDto = new CityDto();        // this is for the composite entity inside the thread entity
            List<CategoryDto> eachCategoryDtoList = new ArrayList<>();

            // Copy over everything
            BeanUtils.copyProperties(eachThreadEntity, eachThreadDto);
            // Copy over the city composite property
            BeanUtils.copyProperties(eachThreadEntity.getCityEntity(), eachCityDto);
            // Set the composite property
            eachThreadDto.setCityDto(eachCityDto);
            // Copy over and set the composite category list
            eachThreadEntity.getAllCategoriesEntity().forEach(eachCategoryEntity -> {
                CategoryDto eachCategoryDto = new CategoryDto();
                BeanUtils.copyProperties(eachCategoryEntity, eachCategoryDto);
                eachCategoryDtoList.add(eachCategoryDto);
            });
            // Set the categories composite property which is a list of categoryDto
            eachThreadDto.setAllCategoriesDto(eachCategoryDtoList);

            // Add the dto to the collection allThreadsDto
            allThreadsDto.add(eachThreadDto);
        });
        return allThreadsDto;
    }

    @Override
    public ThreadDto updateThread(ThreadDto updateThreadDto) {
        ThreadEntity updateThreadEntity = new ThreadEntity();
        CityEntity updateCityEntity = new CityEntity();
        List<CategoryEntity> updateCategoryEntityList = new ArrayList<>();

        BeanUtils.copyProperties(updateThreadDto, updateThreadEntity);
        // Copy and set the city composite entity too
        BeanUtils.copyProperties(updateThreadDto.getCityDto(),updateCityEntity);
        updateThreadEntity.setCityEntity(updateCityEntity);
        // Copy and set the category list from the entity to the dao
        updateThreadDto.getAllCategoriesDto().forEach(eachCategoryDao -> {
            CategoryEntity eachCategoryEntity = new CategoryEntity();
            BeanUtils.copyProperties(eachCategoryDao, eachCategoryEntity);
            updateCategoryEntityList.add(eachCategoryEntity);
        });
        // Set the list of categories entities to the updateThreadEntity object
        updateThreadEntity.setAllCategoriesEntity(updateCategoryEntityList);

        // update the entity in the database. N.B. if the primary key is unique, it will add a new record with this entity
        threadDao.saveAndFlush(updateThreadEntity);
        updateThreadDto.setThreadId(updateThreadEntity.getThreadId());
        return updateThreadDto;
    }

    @Override
    public void deleteThread(int threadId) {
        Optional<ThreadEntity> deleteThreadEntityOptional = threadDao.findById(threadId);
        if (deleteThreadEntityOptional.isPresent()) {
            threadDao.deleteById(threadId);
        }
        else {
            // EDIT: add a custom exception here.
            System.out.println("Error. Invalid thread id.");
        }
    }
}
