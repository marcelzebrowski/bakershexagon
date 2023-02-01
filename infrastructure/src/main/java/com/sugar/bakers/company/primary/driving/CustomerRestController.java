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

    // Homework: Marcel war faul und hat gar nicht eingesehen hier den Golden Hammer zu implementieren.
    //           Marcel hat aber vergessen, dass die Id noch validiert werden soll und das der Kunde noch validiert werden
    //           muss, ob dieser überhaupt aufgrund von nicht bezahlten Rechnungen bestellen darf.
    //           Bade Marcels Faulheit aus!
    private CustomerOutputPort customerOutputPort; // !!! GEHEN NICHT ÜBER USE CASE !!!

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
