package io.ernest.controller;

import io.ernest.model.Category;
import io.ernest.repository.CategoryRepository;
import io.ernest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "CREATED";
    }

    @GetMapping("/list")
    public List<Category> listAll() {
        return categoryService.findAll();
    }

    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        categoryService.updateCategory(id, category);
        return "updated";
    }
}
