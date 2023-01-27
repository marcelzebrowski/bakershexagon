package com.sugar.bakers.company.primary.driving;

import com.sugar.bakers.company.adapter.out.CustomerOutputPort;
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

    // TODO: Der Aufruf muss eigentlich über den UseCase erfolgen!
    private CustomerOutputPort customerOutputPort;

    @GetMapping("/customer/{id}")
    public Customer readCustomer(@PathVariable Long id){
        Customer.CustomerId customerId = new Customer.CustomerId(id);
        return customerOutputPort.findById(customerId).orElseThrow(()->new CustomerNotFoundException(customerId));
    }
    
    @GetMapping("/customers")
    public List<Customer> readAllCustomers(){
        return customerOutputPort.findAll();
    }
}
