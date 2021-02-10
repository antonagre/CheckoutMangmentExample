package com.example.demo.service;

import com.example.demo.dto.checkoutDTO;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckoutService {
    @Autowired
    IProductRepository productRepository;

    @Autowired
    IOrderRepository orderRepository;

    public checkoutDTO getOrder(String id){
        Order o = orderRepository.findDistinctByOrderId(id);
        List<Product> cart = o.getCart();
        int total=0;
        for (Product p: cart ) {
            total+=p.getPrezzo();
        }
        return checkoutDTO.builder().id(id).total(total).build();
    }

    public ResponseEntity createOrder(String id){
        ResponseEntity res = ResponseEntity.ok(orderRepository.save(Order.builder().orderId(id).cart(new ArrayList<Product>()).build()));
        return res;
    }

    public ResponseEntity addOrder(String id,String name){
        Order o = orderRepository.findDistinctByOrderId(id);
        Product p = productRepository.findDistinctByNameLike(name);
        if(productRepository.existsProductByNameLike(name)){
            List<Product> cart = o.getCart();
            cart.add(p);
            o.setCart(cart);
        } else {
        }
        ResponseEntity res = ResponseEntity.ok(orderRepository.save(o));
        return res;
    }

    public void addProduct(String name,int prezzo){
        if(!productRepository.existsProductByNameLike(name)) {
            Product p = Product.builder().name(name).prezzo(prezzo).build();
            productRepository.save(p);
        } else {
            System.out.println("Errore il prodotto esiste gia");
        }
    }
}
