package com.nexus.drone.drone.middleWare;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;
@ControllerAdvice
public class HttpExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ignoredE){
        HttpStatus status  = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status.getReasonPhrase(), status);
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleIllegalArgumentException(MethodArgumentTypeMismatchException e){
        String message = e.getMessage();
        HttpStatus status;
        if (message.contains("UUID"))
            status = HttpStatus.NOT_FOUND;
        else
            status = HttpStatus.UNPROCESSABLE_ENTITY;
        return new ResponseEntity<>(status.getReasonPhrase(), status);
    }
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleException(Throwable e) {
        e.printStackTrace();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(status.getReasonPhrase(), status);
    }
}
