package com.example.controller;

import com.example.dto.OrderDTO;
import com.example.service.CheckoutService;
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
        int total = order.getTotal();
        System.out.println("dopo");
        return total;
    }

    @PostMapping("/order/create")
    public ResponseEntity createOrder(@RequestParam String id){
        System.out.println("prima");
        ResponseEntity res = ResponseEntity.ok(service.createOrder(id));
        System.out.println("dopo");
        return res;
    }

    @PostMapping("/order/remove")
    public String removeOrder(@RequestParam String id){
        System.out.println("prima");
        service.removeOrder(id);
        System.out.println("dopo");
        return "200";
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
