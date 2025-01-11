package com.saw.backend.service.product;

import com.saw.backend.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO product);
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Integer productId);
    void deleteProduct(Integer productId);
    void updateProduct(Integer productId, ProductDTO product);
}
