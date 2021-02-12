package com.example.demo.service;


import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class SCheckoutService {
    @Autowired
    IProductRepository productRepository;

    @Autowired
    IOrderRepository orderRepository;

    public int getOrderTotal(int id){
        System.out.println("Iddd"+id);
        Order o = orderRepository.findDistinctByOrderId(String.valueOf(id));
        List<Product> cart = o.getCart();
        int total=0;
        for (Product p: cart ) {
            total+=p.getPrezzo();
        }
        o.setTotal(total);
        System.out.println("Iddd"+total);
        return o.getTotal();
    }

    public orderspace.Order getOrder(String id){
        Order o = orderRepository.findDistinctByOrderId(id);
        return convertToOrder(o);
    }

    public orderspace.Order createOrder(String id){
        Order o;
        if(!orderRepository.existsOrderByOrderId(id)) o = orderRepository.save(Order.builder().orderId(id).cart(new ArrayList<Product>()).total(0).build());
        else o = orderRepository.findDistinctByOrderId(id);
        return convertToOrder(o);
    }

    public orderspace.Order addProductToOrder(String id, String name){
        Order o = orderRepository.findDistinctByOrderId(id);
        Product p = productRepository.findDistinctByNameLike(name);
        if(productRepository.existsProductByNameLike(name)){
            List<Product> cart = o.getCart();
            cart.add(p);
            o.setCart(cart);
            o.setTotal(o.getTotal()+p.getPrezzo());
        } else {
            System.out.println("Errore il prodotto non esiste");
        }
        orderRepository.save(o);

        return convertToOrder(o);
    }

    public orderspace.Product addNewProduct(String name,int prezzo){
        if(!productRepository.existsProductByNameLike(name)) {
            Product p = Product.builder().name(name).prezzo(prezzo).build();
            productRepository.save(p);
            return convertToProduct(p);
        } else {
            System.out.println("Errore il prodotto esiste gia");
            return null;
        }
    }

    private orderspace.Order convertToOrder(Order o){
        orderspace.Order order=new orderspace.Order();
        order.setTotal(o.getTotal());
        order.setId(Integer.parseInt(o.getOrderId()));
        for(Product p : o.getCart()){
            order.getProducts().add(convertToProduct(p));
        }
        return order;
    }

    private orderspace.Product convertToProduct(Product p){
        return orderspace.Product.builder().id(Integer.parseInt(p.getId())).name(p.getName()).prezzo(p.getPrezzo()).build();
    }

}

