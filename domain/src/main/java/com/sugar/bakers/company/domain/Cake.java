package com.sugar.bakers.company.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Cake {
    @Value
    public static class CakeId{
        Long id;
        public CakeId(Long id){
            this.id = id;
        }
    }

    private CakeId cakeId;
    @NonNull
    private String name;
}