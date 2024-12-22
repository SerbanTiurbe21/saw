package com.saw.backend.service.category;

import com.saw.backend.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    CategoryDTO saveCategory(CategoryDTO category);
    List<CategoryDTO> getAllCategories();
    Optional<CategoryDTO> getCategoryById(Integer categoryId);
    void deleteCategory(Integer categoryId);
}
