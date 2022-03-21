package com.softvision.demo.spring.cloud.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "${customer.service.url}")
public interface CustomerServiceProxy {

    @GetMapping("/customers/{id}")
    Customer retrieve(@PathVariable int id);
}
