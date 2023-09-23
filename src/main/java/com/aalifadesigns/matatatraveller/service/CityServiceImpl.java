package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.CityDao;
import com.aalifadesigns.matatatraveller.model.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public CityDto fetchACategory(int cityId) {
        return null;
    }
}
