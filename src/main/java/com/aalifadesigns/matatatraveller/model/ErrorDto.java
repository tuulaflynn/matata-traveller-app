package com.aalifadesigns.matatatraveller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorDto {
    private String errorMessage;
    private HttpStatus errorCode;
    private LocalDateTime errorDateTime;


}
