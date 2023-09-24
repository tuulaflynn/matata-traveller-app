package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.model.AttractionDto;

import java.util.List;

public interface AttractionService {
    public List<AttractionDto> fetchAllAttractions();
    public AttractionDto fetchAAttraction(int attractionId);
    public AttractionDto addAttraction(AttractionDto newAttraction);
    public AttractionDto updateAttraction(AttractionDto updateAttraction);
    public void removeAttraction(int attractionId);
}
