package org.example.logitrack.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.logitrack.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterUser user){
        return ResponseEntity.ok(authService.addUser(user));
    }

    @PostMapping("/login")git
    public ResponseEntity<String>login(@Valid @RequestBody LoginUser user){
        return ResponseEntity.ok(authService.login(user.getEmail(),user.getPassword()));
    }






}
