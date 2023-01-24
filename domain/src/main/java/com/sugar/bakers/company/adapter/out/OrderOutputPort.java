package com.sugar.bakers.company.adapter.out;


import com.sugar.bakers.company.domain.Order;

public interface OrderOutputPort {
    Order.OrderId save(Order order);
}
