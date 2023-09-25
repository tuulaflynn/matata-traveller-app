package com.aalifadesigns.matatatraveller.service;

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
    // fetch threads by city
    List<ThreadDto> fetchByCity(int cityId);
    // fetch threads by category
    List<ThreadDto> fetchByCategory (int categoryId);
    // fetch threads by city and category
    List<ThreadDto> fetchByCityAndCategory(int cityId, int categoryId);

}
