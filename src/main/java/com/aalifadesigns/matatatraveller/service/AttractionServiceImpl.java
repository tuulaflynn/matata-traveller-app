package com.aalifadesigns.matatatraveller.service;
import com.aalifadesigns.matatatraveller.dao.AttractionDao;
import com.aalifadesigns.matatatraveller.dao.entities.AttractionEntity;
import com.aalifadesigns.matatatraveller.dao.entities.CityEntity;
import com.aalifadesigns.matatatraveller.exception.InvalidIdException;
import com.aalifadesigns.matatatraveller.model.AttractionDto;
import com.aalifadesigns.matatatraveller.model.CityDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttractionServiceImpl implements AttractionService {

    private AttractionDao attractionDao;
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

            // copy the city entity (inside each AttractionEntity) into a city dto
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

            // Copy properties from the optionalAttractionEntity's data (AttractionEntity) to the attractionDto.
            BeanUtils.copyProperties(optionalAttractionEntity.get(), attractionDto);

            // Copy properties from the optionalAttractionEntity's associated city entity to the cityDto.
            BeanUtils.copyProperties(optionalAttractionEntity.get().getCityEntity(), cityDto);

            // Set the cityDto as a composite property within the attractionDto.
            attractionDto.setCityDto(cityDto);

            return attractionDto;
        } else {
            throw new InvalidIdException();
        }

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
    public AttractionDto updateAttraction(AttractionDto updateAttractionDto) {
        // Create new AttractionEntity and CityEntity instances
        AttractionEntity updateAttractionEntity = new AttractionEntity();
        CityEntity updateCityEntity = new CityEntity();

        // Check if the attraction with the given ID exists in the database
        if (!attractionDao.existsById(updateAttractionDto.getAttractionId())) {
            // If not, throw an InvalidIdException
            throw new InvalidIdException();
        }

        //Copy properties from the updateAttractionDto to updateAttractionEntity
        BeanUtils.copyProperties(updateAttractionDto, updateAttractionEntity);
        //Copy properties from the updateAttractionDto's CityDto to updateCityEntity
        BeanUtils.copyProperties(updateAttractionDto.getCityDto(), updateCityEntity);
        //Set the CityEntity in the updateAttractionEntity
        updateAttractionEntity.setCityEntity(updateCityEntity);


        // Save and flush the updated AttractionEntity to the database
        // N.B. if the primary key exists in the database, its record will be updated. If PK doesn't exist in the
        // database (the if structure flow at the start prevents this case) a new record i added.
        attractionDao.saveAndFlush(updateAttractionEntity);

        // Update the attraction ID in the updateAttractionDto
        updateAttractionDto.setAttractionId(updateAttractionEntity.getAttractionId());

        // Return the updated AttractionDto
        return updateAttractionDto;
    }

    @Override
    public void removeAttraction(int attractionId) {
        // Attempt to find the AttractionEntity by its ID in the database
        Optional<AttractionEntity> deleteAttractionEntityOptional = attractionDao.findById(attractionId);
        // Check if the AttractionEntity with the given ID exists
       if (deleteAttractionEntityOptional.isPresent()){
           // If it exists, delete the AttractionEntity from the database
           attractionDao.deleteById(attractionId);
       } else {
           // If the AttractionEntity does not exist, throw an InvalidIdException
           throw new InvalidIdException();
       }
    }

    @Override
    public List<AttractionDto> fetchByCity(int cityId) {

        // fetch CityDto using cityService
        CityDto cityDto = cityService.fetchACity(cityId);

        // if the city does not exist, throw custom exception referring to DataAccess
        if (cityDto == null) {
            throw new InvalidIdException();
        }

        // copy the CityDto into a city entity
        CityEntity cityEntity = new CityEntity();
        BeanUtils.copyProperties(cityDto, cityEntity);

        // call the finder method declared in the AttractionDao
        List<AttractionEntity> allAttractionEntity = attractionDao.findByCityEntity(cityEntity);

        // the AttractionEntity collection needs be copied into a DTO collection
        List<AttractionDto> allAttractionDto = new ArrayList<AttractionDto>();

        // traverse the collection and copy each entity into a AttractionDto object
        allAttractionEntity.forEach(eachAttractionEntity -> {
            AttractionDto eachAttractionDto = new AttractionDto();
            BeanUtils.copyProperties(eachAttractionEntity, eachAttractionDto);

            // add each AttractionDto object to the collection of AttractionDto
            allAttractionDto.add(eachAttractionDto);
        });
        // return the collection
        return allAttractionDto;
    }
}
