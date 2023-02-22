package com.sugar.bakers.company.secondary.driven.database.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cake_entity")
public class CakeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String picture;

    @NonNull
    @Column
    private String description;

}
