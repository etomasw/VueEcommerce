package io.ernest.service;

import io.ernest.model.Category;
import io.ernest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Long id, Category category) {
        Category cat = categoryRepository.findById(id).orElse(null);
        cat.setCategoryName(category.getCategoryName());
        cat.setDescription(category.getDescription());
        cat.setImageUrl(category.getImageUrl());
        categoryRepository.save(cat);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
