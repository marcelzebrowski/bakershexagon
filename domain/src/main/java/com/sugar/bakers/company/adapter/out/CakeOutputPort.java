package com.sugar.bakers.company.adapter.out;

import com.sugar.bakers.company.domain.Cake;

import java.util.List;
import java.util.Optional;

public interface CakeOutputPort {
    List<Cake> findAll();

    Optional<Cake> finById(Cake.CakeId cakeId);
}
