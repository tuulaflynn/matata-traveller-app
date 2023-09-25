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

    @Autowired
    public AttractionController(AttractionService attractionService, CityService cityService) {
        this.attractionService = attractionService;
    }


    // 1. fetch all attractions
    // http://localhost:8080/api/attractions
    @GetMapping("/attractions")
    public ResponseEntity<List<AttractionDto>> fetchAllAttractions() {
        // here ResponseEntity wraps up the response body(1st argument) and the status code(2nd argument)
        ResponseEntity<List<AttractionDto>> responseEntity = new ResponseEntity<List<AttractionDto>>(attractionService.fetchAllAttractions(), HttpStatus.OK);
        //return attractionService.fetchAllAttractions();
        return responseEntity;
    }

    // 2. fetch an attraction
    // http://localhost:8080/api/attractions/1
    // this 1 is called a PathVariable with the name bid and should be extracted and store in a java variable/parameter(attractionId)
    @GetMapping("/attractions/{bid}")
    public ResponseEntity<AttractionDto> fetchAAttraction(@PathVariable("bid") int attractionId) {
        return new ResponseEntity<AttractionDto>(attractionService.fetchAAttraction(attractionId), HttpStatus.OK);
    }


    // 3. add a attraction
    // http://localhost:8080/attractions
    // here the new attraction data to be inserted into the DB is sent along with the request body
    // so what we should do is extract the new attraction data from the request body and store in the java method parmameter(newattraction)
    // this is done with the help of @RequestBody
    @PostMapping("/attractions")
    public ResponseEntity<AttractionDto> addAttraction(@RequestBody AttractionDto newAttraction) {
        return new ResponseEntity<AttractionDto>(attractionService.addAttraction(newAttraction), HttpStatus.OK);
    }

    // 4. update a attraction
    // http://localhost:8080/attractions
    @PutMapping("/attractions")
    public ResponseEntity<AttractionDto> updateBook(@RequestBody AttractionDto updateAttraction) {
        return new ResponseEntity<AttractionDto>(attractionService.updateAttraction(updateAttraction), HttpStatus.OK);
    }

    // 5. delete a attraction
    // http://localhost:8080/api/attractions/1
    @DeleteMapping("/attractions/{bid}")
    public ResponseEntity<Void> removeAttraction(@PathVariable("bid") int attractionId) {
        attractionService.removeAttraction(attractionId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    //6. fetch attractions by city
    @GetMapping("attractions/city/{cid}")
    public ResponseEntity<List<AttractionDto>> fetchAttractionsByCity(@PathVariable("cid") int cityId) {
        return new ResponseEntity<>(attractionService.fetchByCity(cityId), HttpStatus.OK);
    }
}

