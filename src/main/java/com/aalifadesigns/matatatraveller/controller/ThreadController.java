package com.aalifadesigns.matatatraveller.controller;

import com.aalifadesigns.matatatraveller.exception.ApplicationException;
import com.aalifadesigns.matatatraveller.model.CategoryDto;
import com.aalifadesigns.matatatraveller.model.CityDto;
import com.aalifadesigns.matatatraveller.model.ThreadDto;
import com.aalifadesigns.matatatraveller.service.CategoryService;
import com.aalifadesigns.matatatraveller.service.CityService;
import com.aalifadesigns.matatatraveller.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ThreadController {

        private ThreadService threadService;
        private CityService cityService;
        private CategoryService categoryService;

        @Autowired
        public ThreadController(ThreadService threadService, CityService cityService, CategoryService categoryService) {
                this.threadService = threadService;
                this.cityService = cityService;
                this.categoryService = categoryService;
        }


        // http://localhost:8080/api/threads
        @GetMapping("threads")
        public ResponseEntity<List<ThreadDto>> fetchAllThreads() {
            return new ResponseEntity<List<ThreadDto>>(threadService.fetchAllThreads(), HttpStatus.OK);
        }

        @GetMapping("threads/{threadId}")
        public ResponseEntity<ThreadDto> fetchAThread(@PathVariable("threadId") int threadId) {
        return new ResponseEntity<ThreadDto>(threadService.fetchAThread(threadId), HttpStatus.OK);
        }

        @PostMapping("threads")
        public ResponseEntity<ThreadDto> addThread(@RequestBody ThreadDto newThreadDto) {
            return new ResponseEntity<>(threadService.addThread(newThreadDto), HttpStatus.OK);
        }

        // http://localhost:8080/api/threads/date/2023-05-27       // the path variable can be written like this for a date
        @GetMapping("threads/date/{threadDate}")
        public ResponseEntity<List<ThreadDto>> fetchThreadByDate(@PathVariable("threadDate") LocalDate threadDate) {
            return new ResponseEntity<>(threadService.fetchByThreadDate(threadDate), HttpStatus.OK);
        }

        @PutMapping("threads")
        public ResponseEntity<ThreadDto> updateThread(@RequestBody ThreadDto updateThreadDto) {
                return new ResponseEntity<>(threadService.updateThread(updateThreadDto), HttpStatus.OK);
        }

        @DeleteMapping("threads/{threadId}")
        public ResponseEntity<Void> deleteThread(@PathVariable("threadId") int threadId) {
                threadService.deleteThread(threadId);
                return new ResponseEntity<Void>(HttpStatus.OK);
        }

        //fetch threads by city
        @GetMapping ("threads/city/{cid}")
        public ResponseEntity<List<ThreadDto>> fetchThreadsByCity(@PathVariable("cid") int cityId) {

                //fetch CityDto object using cityService, passing the cityId (used path variable) as parameter
                CityDto cityDto = cityService.fetchACity(cityId);

                //if the city does not exist throw custom exception referring to DataAccess
                if (cityDto == null){
                        throw new ApplicationException();
                }
                return new ResponseEntity<>(threadService.fetchThreadsByCity(cityDto), HttpStatus.OK);
        }

        //fetch threads by category
        @GetMapping ("threads/category/{cid}")
        public ResponseEntity<List<ThreadDto>> fetchThreadsByCategory(@PathVariable("cid") int categoryId) {
                //fetch CategoryDto object, passing the categoryId (cid - used path variable) as parameter
                CategoryDto categoryDto = categoryService.fetchACategory(categoryId);
                //if the category does not exist throw custom exception referring to DataAccess
                if (categoryDto == null){
                        throw new ApplicationException();
                }
                //call fetchThreadsByCategory, wrap the returned collection of threads in the ResponseEntity which is to be returned
                return new ResponseEntity<>(threadService.fetchThreadsByCategory(categoryDto), HttpStatus.OK);
        }

        //fetch threads by city and category, using 2 path variables
        @GetMapping ("threads/city/{cid}/category/{categoryId}")
        public ResponseEntity<List<ThreadDto>> fetchThreadsByCityAndCategory(@PathVariable("cid") int cityId, @PathVariable("categoryId") int categoryId) {

                //fetch City and Category DTOs corresponding to the int cityId and categoryId
                CityDto cityDto = cityService.fetchACity(cityId);
                CategoryDto categoryDto = categoryService.fetchACategory(categoryId);

                //if either the city or the category does not exist, throw custom exception
                if(cityDto ==null || categoryDto ==null){
                        throw new ApplicationException();
                }

                //call the methods which return the ThreadDto collections and add the common objects into a new Threads collection
                List<ThreadDto> allThreadsByCity = threadService.fetchThreadsByCity(cityDto);
                List<ThreadDto> allThreadsByCategory = threadService.fetchThreadsByCategory(categoryDto);

                // traverse one collection and check if the ThreadDto is also present in the other collection
                // if yes, add the Thread item to the new Thread collection (allThreadsByCityAndCategory)
                List<ThreadDto> allThreadsByCityAndCategory = new ArrayList<ThreadDto>();
                for (ThreadDto thread : allThreadsByCity) {
                        if (allThreadsByCategory.contains(thread)) {
                                allThreadsByCityAndCategory.add(thread);
                        }
                }
                //return the Threads collection
                return new ResponseEntity(allThreadsByCityAndCategory, HttpStatus.OK);
        }
}
