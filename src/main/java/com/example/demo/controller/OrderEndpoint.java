package com.example.demo.controller;

import com.example.demo.service.SCheckoutService;
import orderspace.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class OrderEndpoint {


    private static final String NAMESPACE_URI = "orderspace";



    @Autowired
    private SCheckoutService service;



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createOrderRequest")
    @ResponsePayload
    public CreateOrderResponse createOrder(@RequestPayload CreateOrderRequest request) {
        CreateOrderResponse response = new CreateOrderResponse();
        response.setOrder(service.createOrder(String.valueOf(request.getId())));
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddProductToOrderRequest")
    @ResponsePayload
    public AddProductToOrderResponse addProductToOrder(@RequestPayload AddProductToOrderRequest request) {
        AddProductToOrderResponse response = new AddProductToOrderResponse();
        response.setOrder(service.addProductToOrder(request.getProduct().getName(), String.valueOf(request.getId())));
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrderTotalRequest")
    @ResponsePayload
    public GetOrderTotalResponse getOrderTotal(@RequestPayload GetOrderTotalRequest request) {

        GetOrderTotalResponse response = new GetOrderTotalResponse();

        response.setTotal(service.getOrderTotal(request.getId()));

        return response;
    }





}
