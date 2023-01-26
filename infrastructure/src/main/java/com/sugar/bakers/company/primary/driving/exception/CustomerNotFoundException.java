package com.sugar.bakers.company.primary.driving.exception;

import com.sugar.bakers.company.domain.Customer;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Customer.CustomerId customerId){
        super("Customer was not found " + customerId.getId());
    }
}
