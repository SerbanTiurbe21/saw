package com.saw.backend.repository;

import com.saw.backend.dto.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDTO, Long> {

}
