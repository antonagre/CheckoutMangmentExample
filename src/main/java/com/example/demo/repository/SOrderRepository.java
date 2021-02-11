package com.example.demo.repository;


import orderspace.Order;
import orderspace.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class SOrderRepository {

    private static final Map<String, Order> orders = new HashMap<>();

    @PostConstruct
    public void initData() {

    }

    public Order createOrder(int id) {
        Order o = new Order();
        o.setId(id);
        o.setTotal(0);
        System.out.println(o.toString());
        return orders.put("order"+id,o);
    }

    public int getOrderTotal(int id){
        return orders.get("order"+id).getTotal();
    }


    public Order addProductToOrder(Product p, int id){
        System.out.println(p.toString());
        Order o = orders.get("order"+id);
        System.out.println(orders.toString());
        System.out.println(o.toString());
        o.getProducts().add(p);
        o.setTotal(o.getTotal()+p.getPrezzo());
        return o;
    }




}


