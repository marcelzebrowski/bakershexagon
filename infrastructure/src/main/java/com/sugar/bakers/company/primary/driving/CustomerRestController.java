package com.sugar.bakers.company.primary.driving;

import com.sugar.bakers.company.adapter.in.CustomerReaderPort;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.primary.driving.exception.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {

    private CustomerReaderPort customerReaderPort;

    @GetMapping("/customer/{id}")
    public Customer readCustomer(@PathVariable Long id){
        Customer.CustomerId customerId = new Customer.CustomerId(id);
        return customerReaderPort.findById(customerId).orElseThrow(()->new CustomerNotFoundException(customerId));
    }
    
    @GetMapping("/customers")
    public List<Customer> readAllCustomers(){
        return customerReaderPort.findAll();
    }
}
