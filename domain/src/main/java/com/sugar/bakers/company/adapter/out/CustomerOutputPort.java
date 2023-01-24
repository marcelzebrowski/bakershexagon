package com.sugar.bakers.company.adapter.out;

import com.sugar.bakers.company.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerOutputPort {
    List<Customer> findAll();

    Optional<Customer> findById(Customer.CustomerId customerId);
}
