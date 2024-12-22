package com.saw.backend.repository;

import com.saw.backend.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductDTO, Integer> {
    List<ProductDTO> findProductDTOByCategory_CategoryName(String categoryName);
}
