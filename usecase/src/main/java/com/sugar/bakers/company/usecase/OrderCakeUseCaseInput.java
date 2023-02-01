package com.sugar.bakers.company.usecase;


import com.sugar.bakers.company.adapter.in.OrderInputPort;
import com.sugar.bakers.company.adapter.in.OrderReaderInputPort;
import com.sugar.bakers.company.adapter.out.CakeOutputPort;
import com.sugar.bakers.company.adapter.out.CustomerOutputPort;
import com.sugar.bakers.company.adapter.out.OrderOutputPort;
import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.Order;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class OrderCakeUseCaseInput implements OrderInputPort, OrderReaderInputPort { // solid - dependency inversion principle

    @NonNull
    private OrderOutputPort orderOutputPort;

    @NonNull
    private CakeOutputPort cakeOutputPort;

    @NonNull
    private CustomerOutputPort customerOutputPort;

    // CustomerDebitPort customerDebitPort;
    // CakeAvailabilityPort cakeAvailabilityPort;

    @Override
    public Order.OrderId placeOrder(OrderEntry orderEntry){
        // do some nice stuff for this UseCase
        Optional<Customer> customer = loadCustomer(orderEntry.getCustomerId());
        Optional<Cake> cake = loadCake(orderEntry.getCakeId());

        // do something more ...

        // i.e
        // customerDebitPort.debitCustomerAccount(cake, customer)
        // cakeAvailabilityPort.check(cake)

        // and more ...

        if(cake.isPresent() && customer.isPresent()) {
            Order order = new Order(cake.get(), customer.get());
            return orderOutputPort.save(order);
        }
        // if nothing was found then return a null pattern object
        return new Order.OrderId(Boolean.TRUE);
    }

    private Optional<Customer> loadCustomer(Customer.CustomerId customerId){
        return customerOutputPort.findById(customerId);
    }

    private Optional<Cake> loadCake(Cake.CakeId cakeId){
        return cakeOutputPort.finById(cakeId);
    }

    @Override
    public List<Order> findAll() {
        return orderOutputPort.findAll();
    }
}
