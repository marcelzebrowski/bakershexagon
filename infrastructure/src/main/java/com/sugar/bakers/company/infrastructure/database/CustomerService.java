package com.sugar.bakers.company.infrastructure.database;

import com.sugar.bakers.company.adapter.out.CustomerOutputPort;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.infrastructure.database.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService implements CustomerOutputPort {

    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> results = customerRepository.findAll();
        return mapToDomain(results);
    }

    private List<Customer> mapToDomain(List<CustomerEntity> results) {
        List<Customer> customerList = new ArrayList<>();
        for(CustomerEntity ce : results){
            Long id = ce.getId();
            String name = ce.getName();
            Customer tmp = new Customer(name);
            tmp.setCustomerId(new Customer.CustomerId(id));
            customerList.add(tmp);
        }
        return customerList;
    }
}
