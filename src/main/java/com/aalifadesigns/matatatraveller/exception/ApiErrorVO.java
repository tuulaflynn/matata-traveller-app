package com.aalifadesigns.matatatraveller.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiErrorVO { //Value Object
    private String errorCode;
    private String message;

    public ApiErrorVO(String errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }

}
