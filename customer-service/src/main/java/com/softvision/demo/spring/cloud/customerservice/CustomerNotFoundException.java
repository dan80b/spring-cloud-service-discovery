package com.softvision.demo.spring.cloud.customerservice;

class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(int customerId) {
        super("Could not find customer with " + customerId);
    }
}
