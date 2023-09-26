package com.aalifadesigns.matatatraveller.exception;

import com.aalifadesigns.matatatraveller.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    // here we handle all the exceptions

    @ExceptionHandler(value= {ApplicationException.class})
    public ResponseEntity<ErrorDto> handleApplicationException(ApplicationException ae, WebRequest request) {
        ErrorDto error = new ErrorDto(ae.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value= {InvalidIdException.class})
    public ResponseEntity<ErrorDto> handleInvalidIdException(InvalidIdException ae, WebRequest request) {
        ErrorDto error = new ErrorDto(ae.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value= {NoCompositeEntityException.class})
    public ResponseEntity<ErrorDto> handleNoCompositeEntityException(NoCompositeEntityException ae, WebRequest request) {
        ErrorDto error = new ErrorDto(ae.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
