package com.sugar.bakers.company.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@NoArgsConstructor
public class Cake {
    @NonNull
    private CakeId cakeId;
    @NonNull
    private String name;

    @NonNull
    private String picture;

    @NonNull
    private String description;

}