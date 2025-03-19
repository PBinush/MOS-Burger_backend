package edu.example.service;

import edu.example.model.Order;
import java.util.List;

public interface OrderService {
    boolean placeOrder(Order order);
    List<Order> getAllOrders();
}
