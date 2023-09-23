package com.aalifadesigns.matatatraveller.service;

import com.aalifadesigns.matatatraveller.dao.ThreadDao;
import com.aalifadesigns.matatatraveller.model.ThreadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ThreadServiceImpl implements ThreadService {

    private ThreadDao threadDao;

    @Autowired
    public ThreadServiceImpl(ThreadDao threadDao) {
        this.threadDao = threadDao;
    }

    @Override
    public List<ThreadDto> fetchAllThreads() {
        return null;
    }

    @Override
    public ThreadDto addThread(ThreadDto newThreadDto) {
        return null;
    }

    @Override
    public List<ThreadDto> fetchByThreadDate(LocalDate threadDate) {
        return null;
    }

    @Override
    public List<ThreadDto> fetchByCategoryId(int categoryId) {
        return null;
    }

    @Override
    public List<ThreadDto> fetchByCityId(int cityId) {
        return null;
    }

    @Override
    public ThreadDto updateThread(ThreadDto updateThreadDto) {
        return null;
    }

    @Override
    public void deleteThread(int threadId) {

    }
}
