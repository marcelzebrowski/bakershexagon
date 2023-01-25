package com.sugar.bakers.company.secondary.driven.database;

import com.sugar.bakers.company.secondary.driven.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
