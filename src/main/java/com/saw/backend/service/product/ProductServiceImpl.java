package com.saw.backend.service.product;

import com.saw.backend.dto.ProductDTO;
import com.saw.backend.dto.ProductDetailDTO;
import com.saw.backend.repository.ProductDetailRepository;
import com.saw.backend.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;

    public ProductServiceImpl(final ProductRepository productRepository, ProductDetailRepository productDetailRepository) {
        this.productRepository = productRepository;
        this.productDetailRepository = productDetailRepository;
    }

    @Override
    @Transactional
    public ProductDTO saveProduct(final ProductDTO product) {
        product.getProductDetails().forEach(productDetail -> productDetail.setProduct(product));
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
    @Transactional
    public void deleteProduct(final Integer productId) {
        productRepository.deleteById(Math.toIntExact(productId));
        productDetailRepository.deleteByProductId(productId);
    }

    @Override
    public void updateProduct(final Integer productId, final ProductDTO product) {
        final ProductDTO existingProduct = productRepository.findByProductId(productId);
        if (existingProduct == null) {
            throw new RuntimeException("Product not found");
        }

        existingProduct.setProductName(product.getProductName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());

        updateProductDetails(existingProduct.getProductDetails(), product.getProductDetails());

        productRepository.save(existingProduct);
    }

    private void updateProductDetails(final List<ProductDetailDTO> existingDetails, final List<ProductDetailDTO> newDetails) {
        existingDetails.removeIf(detail -> !newDetails.contains(detail));

        // Update existing details and add new ones
        for (final ProductDetailDTO newDetail : newDetails) {
            int index = existingDetails.indexOf(newDetail);
            if (index != -1) {
                final ProductDetailDTO existingDetail = existingDetails.get(index);
                existingDetail.setAttribute(newDetail.getAttribute());
                existingDetail.setValue(newDetail.getValue());
            } else {
                existingDetails.add(newDetail);
            }
        }
    }
}
