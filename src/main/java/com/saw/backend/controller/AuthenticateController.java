package com.saw.backend.controller;

import com.saw.backend.dto.AuthenticationRequestDTO;
import com.saw.backend.dto.AuthenticationResponseDTO;
import com.saw.backend.dto.RegisterRequestDTO;
import com.saw.backend.service.auth.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticateController {

    private final AuthenticationService service;

    public AuthenticateController(final AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(final @RequestBody RegisterRequestDTO registerRequest) {
        return ResponseEntity.ok(service.register(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            final @RequestBody AuthenticationRequestDTO request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
