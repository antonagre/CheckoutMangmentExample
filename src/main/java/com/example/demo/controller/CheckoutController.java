package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import com.example.demo.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    CheckoutService service;

    @GetMapping("/order/get")
    public ResponseEntity getOrder(@RequestParam String id){
        System.out.println("prima");
        ResponseEntity res = ResponseEntity.ok(service.getOrder(id));
        System.out.println("dopo");
        return res;
    }

    @GetMapping("/order/total/get")
    public int getOrderTotal(@RequestParam String id){
        System.out.println("prima");
        OrderDTO order = service.getOrder(id);
        System.out.println("dopo");
        return order.getTotal();
    }

    @PostMapping("/order/create")
    public ResponseEntity createOrder(@RequestParam String id){
        System.out.println("prima");
        ResponseEntity res = ResponseEntity.ok(service.createOrder(id));
        System.out.println("dopo");
        return res;
    }

    @PostMapping("/order/add")
    public ResponseEntity addOrder(@RequestParam String id,String name){
        System.out.println("prima");
        ResponseEntity res = ResponseEntity.ok(service.addProductToOrder(id,name));
        System.out.println("dopo");
        return res;
    }

    @PostMapping("/product/add")
    public ResponseEntity addProduct(@RequestParam String name,int prezzo){
        System.out.println("prima");
        ResponseEntity res = ResponseEntity.ok(service.addNewProduct(name,prezzo));
        System.out.println("dopo");
        return res;
    }
}
