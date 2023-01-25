package com.sugar.bakers.company.secondary.driven.database;

import com.sugar.bakers.company.secondary.driven.database.entity.CakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends JpaRepository<CakeEntity,Long> {
}
