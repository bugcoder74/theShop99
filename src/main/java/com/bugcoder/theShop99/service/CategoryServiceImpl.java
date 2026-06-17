package com.bugcoder.theShop99.service;

import com.bugcoder.theShop99.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
        System.out.println("Category added Successfully "+nextId);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        try {
            Category category = categories.stream()
                    .filter(c -> c.getCategoryId().equals(categoryId))
                    .findFirst().orElseThrow();
            categories.remove(category);
        }
        catch (Exception e) {
            return "Error : " + e;
        }
        return "Successfully deleted the category with id : "+categoryId+" !";
    }
}
