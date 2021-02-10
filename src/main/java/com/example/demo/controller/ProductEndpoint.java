package com.example.demo.controller;

import com.example.springsoap.gen.GetProductRequest;
import com.example.springsoap.gen.GetProductResponse;
import com.example.demo.repository.SProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "wathever";

    private SProductRepository productRepository;

    @Autowired
    public ProductEndpoint(SProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProduct(@RequestPayload GetProductRequest request) {
        System.out.println("Prima della request");
        GetProductResponse response = new GetProductResponse();
        response.setProduct(productRepository.findProduct(request.getName()));
        System.out.println("Dopo la request");
        return response;
    }
}
