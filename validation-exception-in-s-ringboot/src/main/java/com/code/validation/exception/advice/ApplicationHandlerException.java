package com.code.validation.exception.advice;

import com.code.validation.exception.exception.UserException;
import com.code.validation.exception.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicationHandlerException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?>  handleBusinessException(UserNotFoundException exception){
        UserException userException=new UserException(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<UserException>(userException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>  handleBusinessExceptionMissingPathVariableException(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return  new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);

    }

}
