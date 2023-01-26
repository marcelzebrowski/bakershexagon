package com.sugar.bakers.company.primary.driving.exception.advice;

import com.sugar.bakers.company.primary.driving.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomerNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String customerNotFoundHandler(CustomerNotFoundException ex){
        return ex.getMessage();
    }
}
