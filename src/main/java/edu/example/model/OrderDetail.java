package edu.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail {
    @NotNull
    private String orderId;

    @NotNull
    private String productId;
    private Integer qtyOnHand;
    private Double unitPrice;
    private Double price;
}
