package com.saw.backend.service.product;

import com.saw.backend.dto.ProductDTO;
import com.saw.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO product) {
        return productRepository.save(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDTO getProductById(Integer productId) {
        return productRepository.findById(Math.toIntExact(productId)).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(Math.toIntExact(productId));
    }

    @Override
    public List<ProductDTO> getProductsByCategoryName(String categoryName) {
        return productRepository.findProductDTOByCategory_CategoryName(categoryName);
    }
}
