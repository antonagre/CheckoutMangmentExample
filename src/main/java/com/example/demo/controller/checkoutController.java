package com.example.demo.controller;

import com.example.demo.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/checkout")
public class checkoutController {
    @Autowired
    CheckoutService service;

    @GetMapping("/order/get")
    public ResponseEntity getOrder(@RequestParam String id){
        System.out.println("prima");
        ResponseEntity res = ResponseEntity.ok(service.getOrder(id));
        System.out.println("dopo");
        return res;
    }

    @PostMapping("/order/create")
    public ResponseEntity createOrder(@RequestParam String id){
        System.out.println("prima");
        ResponseEntity res = service.createOrder(id);
        System.out.println("dopo");
        return res;
    }

    @PostMapping("/order/add")
    public ResponseEntity addOrder(@RequestParam String id,String name){
        System.out.println("prima");
        ResponseEntity res = service.addOrder(id,name);
        System.out.println("dopo");
        return res;
    }
}
