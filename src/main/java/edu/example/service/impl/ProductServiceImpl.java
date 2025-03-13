package edu.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.entity.ProductEntity;
import edu.example.model.Product;
import edu.example.repository.ProductRepository;
import edu.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    final ProductRepository productRepository;
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public boolean saveProduct(Product product) {
        try {
            productRepository.save(objectMapper.convertValue(product, ProductEntity.class));
            return true;
        }catch (Exception e){
            log.info(" save error massage : "+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        try {
            productRepository.save(objectMapper.convertValue(product, ProductEntity.class));
            return true;
        }catch (Exception e){
            log.info("update error massage : "+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteProduct(String id) {
        return false;
    }

    @Override
    public Product getProductById(String id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Product> getProductByName(String name) {
        return List.of();
    }
}
