package com.sugar.bakers.company.adapter.in;

import com.sugar.bakers.company.domain.Order;

import java.util.List;

public interface OrderReaderInputPort {
    List<Order> findAll();
}
