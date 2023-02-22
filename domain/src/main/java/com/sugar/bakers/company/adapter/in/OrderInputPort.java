package com.sugar.bakers.company.adapter.in;


import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.CakeId;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.Order;
import lombok.Value;

import javax.validation.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

public interface OrderInputPort {
    Order.OrderId placeOrder(@Valid OrderEntry orderEntry);

    @Value
    class OrderEntry{
        @NotNull
        Customer.CustomerId customerId;
        @NotNull
        CakeId cakeId;

        public OrderEntry(Customer.CustomerId customerId, CakeId cakeId) throws OrderEntryNotValidException {
            this.customerId = customerId;
            this.cakeId = cakeId;
            validate();
        }

        private void validate() throws OrderEntryNotValidException {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<OrderEntry>> violations = validator.validate(this);
            if(!violations.isEmpty()){
                throw new OrderEntryNotValidException();
            }
        }
    }
}
