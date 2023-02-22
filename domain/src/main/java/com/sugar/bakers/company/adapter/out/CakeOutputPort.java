package com.sugar.bakers.company.adapter.out;

import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.CakeId;

import java.util.List;
import java.util.Optional;

public interface CakeOutputPort {
    List<Cake> findAll();

    Optional<Cake> finById(CakeId cakeId);
}
