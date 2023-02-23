package com.sugar.bakers.company.adapter.out;

import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.CustomerId;

import java.util.List;
import java.util.Optional;

public interface CustomerOutputPort {
    List<Customer> findAll();

    Optional<Customer> findById(CustomerId customerId);

    Optional<Customer> findByName(String username);
}
