package com.sugar.bakers.company.infrastructure.database;

import com.sugar.bakers.company.adapter.out.OrderOutputPort;
import com.sugar.bakers.company.domain.Order;
import com.sugar.bakers.company.infrastructure.database.entity.CakeEntity;
import com.sugar.bakers.company.infrastructure.database.entity.CustomerEntity;
import com.sugar.bakers.company.infrastructure.database.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService implements OrderOutputPort {

    private OrderRepository orderRepository;

    @Override
    public Order.OrderId save(Order order) {
        log.info("Hello from save" + order.toString());
        OrderEntity result = orderRepository.save(mapToEntity(order));
        Order.OrderId orderId = new Order.OrderId(result.getId());
        return orderId;
    }

    private OrderEntity mapToEntity(Order order) {

        CakeEntity cakeEntity = new CakeEntity();
        cakeEntity.setName(order.getCake().getName());
        cakeEntity.setId(order.getCake().getCakeId().getId());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(order.getCustomer().getName());
        customerEntity.setId(order.getCustomer().getCustomerId().getId());

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCakeEntity(cakeEntity);
        orderEntity.setCustomerEntity(customerEntity);

        return orderEntity;
    }
}
