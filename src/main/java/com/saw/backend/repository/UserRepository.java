package com.saw.backend.repository;

import com.saw.backend.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Integer> {
    Optional<UserDTO> findByEmail(String email);
}
