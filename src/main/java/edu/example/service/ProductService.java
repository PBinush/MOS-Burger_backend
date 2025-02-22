package edu.example.service;

import edu.example.model.Product;

public interface ProductService {
    boolean saveProduct(Product product);
    boolean updateProduct(Product product);
}
