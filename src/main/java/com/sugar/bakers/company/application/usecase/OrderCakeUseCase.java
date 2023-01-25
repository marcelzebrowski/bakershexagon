package com.sugar.bakers.company.application.usecase;


import com.sugar.bakers.company.adapter.in.OrderInputPort;
import com.sugar.bakers.company.adapter.in.OrderReaderPort;
import com.sugar.bakers.company.adapter.out.CakeOutputPort;
import com.sugar.bakers.company.adapter.out.CustomerOutputPort;
import com.sugar.bakers.company.adapter.out.OrderOutputPort;
import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.Order;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class OrderCakeUseCase implements OrderInputPort, OrderReaderPort { // solid - dependency inversion principle

    @NonNull
    private OrderOutputPort orderOutputPort;

    @NonNull
    private CakeOutputPort cakeOutputPort;

    @NonNull
    private CustomerOutputPort customerOutputPort;

    @Override
    public Order.OrderId placeOrder(OrderEntry orderEntry){
        // do some nice stuff for this UseCase
        Optional<Customer> customer = loadCustomer(orderEntry.getCustomerId());
        Optional<Cake> cake = loadCake(orderEntry.getCakeId());

        // do something more ...

        // and more ...

        /*
            There are only 10 kinds of people in this world: those who know binary and those who don’t.

            “Knock, knock.”
            “Who’s there?”
            very long pause….
            “Java.”

            #include <stfio.h>
            int main(void){
                int count;
                for(count=1; count <= 500; count++){
                    printf("I will not throw paper airplanes in class.")
                }
                return 0;
            }
         */

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
