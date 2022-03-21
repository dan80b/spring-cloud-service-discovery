package com.softvision.demo.spring.cloud.orderservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderConfig orderConfig;
    private final RestTemplate restTemplate;

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
        Map<String, Integer> uriVariables = new HashMap<>();
        uriVariables.put("id", customerId);
        try {
            ResponseEntity<Customer> responseEntity = restTemplate
                    .getForEntity(orderConfig.getCustomerServiceUrl(), Customer.class, uriVariables);
            return responseEntity.getBody();
        } catch (ResourceAccessException e) {
            return null;
        }
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
