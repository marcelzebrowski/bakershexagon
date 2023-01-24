package com.sugar.bakers.company.application.usecase;


import com.sugar.bakers.company.adapter.in.OrderInputPort;
import com.sugar.bakers.company.adapter.out.OrderOutputPort;
import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.Order;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class OrderCakeUseCase implements OrderInputPort {

    @NonNull
    private OrderOutputPort orderOutputPort;

    @Override
    public Order.OrderId placeOrder(OrderEntry orderEntry) {
        // do some nice stuff for this UseCase
        Customer customer = loadCustomer(orderEntry.getCustomerId());
        Cake cake = loadCake(orderEntry.getCakeId());
        Order order = new Order(cake, customer);

        // ... do more stuff ... :-)

        return orderOutputPort.save(order);
    }


    // TODO: Repositories implementieren
    private Customer loadCustomer(Customer.CustomerId customerId){
        Customer customer = new Customer("MaZe");
        customer.setCustomerId(customerId);
        return customer;
    }

    private Cake loadCake(Cake.CakeId cakeId){
        Cake cake = new Cake("Apple Pie");
        cake.setCakeId(cakeId);
        return cake;
    }
}
