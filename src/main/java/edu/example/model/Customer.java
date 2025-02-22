package edu.example.model;

import lombok.*;
import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String postalCode;

    @NotNull
    @Pattern("\\d{10}")
    private String contact;
}
