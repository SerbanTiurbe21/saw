package com.saw.backend.controller;

import com.saw.backend.dto.UserDTO;
import com.saw.backend.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(final @RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(final @PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(final @PathVariable Integer id, final @RequestBody UserDTO user) {
        final UserDTO existingUser = userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setName(user.getName());
        return ResponseEntity.ok(userService.saveUser(existingUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(final @PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully!");
    }
}
