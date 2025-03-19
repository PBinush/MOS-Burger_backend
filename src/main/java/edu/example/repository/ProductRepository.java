package edu.example.repository;

import edu.example.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,String> {
    List<ProductEntity> findByCategory(String category);
    List<ProductEntity> findByName(String name);
}
