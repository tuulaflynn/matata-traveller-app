package com.aalifadesigns.matatatraveller.controller;

import com.aalifadesigns.matatatraveller.model.CityDto;
import com.aalifadesigns.matatatraveller.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class CityController {
    CityService cityService;

    @Autowired //Constructor Dependency Injection
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    // 1. fetch all cities
    // http://localhost:8080/api/cities
    @GetMapping("/cities")
    public ResponseEntity<List<CityDto>> fetchAllCities() {
        return new ResponseEntity<List<CityDto>>(cityService.fetchAllCities(), HttpStatus.OK);
    }

    // 2. fetch a city
    // http://localhost:7474/api/cities/2
    @GetMapping("/cities/{cid}")
    public ResponseEntity<CityDto> fetchCity(@PathVariable("cid") int cityId) {
        return new ResponseEntity<CityDto>(cityService.fetchACity(cityId), HttpStatus.OK);
    }

}




