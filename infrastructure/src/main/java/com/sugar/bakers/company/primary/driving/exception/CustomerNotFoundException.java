package com.sugar.bakers.company.primary.driving.exception;

import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.CustomerId;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(CustomerId customerId){
        super("Customer was not found " + customerId.getId());
    }

    public CustomerNotFoundException(String customer){
        super("Customer was not found " + customer);
    }
}
