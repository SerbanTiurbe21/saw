package com.saw.backend.service.product;

import com.saw.backend.dto.ProductDTO;
import com.saw.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO saveProduct(final ProductDTO product) {
        return productRepository.save(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDTO getProductById(final Integer productId) {
        return productRepository.findById(Math.toIntExact(productId)).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void deleteProduct(final Integer productId) {
        productRepository.deleteById(Math.toIntExact(productId));
    }

    @Override
    public List<ProductDTO> getProductsByCategoryName(final String categoryName) {
        return productRepository.findProductDTOByCategory_CategoryName(categoryName);
    }
}
