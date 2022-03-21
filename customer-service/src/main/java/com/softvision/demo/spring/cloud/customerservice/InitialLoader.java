package com.softvision.demo.spring.cloud.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class InitialLoader {

    @Bean
    CommandLineRunner loadData(CustomerRepository repository) {
        return args -> {
            repository.save(new Customer(1, "Gerald Stanton", "1569 Bottom Lane, Buffalo, NY 14220", "716-821-3598"));
            repository.save(new Customer(2, "Robert McNary", "1737 Washington Avenue, Jackson, MS 39201", "601-979-5103"));
        };
    }
}
