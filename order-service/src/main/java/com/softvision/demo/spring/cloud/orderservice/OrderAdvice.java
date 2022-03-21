package com.softvision.demo.spring.cloud.orderservice;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class OrderAdvice {

    @ResponseBody
    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String orderNotFoundHandler(OrderNotFoundException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String handleCustomerServiceException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        return e.getMessage();
    }
}
