package edu.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.entity.OrderDetailEntity;
import edu.example.entity.OrderEntity;
import edu.example.entity.ProductEntity;
import edu.example.model.Order;
import edu.example.model.OrderDetail;
import edu.example.repository.OrderDetailsRepository;
import edu.example.repository.OrderRepository;
import edu.example.repository.ProductRepository;
import edu.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    final OrderRepository orderRepository;
    final OrderDetailsRepository orderDetailsRepository;
    final ProductRepository productRepository;
    final ObjectMapper map;

    @Override
    public boolean placeOrder(Order order,List<OrderDetail> orderDetailList) {
        if (order == null || orderDetailList == null){
            return false;
        }

        OrderEntity isSavedOrder = orderRepository.save(map.convertValue(order, OrderEntity.class));
        if (isSavedOrder!=null){
            List<OrderDetailEntity> list = new ArrayList<>();
            orderDetailList.forEach(orderDetail -> {
                list.add(
                  map.convertValue(orderDetail,OrderDetailEntity.class)
                );
            });
            List<OrderDetailEntity> entities = orderDetailsRepository.saveAll(list);

            if (entities!=null){
                orderDetailList.forEach(orderDetail -> {
                    String productId = orderDetail.getProductId();
                    ProductEntity byId = productRepository.getById(productId);
                    byId.setQty(byId.getQty() - orderDetail.getQtyOnHand());
                    productRepository.save(byId);
                });
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean returnedOrder(String id) {
        return false;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orderList = orderRepository.findAll()
                .stream()
                .map(orderEntity -> map.convertValue(orderEntity, Order.class))
                .collect(Collectors.toList());
        if (orderList.isEmpty()){
            return null;
        }else {
            return orderList;
        }
    }
}
