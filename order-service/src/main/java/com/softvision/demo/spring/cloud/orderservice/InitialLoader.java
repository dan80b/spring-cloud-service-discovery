package com.softvision.demo.spring.cloud.orderservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class InitialLoader {

    @Bean
    CommandLineRunner loadData(OrderRepository repository) {
        return args -> {
            repository.save(new Order(1, 1, 100d));
            repository.save(new Order(2, 1, 200d));
            repository.save(new Order(3, 2, 150d));
        };
    }
}
