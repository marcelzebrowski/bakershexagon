package com.sugar.bakers.company.secondary.driven.database;

import com.sugar.bakers.company.adapter.out.CustomerOutputPort;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.CustomerId;
import com.sugar.bakers.company.secondary.driven.database.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Customer> findById(CustomerId customerId) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(customerId.getId());
        return extract(customerEntity);
    }

    @Override
    public Optional<Customer> findByName(String username) {
        Optional<CustomerEntity> customerEntity = customerRepository.findByName(username);
        return extract(customerEntity);
    }

    private Optional<Customer> extract(Optional<CustomerEntity> customerEntity) {
        Customer customer = null;

        if(customerEntity.isPresent()){
            customer = mapToDomain(customerEntity.get());
        }

        return Optional.ofNullable(customer);
    }

    private Customer mapToDomain(CustomerEntity result){
        Customer customer = new Customer(new CustomerId(result.getId()), result.getName());
        return customer;
    }

    private List<Customer> mapToDomain(List<CustomerEntity> results) {
        List<Customer> customerList = new ArrayList<>();
        for(CustomerEntity ce : results){
            Long id = ce.getId();
            String name = ce.getName();
            Customer tmp = new Customer(new CustomerId(id),name);
            customerList.add(tmp);
        }
        return customerList;
    }
}
