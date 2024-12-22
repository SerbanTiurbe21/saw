package com.saw.backend.controller;

import com.saw.backend.dto.CategoryDTO;
import com.saw.backend.service.category.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO category) {
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id).orElseThrow(() -> new RuntimeException("Category not found")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO category) {
        final CategoryDTO existingCategory = categoryService.getCategoryById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setDescription(category.getDescription());
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully!");
    }
}
