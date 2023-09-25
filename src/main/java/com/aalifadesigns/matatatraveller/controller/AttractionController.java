package com.aalifadesigns.matatatraveller.controller;

import com.aalifadesigns.matatatraveller.exception.ApplicationException;
import com.aalifadesigns.matatatraveller.model.AttractionDto;
import com.aalifadesigns.matatatraveller.model.CityDto;
import com.aalifadesigns.matatatraveller.model.ThreadDto;
import com.aalifadesigns.matatatraveller.service.AttractionService;
import com.aalifadesigns.matatatraveller.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class AttractionController {

    private AttractionService attractionService;

    //will also need cityService dependency
    private CityService cityService;

    @Autowired
    public AttractionController(AttractionService attractionService, CityService cityService) {
        this.attractionService = attractionService;
        this.cityService = cityService;
    }

    @Autowired

    // 1. fetch all attractions
    // http://localhost:7474/api/attractions
    @GetMapping("/attractions")
    public ResponseEntity<List<AttractionDto>> fetchAllAttractions() {
        // here ResponseEntity wraps up the response body(1st argument) and the status code(2nd argument)
        ResponseEntity<List<AttractionDto>> responseEntity = new ResponseEntity<List<AttractionDto>>(attractionService.fetchAllAttractions(), HttpStatus.OK);
        //return attractionService.fetchAllAttractions();
        return responseEntity;
    }

    // 2. fetch an attraction
    // http://localhost:7474/api/attractions/1
    // this 1 is called a PathVariable with the name bid and should be extracted and store in a java variable/parameter(attractionId)
    @GetMapping("/attractions/{bid}")
    public ResponseEntity<AttractionDto> fetchAAttraction(@PathVariable("bid") int attractionId) {
        return new ResponseEntity<AttractionDto>(attractionService.fetchAAttraction(attractionId), HttpStatus.OK);
    }

    //3. http://localhost:7474/api/attractions/city/1
    @GetMapping("attractions/city/{cid}")
    public ResponseEntity<List<AttractionDto>> fetchAttractionsByCity(@PathVariable("cid") int cityId) {
        //fetch CityDto using cityService
        CityDto cityDto = cityService.fetchACity(cityId);
        //if the city does not exist throw custom exception referring to DataAccess
        if (cityDto == null) {
            throw new ApplicationException();
        }
        return new ResponseEntity<>(attractionService.fetchAttractionsByCity(cityDto), HttpStatus.OK);
    }


    // 4. add an attraction
    // http://localhost:7474/attractions
    // here the new attraction data to be inserted into the DB is sent along with the request body
    // so what we should do is extract the new attraction data from the request body and store in the java method parmameter(newattraction)
    // this is done with the help of @RequestBody
    @PostMapping("/attractions")
    public ResponseEntity<AttractionDto> addAttraction(@RequestBody AttractionDto newAttraction) {
        return new ResponseEntity<AttractionDto>(attractionService.addAttraction(newAttraction), HttpStatus.OK);
    }

    // 5. update an attraction
    // http://localhost:7474/attractions
    @PutMapping("/attractions")
    public ResponseEntity<AttractionDto> updateBook(@RequestBody AttractionDto updateAttraction) {
        return new ResponseEntity<AttractionDto>(attractionService.updateAttraction(updateAttraction), HttpStatus.OK);
    }

    // 6. delete an attraction
    // http://localhost:7474/api/attractions/1
    @DeleteMapping("/attractions/{bid}")
    public ResponseEntity<Void> removeAttraction(@PathVariable("bid") int attractionId) {
        attractionService.removeAttraction(attractionId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}

