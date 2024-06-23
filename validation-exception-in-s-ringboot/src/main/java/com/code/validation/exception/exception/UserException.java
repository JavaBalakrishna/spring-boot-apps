package com.code.validation.exception.exception;

import org.springframework.http.HttpStatus;

public class UserException {
    private String excpetion;
    private HttpStatus status;

    public UserException(String excpetion, HttpStatus status) {
        this.excpetion = excpetion;
        this.status = status;
    }

    public String getExcpetion() {
        return excpetion;
    }

    public void setExcpetion(String excpetion) {
        this.excpetion = excpetion;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
