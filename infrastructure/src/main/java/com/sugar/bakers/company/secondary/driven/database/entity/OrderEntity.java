package com.sugar.bakers.company.secondary.driven.database.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_entity")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    /*
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date order;*/

    @NonNull
    @ManyToOne
    @JoinColumn(name = "customer_entity_id", nullable = false)
    private CustomerEntity customerEntity;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "cake_entity_id", nullable = false)
    private CakeEntity cakeEntity;

}
