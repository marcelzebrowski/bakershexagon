package com.sugar.bakers.company.infrastructure.database;


import com.sugar.bakers.company.infrastructure.database.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
