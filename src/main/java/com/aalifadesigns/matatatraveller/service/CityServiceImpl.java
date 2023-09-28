package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.CityDao;
import com.aalifadesigns.matatatraveller.dao.entities.AttractionEntity;
import com.aalifadesigns.matatatraveller.dao.entities.CityEntity;
import com.aalifadesigns.matatatraveller.dao.entities.ThreadEntity;
import com.aalifadesigns.matatatraveller.exception.InvalidIdException;
import com.aalifadesigns.matatatraveller.model.AttractionDto;
import com.aalifadesigns.matatatraveller.model.CityDto;
import com.aalifadesigns.matatatraveller.model.ThreadDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service //required Spring Annotation -- stereotype
public class CityServiceImpl implements CityService {

    CityDao cityDao;

    @Autowired //constructor Dependency Injection
    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<CityDto> fetchAllCities() {

        //call findAll(), which returns a collection of entities
        List<CityEntity> allCityEntity = cityDao.findAll();

        //copy the entities into CityDto objects and store them in a collection(which the method will return)
        List<CityDto> allCityDto = new ArrayList<CityDto>();

        //traverse the collection, using a forEach loop
        allCityEntity.forEach((eachCityEntity) -> {
            //copy each entity into a CityDto, using BeansUtil (copyProperties)
            CityDto eachCityDto = new CityDto();
            BeanUtils.copyProperties(eachCityEntity, eachCityDto);

            //copy (get) the threads collection, traverse the collection,
            //copy each entity into a Dto object, and form a collection of ThreadDto, to be set in the CityDto
            List<ThreadDto> allThreadDto = new ArrayList<ThreadDto>();
            for (ThreadEntity eachThreadEntity : eachCityEntity.getAllThreads()) {
                ThreadDto eachThreadDto = new ThreadDto();
                //copy each ThreadEntity inti ThreadDto object
                BeanUtils.copyProperties(eachThreadEntity, eachThreadDto);
                //add the ThreadDto to the collection
                allThreadDto.add(eachThreadDto);
            }

            //set the ThreadDto collection inside CityDto
            eachCityDto.setAllThreads(allThreadDto);

            //similarly, include the collection of Attractions
            List<AttractionDto> allAttractionDto = new ArrayList<AttractionDto>();
            for (AttractionEntity eachAttractionEntity : eachCityEntity.getAllAttractions()) {
                AttractionDto eachAttractionDto = new AttractionDto();

                //copy each AttractionEntity into a AttractionDto object
                BeanUtils.copyProperties(eachAttractionEntity, eachAttractionDto);

                //add the DTO to the collection
                allAttractionDto.add(eachAttractionDto);
            }

            //set the ThreadDto collection inside CityDto
            eachCityDto.setAllAttractions(allAttractionDto);

            //add the CityDto to the collection (containing now also the Threads and Attraction collections too)
            allCityDto.add(eachCityDto);
        });

        //return the dto collection
        return allCityDto;
    }

    @Override
    public CityDto fetchACity(int cityId) {

        //call findById(), which returns an Optional<Entity> type
        Optional<CityEntity> optionalCityEntity = cityDao.findById(cityId);

        // if optionalCityEntity has data, copy the entity to a corresponding CityDTO object
        CityDto cityDto = null;
        if (optionalCityEntity.isPresent()) {
            cityDto = new CityDto();
            BeanUtils.copyProperties(optionalCityEntity.get(), cityDto);

            //copy the threads collection, and form a collection of ThreadDto, to be set in the CityDto
            List<ThreadDto> allThreadDto = new ArrayList<ThreadDto>();
            // traverse the collection,
            for (ThreadEntity eachThreadEntity : optionalCityEntity.get().getAllThreads()) {
                ThreadDto eachThreadDto = new ThreadDto();
                //copy each ThreadEntity into a ThreadDto object
                BeanUtils.copyProperties(eachThreadEntity, eachThreadDto);
                //add the ThreadDto to the collection
                allThreadDto.add(eachThreadDto);

            }
            //set the ThreadDto collection inside cityDto object
            cityDto.setAllThreads(allThreadDto);

            //similarly, include the collection of Attractions
            List<AttractionDto> allAttractionDto = new ArrayList<AttractionDto>();
            for (AttractionEntity eachAttractionEntity : optionalCityEntity.get().getAllAttractions()) {
                AttractionDto eachAttractionDto = new AttractionDto();
                //copy each AttractionEntity into a AttractionDto object
                BeanUtils.copyProperties(eachAttractionEntity, eachAttractionDto);
                //add the DTO to the collection
                allAttractionDto.add(eachAttractionDto);
            }

            //set the AttractionDto collection inside cityDto object
            cityDto.setAllAttractions(allAttractionDto);
        }

        //inform the user the record does not exist the database
        else {
            throw new InvalidIdException();
        }
        return cityDto;
    }
}
