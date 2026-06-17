package com.bugcoder.theShop99.service;

import com.bugcoder.theShop99.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);
}
