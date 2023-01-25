package com.sugar.bakers.company.secondary.driven.database;

import com.sugar.bakers.company.Application;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.secondary.driven.config.DatabaseJpaConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Application.class, DatabaseJpaConfiguration.class})
@ActiveProfiles("test")
public class CustomerServiceIntegrationTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testFindAll(){
        List<Customer> customerList = customerService.findAll();
        assertFalse(customerList.isEmpty());
    }
}
