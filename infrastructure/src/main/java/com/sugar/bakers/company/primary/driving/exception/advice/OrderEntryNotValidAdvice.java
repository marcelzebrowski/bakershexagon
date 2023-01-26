package com.sugar.bakers.company.primary.driving.exception.advice;

import com.sugar.bakers.company.adapter.in.OrderEntryNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OrderEntryNotValidAdvice {
    @ResponseBody
    @ExceptionHandler(OrderEntryNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String OrderEntryNotValidHandler(OrderEntryNotValidException ex){
        return ex.getMessage();
    }
}
