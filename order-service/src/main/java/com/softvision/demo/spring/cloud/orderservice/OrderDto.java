package com.softvision.demo.spring.cloud.orderservice;

import lombok.Data;

@Data
public class OrderDto {

    private int id;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private double totalAmount;
}
