package com.softvision.demo.spring.cloud.customerservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
class CustomerController {

    private final CustomerRepository customerRepository;

    @Value("${instance.id}")
    private String instanceId;

    @GetMapping("/{id}")
    Customer getById(@PathVariable int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customer.setInstanceId(instanceId);
        return customer;
    }
}
