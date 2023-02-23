package com.sugar.bakers.company.adapter.in;

import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.CustomerId;

import java.util.List;
import java.util.Optional;

// Golden Hammer Example
public interface CustomerReaderPort {
    List<Customer> findAll();

    Optional<Customer> findById(CustomerId customerId);

    Optional<Customer> findByUsername(String username);
}
