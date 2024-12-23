package com.saw.backend.service.category;

import com.saw.backend.dto.CategoryDTO;
import com.saw.backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO saveCategory(final CategoryDTO category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<CategoryDTO> getCategoryById(final Integer categoryId) {
        return Optional.ofNullable(categoryRepository.findById(Long.valueOf(categoryId)).orElseThrow(() -> new RuntimeException("Category not found")));
    }

    @Override
    public void deleteCategory(final Integer categoryId) {
        categoryRepository.deleteById(Long.valueOf(categoryId));
    }
}
