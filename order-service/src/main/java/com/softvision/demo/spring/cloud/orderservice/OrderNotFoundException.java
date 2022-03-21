package com.softvision.demo.spring.cloud.orderservice;

class OrderNotFoundException extends RuntimeException {

    OrderNotFoundException(int orderId) {
        super("Could not find order with id " + orderId);
    }
}
