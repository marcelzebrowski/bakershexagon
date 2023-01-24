package com.sugar.bakers.company.application.usecase;

import com.sugar.bakers.company.adapter.in.OrderEntryNotValidException;
import com.sugar.bakers.company.adapter.in.OrderInputPort;
import com.sugar.bakers.company.adapter.out.OrderOutputPort;
import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderCakeUseCaseTest {

    @Test
    public void testPlaceOrder() throws OrderEntryNotValidException {
        OrderOutputPort orderOutputPort = mock(OrderOutputPort.class);
        OrderCakeUseCase orderCakeUseCase = new OrderCakeUseCase(orderOutputPort);
        Customer.CustomerId customerId = new Customer.CustomerId(47L);
        Cake.CakeId cakeId = new Cake.CakeId(11L);
        OrderInputPort.OrderEntry orderEntry = new OrderInputPort.OrderEntry(customerId, cakeId);
        orderCakeUseCase.placeOrder(orderEntry);
        verify(orderOutputPort,times(1)).save(any(Order.class));
    }
}
