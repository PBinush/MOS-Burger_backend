package edu.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.entity.ProductEntity;
import edu.example.model.Product;
import edu.example.repository.ProductRepository;
import edu.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    final ProductRepository productRepository;
    ObjectMapper map = new ObjectMapper();
    @Override
    public boolean saveProduct(Product product) {
        if (product == null){
            return false;
        }

        try {
            ProductEntity productEntity = map.convertValue(product, ProductEntity.class);
            productRepository.save(productEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        if (product == null){
            return false;
        }

        try {
            ProductEntity productEntity = map.convertValue(product, ProductEntity.class);
            productRepository.save(productEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        if (category == null || category.isEmpty()) {
            return Collections.emptyList();
        }

        return productRepository.findByCategory(category)
                .stream()
                .map(productEntity -> map.convertValue(productEntity, Product.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductByName(String name) {
        if (name == null || name.isEmpty()) {
            return Collections.emptyList();
        }

        return productRepository.findByName(name)
                .stream()
                .map(productEntity -> map.convertValue(productEntity, Product.class))
                .collect(Collectors.toList());
    }

    @Override
    public Product getProductById(String id) {
        if (id == null || id.isEmpty()){
            return null;
        }

        return map.convertValue(productRepository.findById(id),Product.class);
    }
}
