package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.ThreadDao;
import com.aalifadesigns.matatatraveller.dao.entities.ThreadEntity;
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
            CityDto eachCityDto = new CityDto();        // this is for the composite entity inside the thread entity
            // Copy over everything
            BeanUtils.copyProperties(eachThreadEntity, eachThreadDto);
            // Copy over the composite property
            BeanUtils.copyProperties(eachThreadEntity.getCityEntity(), eachCityDto);
            // Set the composite property
            eachThreadDto.setCityDto(eachCityDto);
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
            BeanUtils.copyProperties(threadEntityOptional.get(), threadDto);
            BeanUtils.copyProperties(threadEntityOptional.get().getCityEntity(), cityDto);
            threadDto.setCityDto(cityDto);          // set the composite property

            return threadDto;
        }
        return null;
    }

    @Override
    public ThreadDto addThread(ThreadDto newThreadDto) {

        return null;
    }

    @Override
    public List<ThreadDto> fetchByThreadDate(LocalDate threadDate) {
        return null;
    }

    @Override
    public List<ThreadDto> fetchByCategoryId(int categoryId) {
        return null;
    }

    @Override
    public List<ThreadDto> fetchByCityId(int cityId) {
        return null;
    }

    @Override
    public ThreadDto updateThread(ThreadDto updateThreadDto) {
        return null;
    }

    @Override
    public void deleteThread(int threadId) {

    }
}
