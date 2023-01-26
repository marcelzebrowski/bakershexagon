package com.sugar.bakers.company.primary.driving.exception;

import com.sugar.bakers.company.domain.Cake;

public class CakeNotFoundException extends RuntimeException{
    public CakeNotFoundException(Cake.CakeId cakeId){
        super("Cake was not found " + cakeId.getId());
    }
}
