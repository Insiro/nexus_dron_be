package com.nexus.drone.drone.utils;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpError extends RuntimeException{
    String msg;
    HttpStatus status;
    public HttpError(HttpStatus status, String msg){
        super(msg);
        this.msg = msg;
        this.status = status;
    }
    public HttpError(HttpStatus status){
        this(status, status.getReasonPhrase());
    }
    public HttpError(int statusCode){
        this(HttpStatus.valueOf(statusCode));
    }
    public HttpError(int statusCode, String msg){
        this(HttpStatus.valueOf(statusCode), msg);
    }
}
