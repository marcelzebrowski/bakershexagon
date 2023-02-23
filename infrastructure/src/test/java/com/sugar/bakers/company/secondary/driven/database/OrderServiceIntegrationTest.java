package com.sugar.bakers.company.secondary.driven.database;

import com.sugar.bakers.company.Application;
import com.sugar.bakers.company.domain.*;
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
public class OrderServiceIntegrationTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void saveOrderToDatabase() throws InterruptedException {
        Cake cake = new Cake(new CakeId(2L),"Marble Cake","marble", "%-)");
        Customer customer = new Customer(new CustomerId(1L),"Marcel");
        Order order = new Order(cake,customer); // TODO: only ids because orderservice don't need the whole object!!
        orderService.save(order);
    }

    @Test
    public void readAllOrdersFromDatabase(){
        List<Order> orderList = orderService.findAll();
        assertFalse(orderList.isEmpty());
    }

}
