package com.sugar.bakers.company.adapter.out;

import com.sugar.bakers.company.domain.Cake;

import java.util.List;

public interface CakeOutputPort {
    List<Cake> findAll();
}
