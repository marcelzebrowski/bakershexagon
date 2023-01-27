package com.sugar.bakers.company.adapter.in;

import com.sugar.bakers.company.domain.Cake;

import java.util.List;
import java.util.Optional;


// Golden Hammer Example
public interface CakeReaderPort {
    List<Cake> findAll();

    Optional<Cake> finById(Cake.CakeId cakeId);
}
