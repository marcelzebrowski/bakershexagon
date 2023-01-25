package com.sugar.bakers.company.primary.driving;

import com.sugar.bakers.company.adapter.in.OrderInputPort;
import com.sugar.bakers.company.adapter.in.OrderReaderPort;
import com.sugar.bakers.company.domain.Order;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderInputPort orderInputPort;
    private OrderReaderPort orderReaderPort;

    @GetMapping("/orders")
    public List<Order> readAllOrders(){
        return orderReaderPort.findAll();
    }

}
