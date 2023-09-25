package com.aalifadesigns.matatatraveller.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

//Using LOMBOK
@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

public class CityDto {
    private int cityId;
    private String cityName;
    private String cityCountry;
    private String cityImg;
    private String cityCurrency;

    //corresponding to the City entity object (Many to Many - one city has many threads)
    private List<ThreadDto> allThreads;

    //corresponding to the City entity object (One to Many - one city has many attractions)
    private List<AttractionDto> allAttractions;

    public static class ErrorDto {
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
}
