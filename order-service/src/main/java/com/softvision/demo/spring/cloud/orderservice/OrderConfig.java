package com.softvision.demo.spring.cloud.orderservice;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class OrderConfig {

    @Value("${customer.service.url}")
    private String customerServiceUrl;
}
