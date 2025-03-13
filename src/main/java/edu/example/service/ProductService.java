package edu.example.service;

import edu.example.model.Product;

import java.util.List;

public interface ProductService {
    boolean saveProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(String id);
    Product getProductById(String id);
    List<Product> getAllProduct();
    List<Product> getProductByCategory(String category);
    List<Product> getProductByName(String name);
}
