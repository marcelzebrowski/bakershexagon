package com.sugar.bakers.company.primary.driving;

import com.sugar.bakers.company.adapter.in.OrderEntryNotValidException;
import com.sugar.bakers.company.adapter.in.OrderInputPort;
import com.sugar.bakers.company.adapter.in.OrderReaderInputPort;
import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderInputPort orderInputPort;
    private OrderReaderInputPort orderReaderInputPort;

    @GetMapping("/orders")
    public List<Order> readAllOrders(){
        return orderReaderInputPort.findAll();
    }

    @PostMapping("/order/new/{customerId}/{cakeId}")
    public Order.OrderId placeOrder(@PathVariable("customerId") Long customerId, @PathVariable("cakeId") Long cakeId) throws OrderEntryNotValidException {
        Customer.CustomerId customer = new Customer.CustomerId(customerId);
        Cake.CakeId cake = new Cake.CakeId(cakeId);
        OrderInputPort.OrderEntry orderEntry = new OrderInputPort.OrderEntry(customer,cake);
        return orderInputPort.placeOrder(orderEntry);
    }

}
