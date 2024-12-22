package com.saw.backend.service.user;

import com.saw.backend.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO saveUser(UserDTO user);
    List<UserDTO> getAllUsers();
    Optional<UserDTO> getUserById(Integer userId);
    void deleteUser(Integer userId);
}
