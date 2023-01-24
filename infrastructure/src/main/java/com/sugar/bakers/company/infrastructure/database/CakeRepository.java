package com.sugar.bakers.company.infrastructure.database;

import com.sugar.bakers.company.infrastructure.database.entity.CakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends JpaRepository<CakeEntity,Long> {
}
