package com.sugar.bakers.company.adapter.in;

import com.sugar.bakers.company.domain.Order;

import java.util.List;

public interface OrderReaderPort {
    List<Order> findAll();
}
