package com.workintech.zoo.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ZooGlobalExceptionHandler {

    @ExceptionHandler(ZooException.class)
    public ResponseEntity<ZooErrorResponse> handleZooException(ZooException ex) {
        log.error("ZooException occurred: {}", ex.getMessage());

        ZooErrorResponse response = new ZooErrorResponse(
                ex.getStatus().value(),
                ex.getMessage(),
                        System.currentTimeMillis()
                );
        return new ResponseEntity<>(response, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ZooErrorResponse> handleGeneralException(Exception ex) {
        log.error("Unhandled Exception occurred: {}", ex.getMessage());

        ZooErrorResponse response = new ZooErrorResponse(
                500, "Internal Server Error",

                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
    }
}