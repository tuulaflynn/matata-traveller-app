package com.aalifadesigns.matatatraveller.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorDto {
    private String errorMessage;
    private HttpStatus errorCode;
    private LocalDateTime errorDateTime;

    public ErrorDto(String errorMessage, HttpStatus internalServerError, LocalDateTime errorDateTime) {
        super();
        this.errorMessage = errorMessage;
        this.errorCode = internalServerError;
        this.errorDateTime = errorDateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getErrorDateTime() {
        return errorDateTime;
    }

    public void setErrorDateTime(LocalDateTime errorDateTime) {
        this.errorDateTime = errorDateTime;
    }

    @Override
    public String toString() {
        return "ErrorDto [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", errorDateTime="
                + errorDateTime + "]";
    }
}
