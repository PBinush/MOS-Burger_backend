package edu.example.controller;

import edu.example.model.Order;
import edu.example.model.OrderDetail;
import edu.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    final OrderService orderService;

    @PostMapping("/save")
    public String saveOrder(Order order, OrderDetail orderDetail){
        return "kk";
    }

}
