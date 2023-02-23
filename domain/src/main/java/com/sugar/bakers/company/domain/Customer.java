package com.sugar.bakers.company.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@NoArgsConstructor
public class Customer {
    @NonNull
    private CustomerId customerId;
    @NonNull
    private String name;
}