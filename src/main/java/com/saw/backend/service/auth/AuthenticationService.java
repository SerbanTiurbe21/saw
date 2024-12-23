package com.saw.backend.service.auth;

import com.saw.backend.config.JwtService;
import com.saw.backend.dto.AuthenticationRequestDTO;
import com.saw.backend.dto.AuthenticationResponseDTO;
import com.saw.backend.dto.RegisterRequestDTO;
import com.saw.backend.dto.UserDTO;
import com.saw.backend.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponseDTO register(final RegisterRequestDTO registerRequest) {
        final UserDTO user = new UserDTO();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        var token = jwtService.generateToken(user);

        final AuthenticationResponseDTO response = new AuthenticationResponseDTO();
        response.setAccessToken(token);

        return response;
    }

    public AuthenticationResponseDTO authenticate(final AuthenticationRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var token = jwtService.generateToken(user);

        final AuthenticationResponseDTO response = new AuthenticationResponseDTO();
        response.setAccessToken(token);

        return response;
    }
}
