package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.model.ThreadDto;

import java.time.LocalDate;
import java.util.List;

public interface ThreadService {
    List<ThreadDto> fetchAllThreads();

    ThreadDto fetchAThread(int threadId);
    ThreadDto addThread(ThreadDto newThreadDto);
    List<ThreadDto> fetchByThreadDate(LocalDate threadDate);
    List<ThreadDto> fetchByCategoryId(int categoryId);
    List<ThreadDto> fetchByCityId(int cityId);
    ThreadDto updateThread(ThreadDto updateThreadDto);
    void deleteThread(int threadId);
}
