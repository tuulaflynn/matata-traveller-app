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

        //wrap the response body returned by fetchAllCities into a new ResponseEntity of type of List<CityDto>
        return new ResponseEntity<List<CityDto>>(cityService.fetchAllCities(), HttpStatus.OK);
    }

    // 2. fetch a city
    // http://localhost:7474/api/cities/2
    @GetMapping("/cities/{cid}")
    public ResponseEntity<CityDto> fetchCity(@PathVariable("cid") int cityId) {

        // PathVariable cid will be extracted and stored in a java variable/parameter(cityId)
        //which will be passed as arg for fetchACity(), which will return a CityDto object in the Response Body , wrapped by the ResponseEntity
        return new ResponseEntity<CityDto>(cityService.fetchACity(cityId), HttpStatus.OK);
    }

}




