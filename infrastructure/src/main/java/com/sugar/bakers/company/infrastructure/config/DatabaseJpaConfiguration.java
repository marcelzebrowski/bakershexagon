package com.sugar.bakers.company.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.sugar.bakers.company.infrastructure")
@EnableTransactionManagement
@EntityScan("com.sugar.bakers.company.infrastructure.database.entity")
public class DatabaseJpaConfiguration {
    // You can use this if you would like to have a test database for your unit tests
}
