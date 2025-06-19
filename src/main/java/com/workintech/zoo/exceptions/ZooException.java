package com.workintech.zoo.exceptions;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Data
public class ZooException extends RuntimeException {

    private HttpStatus httpStatus;

    @Autowired
    public ZooException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }


    public HttpStatus getStatus() {
        return httpStatus;
    }

}
