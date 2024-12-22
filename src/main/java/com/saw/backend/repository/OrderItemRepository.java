package com.saw.backend.repository;

import com.saw.backend.dto.OrderItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemDTO, Integer> {
}
