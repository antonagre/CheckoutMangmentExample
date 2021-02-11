package com.example.demo.controller;

import com.example.demo.repository.SOrderRepository;
import com.example.demo.repository.SProductRepository;
import com.example.springsoap.gen.GetProductRequest;
import com.example.springsoap.gen.GetProductResponse;
import orderspace.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class OrderEndpoint {


    private static final String NAMESPACE_URI = "orderspace";

    private SOrderRepository orderRepository;

    @Autowired
    public OrderEndpoint(SOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createOrderRequest")
    @ResponsePayload
    public CreateOrderResponse createOrder(@RequestPayload CreateOrderRequest request) {
        CreateOrderResponse response = new CreateOrderResponse();
        response.setOrder(orderRepository.createOrder(request.getId()));
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddProductToOrderRequest")
    @ResponsePayload
    public AddProductToOrderResponse addProductToOrder(@RequestPayload AddProductToOrderRequest request) {
        AddProductToOrderResponse response = new AddProductToOrderResponse();
        response.setOrder(orderRepository.addProductToOrder(request.getProduct(), request.getId()));
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrderTotalRequest")
    @ResponsePayload
    public GetOrderTotalResponse getOrderTotal(@RequestPayload GetOrderTotalRequest request) {
        GetOrderTotalResponse response = new GetOrderTotalResponse();
        response.setTotal(orderRepository.getOrderTotal(request.getId()));
        return response;
    }





}
