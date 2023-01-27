package com.sugar.bakers.company.adapter.in;

import com.sugar.bakers.company.domain.Customer;

import java.util.List;
import java.util.Optional;

// Golden Hammer Example
public interface CustomerReaderPort {
    List<Customer> findAll();

    Optional<Customer> findById(Customer.CustomerId customerId);
}
