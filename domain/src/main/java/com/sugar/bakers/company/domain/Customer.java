package com.sugar.bakers.company.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Customer {
    @Value
    public static class CustomerId{
        Long id;
        public CustomerId(Long id){
            this.id = id;
        }
    }

    private CustomerId customerId;
    @NonNull
    private String name;


}