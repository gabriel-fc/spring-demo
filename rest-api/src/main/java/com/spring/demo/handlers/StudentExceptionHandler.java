package com.spring.demo.handlers;

import com.spring.demo.exceptions.ExceptionResponse;
import com.spring.demo.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.Date;

@ControllerAdvice
public class StudentExceptionHandler {
    @Autowired
    private ExceptionResponse response;

    @ExceptionHandler({StudentNotFoundException.class})
    public ResponseEntity<ExceptionResponse> studentNotFoundHandler(StudentNotFoundException e){
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setTimeStamp(new Date());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
