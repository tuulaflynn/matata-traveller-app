package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.CityDao;
import com.aalifadesigns.matatatraveller.dao.entities.AttractionEntity;
import com.aalifadesigns.matatatraveller.dao.entities.CityEntity;
import com.aalifadesigns.matatatraveller.dao.entities.ThreadEntity;
import com.aalifadesigns.matatatraveller.model.AttractionDto;
import com.aalifadesigns.matatatraveller.model.CityDto;
import com.aalifadesigns.matatatraveller.model.ThreadDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CityServiceImpl implements CityService{

    CityDao cityDao;

    @Autowired //constructor Dependency Injection
    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<CityDto> fetchAllCities() {

        //call findAll(), which will return a collection of entities (CityEntity)
        List<CityEntity> allCityEntity= cityDao.findAll();

        //copy the entities into CityDto objects and store them in a collection(which the method will return)
        List <CityDto> allCityDto = new ArrayList<CityDto>();

        //traverse the collection, using a forEach loop
        allCityEntity.forEach((eachCityEntity) -> {
            //copy each entity into a CityDto, using BeansUtil (copyProperties)
            CityDto eachCityDto = new CityDto();
            BeanUtils.copyProperties(eachCityEntity,eachCityDto);

            //however, this will not copy also the lists of threads and attractions (many-to-many mapped relationships)

            //copy (get) the threads collection, traverse the collection,
            //copy each entity into a Dto object, and form a collection of ThreadDto, to be set in the CityDto
            List<ThreadDto> allThreadDto = new ArrayList<ThreadDto>();
            for (ThreadEntity eachThreadEntity: eachCityEntity.getAllThreads()){
                ThreadDto eachThreadDto = new ThreadDto();
                //copy each ThreadEntity inti ThreadDto object
                BeanUtils.copyProperties(eachThreadEntity,eachThreadDto);
                //add the ThreadDto to the collection
                allThreadDto.add(eachThreadDto);
            }

            //set the ThreadDto collection inside CityDto
            eachCityDto.setAllThreads(allThreadDto);

            //similarly, include the collection of Attractions
            //traverse the collection, copy each entity into a Dto object, and form a collection of AttractionDto, to be set in the CityDto
            List<AttractionDto> allAttractionDto = new ArrayList<AttractionDto>();
            for (AttractionEntity eachAttractionEntity: eachCityEntity.getAllAttractions()){
                AttractionDto eachAttractionDto = new AttractionDto();
                //copy each AttractionEntity into a AttractionDto object
                BeanUtils.copyProperties(eachAttractionEntity,eachAttractionDto);
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
    public CityDto fetchACategory(int cityId) {
        return null;
    }
}
