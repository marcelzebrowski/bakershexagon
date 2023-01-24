package com.sugar.bakers.company.adapter.out;

import com.sugar.bakers.company.domain.Customer;

import java.util.List;

public interface CustomerOutputPort {
    List<Customer> findAll();
}
