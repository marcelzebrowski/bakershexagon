package com.sugar.bakers.company.adapter.out;


import com.sugar.bakers.company.domain.Order;

import java.util.List;

public interface OrderOutputPort {
    Order.OrderId save(Order order);

    List<Order> findAll();
}
