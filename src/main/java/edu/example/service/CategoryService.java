package edu.example.service;

import edu.example.model.Category;

import java.util.List;

public interface CategoryService {
    boolean addCategory(Category category);
    boolean deleteCategory(Integer id);
    List<Category> getAllCategory();
}
