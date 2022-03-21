package com.softvision.demo.spring.cloud.customerservice;

import org.springframework.data.jpa.repository.JpaRepository;

interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
