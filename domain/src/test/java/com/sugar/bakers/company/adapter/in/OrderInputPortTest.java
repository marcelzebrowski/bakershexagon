package com.sugar.bakers.company.adapter.in;
import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.CakeId;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.CustomerId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class OrderInputPortTest {
    @Test
    public void placeOrder() {
        CustomerId customerId = new CustomerId(47L);
        CakeId cakeId = new CakeId(11L);
        assertDoesNotThrow(()-> new OrderInputPort.OrderEntry(customerId,cakeId));
    }

    @Test
    public void placeInvalidOrder() {
        OrderEntryNotValidException thrown = assertThrows(
                OrderEntryNotValidException.class,
                () -> new OrderInputPort.OrderEntry(null,null)
        );
        assertEquals(thrown.getClass(), OrderEntryNotValidException.class);
    }
}

