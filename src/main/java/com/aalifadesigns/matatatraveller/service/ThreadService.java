package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.entities.ThreadEntity;
import com.aalifadesigns.matatatraveller.model.CategoryDto;
import com.aalifadesigns.matatatraveller.model.CityDto;
import com.aalifadesigns.matatatraveller.model.ThreadDto;

import java.time.LocalDate;
import java.util.List;

public interface ThreadService {
    List<ThreadDto> fetchAllThreads();

    ThreadDto fetchAThread(int threadId);
    ThreadDto addThread(ThreadDto newThreadDto);
    List<ThreadDto> fetchByThreadDate(LocalDate threadDate);
    ThreadDto updateThread(ThreadDto updateThreadDto);
    void deleteThread(int threadId);

    //fetch threads by city
    public List<ThreadDto> fetchThreadsByCity(int cityId);

    //fetch threads by category
    public List<ThreadDto> fetchThreadsByCategory (int categoryId);

   public  List<ThreadDto> fetchThreadsByCityAndCategory(int cityId, int categoryId);

}