package edu.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private String postalCode;
    private String contact;

    @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderEntity> orderEntityList;
}
