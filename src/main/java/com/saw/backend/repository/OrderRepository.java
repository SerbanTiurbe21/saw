package com.saw.backend.repository;

import com.saw.backend.dto.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<OrderDTO, Integer> {
}
