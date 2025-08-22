package com.floproje.StokYonetim.controller;

import com.floproje.StokYonetim.dto.LoginRequest;
import com.floproje.StokYonetim.dto.RegisterRequest;
import com.floproje.StokYonetim.security.service.AuthService; // düzeltildi
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    // giriş endpointi
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return ResponseEntity.ok(token);
    }

    // kayıt endpointi
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }
}
