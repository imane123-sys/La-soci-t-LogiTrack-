package org.example.logitrack.controller;



import lombok.RequiredArgsConstructor;
import org.example.logitrack.dtos.AuthenticationRequest;
import org.example.logitrack.dtos.AuthenticationResponse;
import org.example.logitrack.dtos.UserRegistrationDTO;
import org.example.logitrack.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRegistrationDTO request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}