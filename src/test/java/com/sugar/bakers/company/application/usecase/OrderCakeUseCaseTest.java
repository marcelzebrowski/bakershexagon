package com.sugar.bakers.company.application.usecase;

import com.sugar.bakers.company.adapter.in.OrderEntryNotValidException;
import com.sugar.bakers.company.adapter.in.OrderInputPort;
import com.sugar.bakers.company.adapter.out.CakeOutputPort;
import com.sugar.bakers.company.adapter.out.CustomerOutputPort;
import com.sugar.bakers.company.adapter.out.OrderOutputPort;
import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderCakeUseCaseTest {

    @Test
    public void testPlaceOrderWithNullObject() throws OrderEntryNotValidException {
        OrderOutputPort orderOutputPort = mock(OrderOutputPort.class);
        CakeOutputPort cakeOutputPort = mock(CakeOutputPort.class);
        CustomerOutputPort customerOutputPort = mock(CustomerOutputPort.class);
        OrderCakeUseCase orderCakeUseCase = new OrderCakeUseCase(orderOutputPort, cakeOutputPort, customerOutputPort);

        Customer.CustomerId customerId = new Customer.CustomerId(47L);
        Cake.CakeId cakeId = new Cake.CakeId(11L);

        OrderInputPort.OrderEntry orderEntry = new OrderInputPort.OrderEntry(customerId, cakeId);
        Order.OrderId orderId = orderCakeUseCase.placeOrder(orderEntry);
        assertTrue(orderId.getIsNull());
    }

    @Test
    public void testPlaceOrder() throws OrderEntryNotValidException {

        Cake cake = new Cake("Apple Pie");
        cake.setCakeId(new Cake.CakeId(1000L));

        Customer customer = new Customer("Marcel");
        customer.setCustomerId(new Customer.CustomerId(1000L));

        CakeOutputPort cakeOutputPort = mock(CakeOutputPort.class);
        CustomerOutputPort customerOutputPort = mock(CustomerOutputPort.class);

        when(cakeOutputPort.finById(any(Cake.CakeId.class))).thenReturn(Optional.of(cake));
        when(customerOutputPort.findById(any(Customer.CustomerId.class))).thenReturn(Optional.of(customer));

        OrderOutputPort orderOutputPort = mock(OrderOutputPort.class);
        OrderInputPort orderCakeUseCase = new OrderCakeUseCase(orderOutputPort, cakeOutputPort, customerOutputPort);
        when(orderOutputPort.save(any(Order.class))).thenReturn(new Order.OrderId(1000L));


        Customer.CustomerId customerId = new Customer.CustomerId(47L);
        Cake.CakeId cakeId = new Cake.CakeId(11L);

        OrderInputPort.OrderEntry orderEntry = new OrderInputPort.OrderEntry(customerId, cakeId);
        Order.OrderId orderId = orderCakeUseCase.placeOrder(orderEntry);

        verify(orderOutputPort,times(1)).save(any(Order.class));
        assertFalse(orderId.getIsNull());
    }
}
