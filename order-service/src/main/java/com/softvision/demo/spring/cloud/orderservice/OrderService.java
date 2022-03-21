package com.softvision.demo.spring.cloud.orderservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerServiceProxy proxy;

    OrderDto getOrder(int orderId) {
        Order order = getOrderFromDb(orderId);
        Customer customer = getCustomerFromRemote(order.getCustomerId());
        return createOrder(orderId, order.getTotalAmount(), customer);
    }

    private Order getOrderFromDb(int orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    private Customer getCustomerFromRemote(int customerId) {
        return proxy.retrieve(customerId);
    }

    private OrderDto createOrder(int id, double totalAmount, Customer customer) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        orderDto.setTotalAmount(totalAmount);
        if (customer != null) {
            orderDto.setCustomerName(customer.getName());
            orderDto.setCustomerAddress(customer.getAddress());
            orderDto.setCustomerPhone(customer.getPhone());
        }
        return orderDto;
    }
}
