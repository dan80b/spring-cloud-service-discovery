package com.softvision.demo.spring.cloud.orderservice;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private String address;
    private String phone;
}
