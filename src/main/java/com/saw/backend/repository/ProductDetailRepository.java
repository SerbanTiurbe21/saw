package com.saw.backend.repository;

import com.saw.backend.dto.ProductDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailDTO, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM ProductDetailDTO pd WHERE pd.product.productId = :productId")
    void deleteByProductId(Integer productId);
}
