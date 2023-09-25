package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.AttractionDao;
import com.aalifadesigns.matatatraveller.dao.entities.AttractionEntity;
import com.aalifadesigns.matatatraveller.dao.entities.CityEntity;
import com.aalifadesigns.matatatraveller.dao.entities.ThreadEntity;
import com.aalifadesigns.matatatraveller.exception.ApplicationException;
import com.aalifadesigns.matatatraveller.model.AttractionDto;
import com.aalifadesigns.matatatraveller.model.CategoryDto;
import com.aalifadesigns.matatatraveller.model.CityDto;
import com.aalifadesigns.matatatraveller.model.ThreadDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttractionServiceImpl implements AttractionService {

    AttractionDao attractionDao;
    private CityService cityService; // service to service operation needed to fetch attractions by city

    @Autowired
    public AttractionServiceImpl(AttractionDao attractionDao, CityService cityService) {
        this.attractionDao = attractionDao;
        this.cityService = cityService;
    }


    @Override
    public List<AttractionDto> fetchAllAttractions() {
        /*    This method fetches a list of attractions and their associated cities from a data source.
          It then converts the data into a list of attraction DTOs, which include information about
        the attraction and its associated city.*/


        List<AttractionEntity> allAttractionEntity = attractionDao.findAll();
        // we can't return a collection of AttractionEntity, we have to return a collection of AttractionDto
        // so we have to iterate through the collection of AttractionEntity and copy them into a collection of AttractionDto
        List<AttractionDto> allAttractionDto = new ArrayList<AttractionDto>();
        for (AttractionEntity eachAttractionEntity : allAttractionEntity) {
            // now copy eachAttractionEntity into an AttractionDto object
            AttractionDto eachAttractionDto = new AttractionDto();
            BeanUtils.copyProperties(eachAttractionEntity, eachAttractionDto);

            // copy the collection of city entity(inside eachAttractionEntity) into a collection of city dto
            List<CityDto> allCitiesDto = new ArrayList<CityDto>();
            CityDto eachCityDto = new CityDto();
            BeanUtils.copyProperties(eachAttractionEntity.getCityEntity(), eachCityDto);

            // Set the city composite property
            eachAttractionDto.setCityDto(eachCityDto);

            allAttractionDto.add(eachAttractionDto);
        }
        return allAttractionDto;
    }

    @Override
    public AttractionDto fetchAAttraction(int attractionId) {
        // Attempt to find an AttractionEntity by its unique ID.
        Optional<AttractionEntity> optionalAttractionEntity = attractionDao.findById(attractionId);

        AttractionDto attractionDto = null;

        // Check if the optionalAttractionEntity contains data (i.e., an AttractionEntity was found).
        if (optionalAttractionEntity.isPresent()) {
            attractionDto = new AttractionDto();
            CityDto cityDto = new CityDto();

            // Copy properties from the optionalAttractionEntity to the attractionDto.
            BeanUtils.copyProperties(optionalAttractionEntity, attractionDto);

            // Copy properties from the optionalAttractionEntity's data (AttractionEntity) to the attractionDto.
            BeanUtils.copyProperties(optionalAttractionEntity.get(), attractionDto);

            // Copy properties from the optionalAttractionEntity's associated city entity to the cityDto.
            BeanUtils.copyProperties(optionalAttractionEntity.get().getCityEntity(), cityDto);

            // Set the cityDto as a composite property within the attractionDto.
            attractionDto.setCityDto(cityDto);

            return attractionDto;
        }
        return null;
    }

    @Override
    public AttractionDto addAttraction(AttractionDto newAttraction) {
        // copying entity into dto
        AttractionEntity attractionEntity = new AttractionEntity();
        BeanUtils.copyProperties(newAttraction, attractionEntity);
        CityEntity cityEntity = new CityEntity();
        // copying the composition also
        BeanUtils.copyProperties(newAttraction.getCityDto(), cityEntity);
        attractionEntity.setCityEntity(cityEntity);

        attractionDao.saveAndFlush(attractionEntity);

        newAttraction.setAttractionId(attractionEntity.getAttractionId());
        return newAttraction;
    }

    @Override
    public AttractionDto updateAttraction(AttractionDto updateAttraction) {
        return null;
    }

    @Override
    public void removeAttraction(int attractionId) {
        attractionDao.deleteById(attractionId);
    }

    @Override
    public List<AttractionDto> fetchByCity(int cityId) {

        //fetch CityDto using cityService
        CityDto cityDto = cityService.fetchACity(cityId);

        //if the city does not exist, throw custom exception referring to DataAccess
        if (cityDto == null) {
            throw new ApplicationException();
        }

        //copy the CityDto into a city entity
        CityEntity cityEntity = new CityEntity();
        BeanUtils.copyProperties(cityDto, cityEntity);

        //call the finder method declared in the AttractionDao
        List<AttractionEntity> allAttractionEntity = attractionDao.findByCityEntity(cityEntity);

        //the AttractionEntity collection needs be copied into a DTO collection
        List<AttractionDto> allAttractionDto = new ArrayList<AttractionDto>();

        // traverse the collection and copy each entity into a AttractionDto object
        allAttractionEntity.forEach(eachAttractionEntity -> {
            AttractionDto eachAttractionDto = new AttractionDto();
            BeanUtils.copyProperties(eachAttractionEntity, eachAttractionDto);

            // add each AttractionDto object to the collection of AttractionDto
            allAttractionDto.add(eachAttractionDto);
        });
        //return the collection
        return allAttractionDto;
    }
}
