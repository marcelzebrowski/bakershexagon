package com.sugar.bakers.company.primary.driving.exception;


import com.sugar.bakers.company.domain.CakeId;

public class CakeNotFoundException extends RuntimeException{
    public CakeNotFoundException(CakeId cakeId){
        super("Cake was not found " + cakeId.getId());
    }
}
