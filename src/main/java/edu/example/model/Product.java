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
public class Product {
    @NotNull
    private String name;
    private Double price;
    private Integer discount;

    @NotNull
    private String img;

    @NotNull
    private String category;
}
