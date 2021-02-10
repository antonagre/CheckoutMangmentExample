package com.example.demo.controller;

import com.example.demo.repository.IOrderRepository;
import com.example.demo.repository.IProductRepository;
import com.example.demo.dto.checkoutDTO;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/checkout")
public class checkoutController {
    @Autowired
    IProductRepository productRepository;

    @Autowired
    IOrderRepository orderRepository;

    @GetMapping("/order/get")
    public ResponseEntity getOrder(@RequestParam String id){
        System.out.println("prima");
        ResponseEntity res = ResponseEntity.ok(checkoutDTO.builder().id(id).total(10).build());
        System.out.println("dopo");
        return res;
    }

    @PostMapping("/order/create")
    public ResponseEntity createOrder(@RequestParam String id){
        System.out.println("prima");
        ResponseEntity res = ResponseEntity.ok(orderRepository.save(Order.builder().orderId(id).cart(new ArrayList<Product>()).build()));
        System.out.println("dopo");
        return res;
    }

    @PostMapping("/order/add")
    public ResponseEntity addOrder(@RequestParam String id,String name){
        System.out.println("prima");
        Order o = orderRepository.findDistinctByOrderId(id);
        Product p = productRepository.findProductByName(name);
        List<Product> cart = o.getCart();
        cart.add(p);
        o.setCart(cart);
        ResponseEntity res = ResponseEntity.ok(orderRepository.save(o));
        System.out.println("dopo");
        return res;
    }
}
