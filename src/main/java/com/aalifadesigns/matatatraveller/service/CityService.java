package com.aalifadesigns.matatatraveller.service;
import com.aalifadesigns.matatatraveller.model.CityDto;

import java.util.List;

public interface CityService {
    public List<CityDto> fetchAllCities();
    public CityDto fetchACity (int cityId);
}
