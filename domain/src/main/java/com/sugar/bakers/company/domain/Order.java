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

        Boolean isNull;

        public OrderId(Long id){
            this.id = id;
            this.isNull = Boolean.FALSE;
        }

        public OrderId(Boolean isNull){
            this.id = -1L;
            this.isNull = isNull;
        }
        public Long getId(){
            return id;
        }

        public Boolean getIsNull(){
            return isNull;
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

