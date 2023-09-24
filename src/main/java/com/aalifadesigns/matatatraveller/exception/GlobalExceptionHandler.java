package com.aalifadesigns.matatatraveller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    // here we handle all the exceptions

    @ExceptionHandler(value= {ApplicationException.class})
    public ResponseEntity<ErrorDto> handleApplicationException(ApplicationException ae, WebRequest request) {
        ErrorDto error = new ErrorDto(ae.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        // instead of ErrorDto, I am using a map to be returned in the response body
        // this map will have all the input validation error messages
        Map<String, Object> errorResponseBody = new HashMap<String, Object>();
        errorResponseBody.put("timestamp", LocalDateTime.now());
        errorResponseBody.put("status", status.value());

        // next we will takeout all the input exception messages and collect it inside a collection
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map((eachError)-> eachError.getField() + " " + eachError.getDefaultMessage())
                .collect(Collectors.toList());
        // next put this collection of error message into the map
        errorResponseBody.put("errors", errors);

        return new ResponseEntity<Object>(errorResponseBody, status);
    }
}
