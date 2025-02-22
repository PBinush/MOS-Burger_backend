package edu.example.entity;

import edu.example.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "order_details")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private OrderEntity orderId;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;
    private Integer qtyOnHand;
    private Double unitPrice;
    private Double price;
}
