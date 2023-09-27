package com.aalifadesigns.matatatraveller.exception;

import com.aalifadesigns.matatatraveller.model.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    // here we handle all the exceptions

    @ExceptionHandler(value= {InvalidIdException.class})
    public ResponseEntity<ErrorDto> handleInvalidIdException(InvalidIdException ex, WebRequest request) {
        ErrorDto error = new ErrorDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
    @ExceptionHandler(value= {UpdateCategoryException.class})
    public ResponseEntity<ErrorDto> handleNoCompositeEntityException(UpdateCategoryException ex, WebRequest request) {
        ErrorDto error = new ErrorDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value= {InvalidThreadDateException.class})
    public ResponseEntity<ErrorDto> handleInvalidThreadDateException(InvalidIdException ex, WebRequest request) {
        ErrorDto error = new ErrorDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        /* This method is called when @Valid annotation is violated when copying the request body into a dto object
        in the controller layer. A map with the information on each error causing the exception is returned in the
        response body. */

        Map<String, Object> errorResponseBodyMap = new HashMap<String, Object>();

        // Add the timestamp of when the exception occurred to the map
        errorResponseBodyMap.put("timestamp", LocalDateTime.now());
        // Add the status code for the exception to the map
        errorResponseBodyMap.put("status", status.value());

        // This makes a collection of all the error objects.
        // Each error object has the field producing the input validation violation and the input validation error message.
        List<String> errors = ex.getBindingResult().getFieldErrors()
                // as ex object is wrapped in a class, .getBindingResult() accesses the wrapped object
                // .getFieldErrors() accesses the list of errors containing the error for each of the violated fields (from the dto being copied)
                .stream()
                // make a stream to access each of these errors
                .map((eachError)-> eachError.getField() + " " + eachError.getDefaultMessage())
                // for each error get which field of the dto it refers too and its error message
                .collect(Collectors.toList());
                // collect all the information in a list which we have named errors.
        // Add this collection to the map
        errorResponseBodyMap.put("errors", errors);

        return new ResponseEntity<Object>(errorResponseBodyMap, status);
    }
}
