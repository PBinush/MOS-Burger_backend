package edu.example.service;

import edu.example.model.Product;

import java.util.List;

public interface ProductService {
    boolean saveProduct(Product product);
    boolean updateProduct(Product product);
    List<Product> getProductByCategory(String category);
    List<Product> getProductByName(String name);
    Product getProductById(String id);
    boolean deleteProduct(String id);
}
