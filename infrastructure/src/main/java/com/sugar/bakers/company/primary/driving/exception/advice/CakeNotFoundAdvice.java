package com.sugar.bakers.company.primary.driving.exception.advice;

import com.sugar.bakers.company.primary.driving.exception.CakeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CakeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CakeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String cakeNotFoundHandler(CakeNotFoundException ex){
        return ex.getMessage();
    }
}
