package edu.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.entity.CategoryEntity;
import edu.example.model.Category;
import edu.example.repository.CategoryRepository;
import edu.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    final CategoryRepository categoryRepository;
    final ObjectMapper map;
    @Override
    public boolean addCategory(Category category) {
        if (category== null){
            return false;
        }

        try {
            CategoryEntity categoryEntity = map.convertValue(category, CategoryEntity.class);
            categoryRepository.save(categoryEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Integer id) {
        if (id == null){
            return false;
        }
        categoryRepository.deleteById(id);
        return !categoryRepository.existsById(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryEntity -> map.convertValue(categoryEntity, Category.class))
                .collect(Collectors.toList());
    }
}
