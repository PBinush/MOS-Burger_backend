package edu.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    private String orderId;
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customerId;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderDetailEntity> orderDetailList;
}
