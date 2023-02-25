package com.sugar.bakers.company.secondary.driven.database;

import com.sugar.bakers.company.domain.*;
import com.sugar.bakers.company.secondary.driven.database.entity.OrderEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Test
    public void testSaveOrder(){
        OrderEntity orderEntity = mock(OrderEntity.class);
        when(orderEntity.getId()).thenReturn(1000L);
        OrderRepository orderRepository = mock(OrderRepository.class);
        when(orderRepository.save(any(OrderEntity.class))).thenReturn(orderEntity);

        Cake cake = new Cake(new CakeId(1000L),"Test","test","Description");
        Customer customer = new Customer(new CustomerId(1000L),"Marcel");

        Order order = new Order(cake,customer);

        OrderService orderService = new OrderService(orderRepository);
        orderService.save(order);

        verify(orderRepository,times(1)).save(any(OrderEntity.class));
    }
}
