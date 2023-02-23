package com.sugar.bakers.company.primary.driving;

import com.sugar.bakers.company.adapter.in.OrderEntryNotValidException;
import com.sugar.bakers.company.adapter.in.OrderInputPort;
import com.sugar.bakers.company.adapter.in.OrderReaderInputPort;

import com.sugar.bakers.company.domain.CakeId;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.CustomerId;
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
    public Order.OrderId placeOrder(@PathVariable("customer") Long customerId, @PathVariable("cakeId") Long cakeId) throws OrderEntryNotValidException {
        CustomerId customer = new CustomerId(customerId);
        CakeId cake = new CakeId(cakeId);
        OrderInputPort.OrderEntry orderEntry = new OrderInputPort.OrderEntry(customer,cake);
        return orderInputPort.placeOrder(orderEntry);
    }

}
