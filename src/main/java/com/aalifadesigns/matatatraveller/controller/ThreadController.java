package com.aalifadesigns.matatatraveller.controller;

import com.aalifadesigns.matatatraveller.model.ThreadDto;
import com.aalifadesigns.matatatraveller.service.ThreadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ThreadController {

    private ThreadService threadService;

    @Autowired
    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }


    // http://localhost:8080/api/threads
    @GetMapping("/threads")
    public ResponseEntity<List<ThreadDto>> fetchAllThreads() {
        return new ResponseEntity<List<ThreadDto>>(threadService.fetchAllThreads(), HttpStatus.OK);
    }

    @GetMapping("/threads/{threadId}")
    public ResponseEntity<ThreadDto> fetchAThread(@PathVariable("threadId") int threadId) {
        return new ResponseEntity<ThreadDto>(threadService.fetchAThread(threadId), HttpStatus.OK);
    }

    @PostMapping("/threads")
    public ResponseEntity<ThreadDto> addThread(@RequestBody @Valid ThreadDto newThreadDto) {
        return new ResponseEntity<>(threadService.addThread(newThreadDto), HttpStatus.OK);
    }

    // http://localhost:8080/api/threads/date/2023-05-27       // the path variable can be written like this for a date
    @GetMapping("/threads/date/{threadDate}")
    public ResponseEntity<List<ThreadDto>> fetchThreadByDate(@PathVariable("threadDate") LocalDate threadDate) {
        return new ResponseEntity<>(threadService.fetchByThreadDate(threadDate), HttpStatus.OK);
    }

    @PutMapping("/threads")
    public ResponseEntity<ThreadDto> updateThread(@RequestBody @Valid ThreadDto updateThreadDto) {
        return new ResponseEntity<>(threadService.updateThread(updateThreadDto), HttpStatus.OK);
    }

    @DeleteMapping("/threads/{threadId}")
    public ResponseEntity<Void> deleteThread(@PathVariable("threadId") int threadId) {
        threadService.deleteThread(threadId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //fetch threads by city
    @GetMapping("/threads/city/{cid}")
    public ResponseEntity<List<ThreadDto>> fetchThreadsByCity(@PathVariable("cid") int cityId) {
        return new ResponseEntity<>(threadService.fetchByCity(cityId), HttpStatus.OK);
    }

    //fetch threads by category
    @GetMapping("/threads/category/{cid}")
    public ResponseEntity<List<ThreadDto>> fetchThreadsByCategory(@PathVariable("cid") int categoryId) {
        //call fetchThreadsByCategory, wrap the returned collection of threads in the ResponseEntity which is to be returned
        return new ResponseEntity<>(threadService.fetchByCategory(categoryId), HttpStatus.OK);
    }

    //fetch threads by city and category, using 2 path variables
    @GetMapping("/threads/city/{cid}/category/{categoryId}")
    public ResponseEntity<List<ThreadDto>> fetchThreadsByCityAndCategory(@PathVariable("cid") int cityId, @PathVariable("categoryId") int categoryId) {
        return new ResponseEntity( threadService.fetchByCityAndCategory(cityId,categoryId), HttpStatus.OK);
    }
}
