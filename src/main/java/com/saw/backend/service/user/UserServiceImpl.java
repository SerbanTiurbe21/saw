package com.saw.backend.service.user;

import com.saw.backend.dto.UserDTO;
import com.saw.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO saveUser(final UserDTO user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserDTO> getUserById(final Integer userId) {
        return Optional.ofNullable(userRepository.findById(Math.toIntExact(userId)).orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Override
    public void deleteUser(final Integer userId) {
        userRepository.deleteById(Math.toIntExact(userId));
    }
}
