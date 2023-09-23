package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.AttractionDao;
import com.aalifadesigns.matatatraveller.dao.entities.AttractionEntity;
import com.aalifadesigns.matatatraveller.dao.entities.CityEntity;
import com.aalifadesigns.matatatraveller.model.AttractionDto;
import com.aalifadesigns.matatatraveller.model.CityDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttractionServiceImpl implements AttractionService{

    AttractionDao attractionDao;

    public AttractionServiceImpl(AttractionDao attractionDao) {
        this.attractionDao = attractionDao;
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
        for(AttractionEntity eachAttractionEntity: allAttractionEntity) {
            // now copy eachAttractionEntity into an AttractionDto object
            AttractionDto eachAttractionDto = new AttractionDto();
            BeanUtils.copyProperties(eachAttractionEntity, eachAttractionDto);

            // copy the collection of city entity(inside eachAttractionEntity) into a collection of city dto
            List<CityDto> allCitiesDto = new ArrayList<CityDto>();
            CityDto eachCityDto = new CityDto();
            BeanUtils.copyProperties(eachAttractionEntity.getCityEntity(),eachCityDto) ;

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
}
