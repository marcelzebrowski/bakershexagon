package com.sugar.bakers.company.domain;

import lombok.*;

import java.util.Optional;

@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class Order {
    @Value
    public static class OrderId{
        Long id;
        public OrderId(Long id){
            this.id = id;
        }
        public Long getId(){
            return id;
        }
    }

    private OrderId orderId;
    @NonNull
    private Cake cake;
    @NonNull
    private Customer customer;

    public Optional<OrderId> getId(){
        return Optional.ofNullable(this.orderId);
    }
}

