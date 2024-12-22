package com.saw.backend.repository;

import com.saw.backend.dto.ProductDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailDTO, Integer> {
}
