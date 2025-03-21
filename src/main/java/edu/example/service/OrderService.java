package edu.example.service;

import edu.example.model.Order;
import edu.example.model.OrderDetail;

import java.util.List;

public interface OrderService {
    boolean placeOrder(Order order , List<OrderDetail> orderDetailList);
    boolean returnedOrder(String id);
    List<Order> getAllOrders();
}
