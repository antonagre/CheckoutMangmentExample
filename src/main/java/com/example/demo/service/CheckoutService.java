package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckoutService {
    @Autowired
    IProductRepository productRepository;

    @Autowired
    IOrderRepository orderRepository;

    public OrderDTO getOrderTotal(String id){
        Order o = orderRepository.findDistinctByOrderId(id);
        List<Product> cart = o.getCart();
        int total=0;
        for (Product p: cart ) {
            total+=p.getPrezzo();
        }
        o.setTotal(total);
        return convertToOrderDTO(o);
    }

    public OrderDTO getOrder(String id){
        Order o = orderRepository.findDistinctByOrderId(id);
        return convertToOrderDTO(o);
    }

    public OrderDTO createOrder(String id){
        Order o;
        if(!orderRepository.existsOrderByOrderId(id)) o = orderRepository.save(Order.builder().orderId(id).cart(new ArrayList<Product>()).total(0).build());
        else o = orderRepository.findDistinctByOrderId(id);
        return convertToOrderDTO(o);
    }

    public OrderDTO addProductToOrder(String id, String name){
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

        return convertToOrderDTO(o);
    }

    public ProductDTO addNewProduct(String name,int prezzo){
        if(!productRepository.existsProductByNameLike(name)) {
            Product p = Product.builder().name(name).prezzo(prezzo).build();
            productRepository.save(p);
            return convertToProductDTO(p);
        } else {
            System.out.println("Errore il prodotto esiste gia");
            return null;
        }
    }

    private OrderDTO convertToOrderDTO(Order o){
        return OrderDTO.builder().id(o.get_id()).cart(o.getCart()).total(o.getTotal()).build();
    }

    private ProductDTO convertToProductDTO(Product p){
        return ProductDTO.builder().id(p.getId()).name(p.getName()).prezzo(p.getPrezzo()).build();
    }

}
