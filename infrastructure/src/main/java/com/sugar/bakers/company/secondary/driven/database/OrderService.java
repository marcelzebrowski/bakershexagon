package com.sugar.bakers.company.secondary.driven.database;

import com.sugar.bakers.company.adapter.out.OrderOutputPort;
import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.Order;
import com.sugar.bakers.company.secondary.driven.database.entity.CakeEntity;
import com.sugar.bakers.company.secondary.driven.database.entity.CustomerEntity;
import com.sugar.bakers.company.secondary.driven.database.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class OrderService implements OrderOutputPort {

    private OrderRepository orderRepository;

    @Override
    public Order.OrderId save(Order order) {
        log.info("Hello from save" + order.toString());
        OrderEntity result = orderRepository.save(mapToEntity(order));
        Order.OrderId orderId = new Order.OrderId(result.getId());
        return orderId;
    }

    @Override
    public List<Order> findAll() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        for(OrderEntity oe : orderEntities){
            orders.add(mapToDomain(oe));
        }
        return orders;
    }

    private Order mapToDomain(OrderEntity oe) {
        CustomerEntity customerEntity = oe.getCustomerEntity();
        CakeEntity cakeEntity = oe.getCakeEntity();

        Customer customer = new Customer(customerEntity.getName());
        customer.setCustomerId(new Customer.CustomerId(customerEntity.getId()));

        Cake cake = new Cake(cakeEntity.getName(), cakeEntity.getPicture());
        cake.setCakeId(new Cake.CakeId(cakeEntity.getId()));

        Order order = new Order(cake, customer);
        order.setOrderId(new Order.OrderId(oe.getId()));

        return order;
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
